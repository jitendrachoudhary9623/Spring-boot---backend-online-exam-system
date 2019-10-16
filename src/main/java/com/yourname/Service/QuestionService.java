package com.yourname.Service;

import com.yourname.Dao.questionDao;
import com.yourname.Domain.Question;
import com.yourname.Domain.SaveSelectedQuestionsRequestModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Service
public class QuestionService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    questionDao qDao;
        
    public Question findById(int id) {
    	return qDao.getQuestionById(id);
    }

    public void deleteById(int id) {
    	qDao.deleteQuestionById(id);
    }

    public void add(Question question) {
    	qDao.addQuestion(question);
    }

    public void update(Question question)
    {
    	qDao.updateQuestion(question);
    }
    
    public void saveSelected(SaveSelectedQuestionsRequestModel req)
    {
    	qDao.resetIsSelected();
     if(req.getData() != null && req.getData().size() != 0) { 
    	 for(Integer id: req.getData()) 
    	 {
    		 System.out.println(id);
    		 qDao.resetQuestion(id);  
    	 } 		  
      }
    }
    
    public List<Question> findAll() {
    	return qDao.getQuestionList();
    }
}
    

