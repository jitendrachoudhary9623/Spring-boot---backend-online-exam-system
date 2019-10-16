package com.yourname.Controller;

import com.yourname.Domain.Question;
import com.yourname.Domain.SaveSelectedQuestionsRequestModel;
import com.yourname.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Question> getallQuestions()
    {
     return questionService.findAll();
    }


    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Question getQuestionById(@PathVariable("id") int id)
    {
        return questionService.findById(id);
    }


    @CrossOrigin
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable("id") int id)
    {
        questionService.deleteById(id);
    }

    @CrossOrigin
    @RequestMapping(value="/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateStudentById(@RequestBody Question ques)
    {
        questionService.update(ques);
        return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
    }
    
    
    @CrossOrigin
    @RequestMapping(value="/insert", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> insert(@RequestBody Question ques)
    {
        questionService.add(ques);
        return new ResponseEntity<>("Question added successfully", HttpStatus.OK);
    }
    
    @CrossOrigin
    @RequestMapping(value="/saveSelected", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Question> save(@RequestBody SaveSelectedQuestionsRequestModel req)
    {
    	questionService.saveSelected(req);
    	return questionService.findAll();
    }
}
