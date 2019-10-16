package com.yourname.ServiceUnitTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.yourname.Dao.candidateDao;
import com.yourname.Domain.RequestBodyCandidate;
import com.yourname.Domain.ResponseBodyCandidate;
import com.yourname.Service.CandidateService;

@RunWith(MockitoJUnitRunner.class)
public class CandidateServiceTest {
	@InjectMocks
	CandidateService candidateService;
	@Mock
	candidateDao cDao;
	
	@Test
	public void testFindAllCandidates() {
		List<ResponseBodyCandidate> list=new ArrayList<>();
		ResponseBodyCandidate candidate=new ResponseBodyCandidate();
		candidate.setCandidateId(1);
		candidate.setEmail("sanket@gmail.com");
		String password=candidateService.passwordCreation(10);
		candidate.setPassword(password);
		list.add(candidate);
		when(cDao.getAllCandidates()).thenReturn(list);
		List<ResponseBodyCandidate> candidateList=candidateService.findAllCandidates();
		verify(cDao,times(1)).getAllCandidates();
		assertEquals(1, candidateList.size());
	}
	
	@Test
    public void testFindAllCandidatesIfNoDataFound() {
    	List<ResponseBodyCandidate> list = new ArrayList<>();
    	when(cDao.getAllCandidates()).thenReturn(list);
    	List<ResponseBodyCandidate> candidateList = candidateService.findAllCandidates();
    	verify(cDao,times(1)).getAllCandidates();
    	assertEquals(0, candidateList.size());
    }
	
	@Test
	public void testAutoGeneratePassword() {
		RequestBodyCandidate candidate=new RequestBodyCandidate();
		candidate.setEmail("sanket@gmail.com");
		String password=candidateService.passwordCreation(10);
		candidateService.autoGeneratePassword(candidate, password);
		verify(cDao,times(1)).saveCandidateInfo(candidate, password);
	}
}
