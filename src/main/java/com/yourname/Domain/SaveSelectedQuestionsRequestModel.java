package com.yourname.Domain;

import java.util.ArrayList;

public class SaveSelectedQuestionsRequestModel {
	ArrayList<Integer> data = new ArrayList<Integer>();

	public ArrayList<Integer> getData() {
		return data;
	}

	public void setData(ArrayList<Integer> data) {
		this.data = data;
	}
	
	public SaveSelectedQuestionsRequestModel() {}
	
	public SaveSelectedQuestionsRequestModel(ArrayList<Integer> data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "SaveSelectedQuestionsRequestModel [data=" + data + "]";
	}
	
	
}
