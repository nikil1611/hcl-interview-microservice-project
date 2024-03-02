package com.nikil.medical.research.microserviceone.service;

import java.util.List;

import com.nikil.medical.research.microserviceone.dto.ResearchProgramDto;

public interface ResearchProgramService {

	ResearchProgramDto create(ResearchProgramDto researchProgramDto);
	
	ResearchProgramDto getResearchProgramById(int id) throws Exception;
	
	List<ResearchProgramDto> getResearchPrograms();
	
	ResearchProgramDto update(int researchProgramId , ResearchProgramDto researchProgramDto ) throws Exception;
	
	void delete(int id) throws Exception;
	
}
