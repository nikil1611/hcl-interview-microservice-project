package com.nikil.medical.research.microserviceone.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikil.medical.research.microserviceone.dto.ResearchProgramDto;
import com.nikil.medical.research.microserviceone.entity.ResearchProgram;
import com.nikil.medical.research.microserviceone.repository.ResearchProgramRepository;

@Service
public class ResearchProgramServiceImpl implements ResearchProgramService{

	@Autowired
	ResearchProgramRepository researchProgramRepository;
	
	@Autowired
	ResearchProgramMapper researchProgramMapper;
	
	@Override
	public ResearchProgramDto create(ResearchProgramDto researchProgramDto) {
		
		ResearchProgram researchProgram = researchProgramMapper.mapToEntity(researchProgramDto);
		researchProgram = researchProgramRepository.save(researchProgram);
		return researchProgramMapper.mapToDto(researchProgram);
		
	}

	@Override
	public ResearchProgramDto getResearchProgramById(int id) throws Exception {
		
		if(researchProgramRepository.findById(id).isPresent()) {
			ResearchProgramDto researchProgramDto  = researchProgramMapper.mapToDto(researchProgramRepository.findById(id).get());
			return researchProgramDto;
		}
		else {
			throw new Exception("No resource Found the id provided");
		}
		
	}

	@Override
	public List<ResearchProgramDto> getResearchPrograms() {
		return researchProgramRepository.findAll()
				.stream().map(researchProgram -> researchProgramMapper.mapToDto(researchProgram))
				.collect(Collectors.toList());
	}

	@Override
	public ResearchProgramDto update(int researchProgramId , ResearchProgramDto researchProgramDto) throws Exception {
		
		Optional<ResearchProgram> researchProgram  = researchProgramRepository.findById(researchProgramId);
		if(researchProgram.isPresent()) {
			researchProgramDto.setProgramId(researchProgram.get().getProgramId());
			ResearchProgram researchProgramEntity = researchProgramMapper.mapToEntity(researchProgramDto);
			researchProgramEntity = researchProgramRepository.save(researchProgramEntity);
			return researchProgramMapper.mapToDto(researchProgramEntity);
		}
		else {
			throw new Exception("No resource Found for the id to update ");
		}
		
	}

	@Override
	public void delete(int id) throws Exception {
		Optional<ResearchProgram> researchProgram  = researchProgramRepository.findById(id);
		
		if(researchProgram.isPresent()) {
			researchProgramRepository.delete(researchProgram.get());
		}
		else {
			throw new Exception("No resource found to delete for the id provided");
		}
	}

	
}
