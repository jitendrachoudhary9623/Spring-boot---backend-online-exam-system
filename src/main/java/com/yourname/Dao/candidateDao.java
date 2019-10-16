package com.yourname.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yourname.Domain.AssignedTestCandidateResponse;
import com.yourname.Domain.RequestBodyCandidate;
import com.yourname.Domain.RequestBodyValidateCandidate;
import com.yourname.Domain.ResponseBodyCandidate;
import com.yourname.Interface.CandidateDaoInterafce;

@Repository
public class candidateDao implements CandidateDaoInterafce {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void saveCandidateInfo(RequestBodyCandidate candidate, String password) {
		jdbcTemplate.update("insert into cdk_candidate(email_id,password) values ( ?,?)",
                new Object[] {candidate.getEmail(), password});			
	}

	@Override
	public List<ResponseBodyCandidate> getAllCandidates() {
		return jdbcTemplate.query(SELECT_ALL, new RowMapper<ResponseBodyCandidate>() {
			@Override
			public ResponseBodyCandidate mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ResponseBodyCandidate response=new ResponseBodyCandidate();
				response.setCandidateId(rs.getInt("candidate_id"));
				response.setEmail(rs.getString("email_id"));
				response.setPassword(rs.getString("password"));
				return response;
			}		
		});
	}

	@Override
	public Integer checkCandidateCredentials(RequestBodyValidateCandidate candidate) {
		Integer isAuthenticated = (Integer) jdbcTemplate.queryForObject(
				SELECT_AUTHENTICATED, new Object[] { candidate.getEmail(), candidate.getPassword() }, Integer.class);
		return isAuthenticated;
		
	}
	
	@Override
	public Integer isEmailAlreadyPresent(RequestBodyCandidate requested_candidate) {
		Integer isAlreadyPresent = (Integer) jdbcTemplate.queryForObject(
				CHECK_FOR_EMAIL_ALREADY_PRESENT, new Object[] { requested_candidate.getEmail() }, Integer.class);
		return isAlreadyPresent;
	}

	@Override
	public void saveSelectedCandidatesIntoDb(int id) {
		 jdbcTemplate.update(INSERT_ASSIGNED, new Object[] {id,test_id});
	}

	@Override
	public List<AssignedTestCandidateResponse> getAllselectedCandidates() {
		return jdbcTemplate.query(SELECT_ASSIGNED, new RowMapper<AssignedTestCandidateResponse>() {
			@Override
			public AssignedTestCandidateResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
				AssignedTestCandidateResponse response=new AssignedTestCandidateResponse();				
				response.setCandidate_id(rs.getInt("candidate_id"));
				response.setEmail_id(rs.getString("email_id"));
				response.setTest_id(rs.getInt("test_id"));
				response.setScore(rs.getInt("score"));
				return response;
			}		
		});
	}

		
}
