package com.yourname.ServiceUnitTest;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import com.yourname.Dao.questionDao;
import com.yourname.Domain.Question;
import com.yourname.Domain.SaveSelectedQuestionsRequestModel;
import com.yourname.Service.QuestionService;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {
	@InjectMocks
    QuestionService questionService;
     
    @Mock
    questionDao qDao;
  
    @Test
    public void testFindAll()
    {
        List<Question> list = new ArrayList<>();
        Question question = new Question();
        question.setId(1);
        question.setQuestion("questionOne");
        question.setOp1("op11");
        question.setOp2("op21");
        question.setOp3("op31");
        question.setOp4("op41");
        question.setAns_option(1);
        question.setIsselected(0); 
        
        Question question1 = new Question();
        question1.setId(2);
        question1.setQuestion("questionTwo");
        question1.setOp1("op12");
        question1.setOp2("op22");
        question1.setOp3("op32");
        question1.setOp4("op42");
        question1.setAns_option(3);
        question1.setIsselected(1); 
         
        list.add(question);
        list.add(question1);       
        
        when(qDao.getQuestionList()).thenReturn(list);
        List<Question> quesList = questionService.findAll(); 
        verify(qDao,times(1)).getQuestionList();
        assertEquals(2, quesList.size());     
    }
    
    @Test
    public void testGetAllQuestionIfNoDataFound() {
    	List<Question> list = new ArrayList<>();
    	when(qDao.getQuestionList()).thenReturn(list);
    	List<Question> quesList = questionService.findAll();
    	verify(qDao,times(1)).getQuestionList();
    	assertEquals(0, quesList.size());
    }
    
    @Test
    public void findByIdTest() {
    	 Question question = new Question();
         question.setId(1);
         question.setQuestion("questionOne");
         question.setOp1("op11");
         question.setOp2("op21");
         question.setOp3("op31");
         question.setOp4("op41");
         question.setAns_option(1);
         question.setIsselected(0); 
         when(qDao.getQuestionById(1)).thenReturn(question);
         Question q=questionService.findById(1);
         assertEquals("questionOne",q.getQuestion());
         assertEquals("op11",q.getOp1());
         assertEquals("op21",q.getOp2());
         assertEquals("op31",q.getOp3());
         assertEquals("op41",q.getOp4());
         assertEquals(1,q.getAns_option());
         assertEquals(0,q.getIsselected());
         
    }
     
    
    @Test
    public void testAdd() {
    	Question question = new Question();
        question.setId(1);
        question.setQuestion("questionOne");
        question.setOp1("op11");
        question.setOp2("op21");
        question.setOp3("op31");
        question.setOp4("op41");
        question.setAns_option(1);
        question.setIsselected(0); 
        questionService.add(question);
        verify(qDao,times(1)).addQuestion(question);
    }
   
    
    @Test
    public void testDeleteById() {
    	Question question = new Question();
        question.setId(1);
        question.setQuestion("questionOne");
        question.setOp1("op11");
        question.setOp2("op21");
        question.setOp3("op31");
        question.setOp4("op41");
        question.setAns_option(1);
        question.setIsselected(1); 
        questionService.deleteById(1);
        verify(qDao,times(1)).deleteQuestionById(1);
    }
    
    @Test
    public void testSaveSelected() {
    	Question question = new Question();
        question.setId(1);
        question.setQuestion("questionOne");
        question.setOp1("op11");
        question.setOp2("op21");
        question.setOp3("op31");
        question.setOp4("op41");
        question.setAns_option(1);
        question.setIsselected(0); 
        
        Question question1 = new Question();
        question1.setId(2);
        question1.setQuestion("questionTwo");
        question1.setOp1("op12");
        question1.setOp2("op22");
        question1.setOp3("op32");
        question1.setOp4("op42");
        question1.setAns_option(3);
        question1.setIsselected(0); 
        
        ArrayList<Integer> list=new ArrayList<>();
        list.add(question.getId());
        list.add(question1.getId());
        SaveSelectedQuestionsRequestModel s=new SaveSelectedQuestionsRequestModel(list);
        questionService.saveSelected(s);
        qDao.resetIsSelected();
        verify(qDao,times(2)).resetIsSelected();
        for(Integer id: s.getData()) {
        	System.out.println(id);
        	verify(qDao,times(1)).resetQuestion(id);
        }      
    }
    
    @Test
    public void testUpdate() {
    	Question question = new Question();
        question.setId(1);
        question.setQuestion("questionOne");
        question.setOp1("op11");
        question.setOp2("op21");
        question.setOp3("op31");
        question.setOp4("op41");
        question.setAns_option(1);
        question.setIsselected(0); 
        questionService.update(question);
        verify(qDao,times(1)).updateQuestion(question);
    }
    
}
