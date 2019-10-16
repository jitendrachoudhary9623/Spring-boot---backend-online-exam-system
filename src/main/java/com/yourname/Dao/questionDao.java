package com.yourname.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yourname.Domain.Question;
import com.yourname.Interface.QuestionDaoInterface;

@Repository
public class questionDao implements QuestionDaoInterface {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Question> getQuestionList() {
		 return jdbcTemplate.query(SELECT_ALL, new RowMapper<Question>() {
			@Override
			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
                Question Question = new Question();
                Question.setId(rs.getInt("id"));
                Question.setQuestion(rs.getString("question"));
                Question.setOp1(rs.getString("op1"));
                Question.setOp2(rs.getString("op2"));
                Question.setOp3(rs.getString("op3"));
                Question.setOp4(rs.getString("op4"));
                Question.setAns_option(rs.getInt("ans_option"));
                Question.setIsselected(rs.getInt("is_selected")); 
                return Question;
			}		 
		 });
	}
	
	@Override
	public Question getQuestionById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[] { id },
                new BeanPropertyRowMapper<Question>(Question.class));
	}
	
	@Override
	public void deleteQuestionById(int id) {
		jdbcTemplate.update(DELETE_BY_ID, id);
	}

	@Override
	public void addQuestion(Question question) {
        jdbcTemplate.update(INSERT,
                question.getQuestion(), question.getOp1(),question.getOp2(),question.getOp3(),question.getOp4(),question.getAns_option(),question.getIsselected());
	}

	@Override
	public void updateQuestion(Question question) {
		jdbcTemplate.update(UPDATE,
                new Object[] {question.getQuestion(), question.getOp1(),question.getOp2(),question.getOp3(),question.getOp4(),question.getAns_option(),question.getIsselected(),question.getId()}); 
		
	}

	@Override
	public void resetIsSelected() {
		jdbcTemplate.update(RESET_ALL);		
	}

	@Override
	public void resetQuestion(int id) {
		jdbcTemplate.update(UPDATE_SELECTIONS, new Object[] {id});
	}
	
	
}
