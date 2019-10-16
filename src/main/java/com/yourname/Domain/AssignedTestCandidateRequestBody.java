package com.yourname.Domain;

import java.util.ArrayList;

public class AssignedTestCandidateRequestBody {
	ArrayList<ResponseBodyCandidate> data = new ArrayList<ResponseBodyCandidate>();

	public ArrayList<ResponseBodyCandidate> getData() {
		return data;
	}

	public void setData(ArrayList<ResponseBodyCandidate> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AssignedTestCandidateRequestBody [data=" + data + "]";
	}

	
	
	
}
