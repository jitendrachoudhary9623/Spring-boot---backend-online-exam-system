package com.yourname.Domain;

public class RequestBodyValidateCandidate {
	public String email;
	public String password;
	
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
		return "RequestBodyValidateCandidate [email=" + email + ", password=" + password + "]";
	}	
}
