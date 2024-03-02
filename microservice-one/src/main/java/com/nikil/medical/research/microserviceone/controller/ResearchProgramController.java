package com.nikil.medical.research.microserviceone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nikil.medical.research.microserviceone.dto.ResearchProgramDto;
import com.nikil.medical.research.microserviceone.service.ResearchProgramService;

@RestController
public class ResearchProgramController {

	@Autowired 
	ResearchProgramService researchProgramService;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	@PostMapping("/researchprogram")
	public ResponseEntity<ResearchProgramDto> createResearchProgram(@RequestBody ResearchProgramDto researchProgramDto) {
		ResearchProgramDto persitedResearchProgram = researchProgramService.create(researchProgramDto);
		return new ResponseEntity<>(persitedResearchProgram, HttpStatus.OK);
	}
	
	@GetMapping("/researchprogram")
	public ResponseEntity<List<ResearchProgramDto>> getResearchProgram() {
		List<ResearchProgramDto> researchProgramList = researchProgramService.getResearchPrograms();
		return new ResponseEntity<>(researchProgramList, HttpStatus.OK);
	}
	
	@GetMapping("/researchprogram/{id}")
	public ResponseEntity<ResearchProgramDto> getResearchProgramById(@PathVariable("id") int researchProgramId) {
		
		try {
			ResearchProgramDto researchProgram = researchProgramService.getResearchProgramById(researchProgramId);
			return new ResponseEntity<>(researchProgram, HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/researchprogram/{id}")
	public ResponseEntity<ResearchProgramDto> updateResearchProgram(@RequestBody ResearchProgramDto researchProgramDto , @PathVariable("id") int researchProgramId) {
		
		try {
			ResearchProgramDto persitedResearchProgram = researchProgramService.update(researchProgramId, researchProgramDto);
			return new ResponseEntity<>(persitedResearchProgram, HttpStatus.OK);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/researchprogram/{id}")
	public ResponseEntity<ResearchProgramDto> deleteResearchProgram( @PathVariable("id") int researchProgramId) {
		try {
			researchProgramService.delete(researchProgramId);
			
			HttpEntity<String> request = 
				      new HttpEntity<String>("RECORD WITH ID =" +researchProgramId+ " DELETED");
				    
				    String personResultAsJsonStr = 
				      restTemplate.postForObject("http://localhost:8081/publishMessage", request, String.class);
				 
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
}
