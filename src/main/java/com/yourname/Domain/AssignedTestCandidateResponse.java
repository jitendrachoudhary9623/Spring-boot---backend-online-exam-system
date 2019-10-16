package com.yourname.Domain;

public class AssignedTestCandidateResponse {
	public int candidate_id;
	public int test_id;
	public int score;
	public String email_id;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getCandidate_id() {
		return candidate_id;
	}
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	public int getTest_id() {
		return test_id;
	}
	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "AssignedTestCandidateResponse [candidate_id=" + candidate_id + ", test_id=" + test_id + ", score="
				+ score + ", email_id=" + email_id + "]";
	}
	
	
	
	
}
