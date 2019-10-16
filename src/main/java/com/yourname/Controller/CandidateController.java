package com.yourname.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yourname.Domain.AssignedTestCandidateRequestBody;
import com.yourname.Domain.AssignedTestCandidateResponse;
import com.yourname.Domain.RequestBodyCandidate;
import com.yourname.Domain.RequestBodyValidateCandidate;
import com.yourname.Domain.ResponseBodyCandidate;
import com.yourname.Domain.ResponseBodyValidateCandidate;
import com.yourname.Service.CandidateService;


@RestController
@RequestMapping("/candidate")
public class CandidateController {
	public static final int passLength=10;
	@Autowired
    CandidateService candidateService;
	
	@CrossOrigin
	@RequestMapping(value="/addCandidate", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addCandidate(@RequestBody RequestBodyCandidate candidate)
    {
		System.out.println(candidate.getEmail());
		if(candidateService.isEmailPresent(candidate)>0) {
//			String message = isValid > 0 ? "Candidate is Valid!":"Candidate is not valid!";
			return new ResponseEntity<>(new ResponseBodyValidateCandidate(0,"candidate email is already present!"), HttpStatus.OK);
		}
		else {
			String password=candidateService.passwordCreation(passLength);
	        candidateService.autoGeneratePassword(candidate,password);
	        return new ResponseEntity<>(new ResponseBodyValidateCandidate(1,"candidate added successfully!"), HttpStatus.OK);
		}      
    }
	
	@CrossOrigin
	@RequestMapping(value="", method=RequestMethod.GET)
	public List<ResponseBodyCandidate> getAllCandidates(){
		return candidateService.findAllCandidates();	
	}
	
	@CrossOrigin
	@RequestMapping(value="/validateCandidate", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> validationOfCandidate(@RequestBody RequestBodyValidateCandidate candidate)
    {
        Integer isValid=candidateService.validateCandidate(candidate);
        String message = isValid > 0 ? "Candidate is Valid!":"Candidate is not valid!";
        return new ResponseEntity<>(new ResponseBodyValidateCandidate(isValid,message), HttpStatus.OK);
    }
	
	@CrossOrigin
    @RequestMapping(value="/assignTest", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<AssignedTestCandidateResponse> assignTest(@RequestBody AssignedTestCandidateRequestBody req)
    {
		System.out.println(req);
		candidateService.saveSelectedCandidates(req);
    	return candidateService.findAllSelectedCandidate();
    }
	
	
	
}
