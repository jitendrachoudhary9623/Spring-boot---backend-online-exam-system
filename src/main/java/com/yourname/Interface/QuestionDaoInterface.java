package com.yourname.Interface;

import java.util.List;

import com.yourname.Domain.Question;

public interface QuestionDaoInterface {
	 	public String SELECT_ALL="SELECT * FROM OBJECTIVEQUESTION";
	    public String SELECT_BY_ID="SELECT * FROM OBJECTIVEQUESTION WHERE ID=?";
	    public String DELETE_BY_ID="DELETE FROM OBJECTIVEQUESTION WHERE ID=?";
	    public String INSERT="INSERT INTO OBJECTIVEQUESTION (ID, QUESTION,OP1,OP2,OP3,OP4,ANS_OPTION,IS_SELECTED) VALUES((SELECT MAX(ID) FROM OBJECTIVEQUESTION)+1,?,?,?,?,?,?,?)";
	    public String UPDATE="UPDATE OBJECTIVEQUESTION SET QUESTION = ?,OP1 = ?, OP2=?, OP3=?, OP4=?, ANS_OPTION=?, IS_SELECTED=? WHERE ID = ?";
	    public String RESET_ALL="UPDATE OBJECTIVEQUESTION SET IS_SELECTED = 0 WHERE IS_SELECTED = 1";
	    public String UPDATE_SELECTIONS="UPDATE OBJECTIVEQUESTION SET IS_SELECTED = 1 WHERE ID=?";
	    public String FETCH_ID="";
	    
	    public List<Question> getQuestionList();
	    public Question getQuestionById(int id);
	    public void deleteQuestionById(int id);
	    public void addQuestion(Question question);
	    public void updateQuestion(Question question);
	    
	    public void resetIsSelected();
	    public void resetQuestion(int id);
}
