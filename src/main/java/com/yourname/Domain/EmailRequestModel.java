package com.yourname.Domain;

public class EmailRequestModel {
	public String sendTo;
	public String nameOfTheCandidate;
	public String testUrl;
	public String username;
	public String password;
	
	public EmailRequestModel() {
		
	}
	
	public String getSendTo() {
		return sendTo;
	}
	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}
	public String getNameOfTheCandidate() {
		return nameOfTheCandidate;
	}
	public void setNameOfTheCandidate(String nameOfTheCandidate) {
		this.nameOfTheCandidate = nameOfTheCandidate;
	}
	public String getTestUrl() {
		return testUrl;
	}
	public void setTestUrl(String testUrl) {
		this.testUrl = testUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmailRequestModel(String sendTo, String nameOfTheCandidate, String testUrl, String username,
			String password) {
		super();
		this.sendTo = sendTo;
		this.nameOfTheCandidate = nameOfTheCandidate;
		this.testUrl = testUrl;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "EmailRequestModel [sendTo=" + sendTo + ", nameOfTheCandidate=" + nameOfTheCandidate + ", testUrl="
				+ testUrl + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
