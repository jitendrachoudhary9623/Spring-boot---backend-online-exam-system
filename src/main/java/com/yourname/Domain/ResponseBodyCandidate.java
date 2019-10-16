package com.yourname.Domain;

public class ResponseBodyCandidate {
	public int candidateId;
	public String email;
	public String password;
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ResponseBodyCandidate [candidateId=" + candidateId + ", email=" + email + ", password=" + password
				+ "]";
	} 
	
}
