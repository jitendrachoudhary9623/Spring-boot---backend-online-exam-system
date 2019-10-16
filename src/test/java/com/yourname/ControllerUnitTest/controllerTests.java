package com.yourname.ControllerUnitTest;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourname.Controller.QuestionController;
import com.yourname.Domain.Question;
import com.yourname.Service.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
public class controllerTests{
	private MockMvc mockMvc;
	
	@Mock QuestionService questionService;
	
	@InjectMocks
	QuestionController questionController;
	
	@Before
	public void setUp() {
		mockMvc=MockMvcBuilders.standaloneSetup(questionController).build();
	}
	
	@Test
	public void testGetAllQuestions() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/question").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void testInsert() throws Exception
	{
	  mockMvc.perform( MockMvcRequestBuilders
	      .post("/question/insert")
	      .content(asJsonString(new Question(1, "this is question", "option1", "option2"
	    		  ,"option3","option4",4,0)))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }}
	
	
	
}
