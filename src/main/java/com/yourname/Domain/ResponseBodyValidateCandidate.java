package com.yourname.Domain;

public class ResponseBodyValidateCandidate {
	Integer isValidCandidate;
	String responseMsg;
	
	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public ResponseBodyValidateCandidate() {
		super();
	}

	public ResponseBodyValidateCandidate(Integer isValidCandidate, String responseMsg) {
		super();
		this.isValidCandidate = isValidCandidate;
		this.responseMsg = responseMsg;
	}

	public Integer getIsValidCandidate() {
		return isValidCandidate;
	}

	public void setIsValidCandidate(Integer isValidCandidate) {
		this.isValidCandidate = isValidCandidate;
	}
	
}
