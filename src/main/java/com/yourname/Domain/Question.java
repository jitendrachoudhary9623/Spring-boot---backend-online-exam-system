package com.yourname.Domain;

import java.util.List;
import java.util.stream.Collector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String Question;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    private int ans_option;
    private int isselected;
	public Question(int i, String string, String string2, String string3, String string4, String string5, int j,
			int k) {
		// TODO Auto-generated constructor stub
		this.id=i;
		this.Question=string;
		this.op1=string2;
		this.op2=string3;
		this.op3=string4;
		this.op4=string5;
		this.ans_option=j;
		this.isselected=k;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public String getOp1() {
		return op1;
	}
	public void setOp1(String op1) {
		this.op1 = op1;
	}
	public String getOp2() {
		return op2;
	}
	public void setOp2(String op2) {
		this.op2 = op2;
	}
	public String getOp3() {
		return op3;
	}
	public void setOp3(String op3) {
		this.op3 = op3;
	}
	public String getOp4() {
		return op4;
	}
	public void setOp4(String op4) {
		this.op4 = op4;
	}
	public int getAns_option() {
		return ans_option;
	}
	public void setAns_option(int ans_option) {
		this.ans_option = ans_option;
	}
	public int getIsselected() {
		return isselected;
	}
	public void setIsselected(int isselected) {
		this.isselected = isselected;
	}
	public Object collect(Collector<Object, ?, List<Object>> list) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", Question=" + Question + ", op1=" + op1 + ", op2=" + op2 + ", op3=" + op3
				+ ", op4=" + op4 + ", ans_option=" + ans_option + ", isselected=" + isselected + "]";
	}
    

    

}

