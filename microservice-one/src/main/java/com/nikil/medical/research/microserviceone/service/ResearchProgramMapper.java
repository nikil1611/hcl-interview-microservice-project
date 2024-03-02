package com.nikil.medical.research.microserviceone.service;

import org.mapstruct.Mapper;

import com.nikil.medical.research.microserviceone.dto.ResearchProgramDto;
import com.nikil.medical.research.microserviceone.entity.ResearchProgram;

@Mapper(componentModel = "spring")
public interface ResearchProgramMapper {

	ResearchProgram mapToEntity(ResearchProgramDto dto);
	ResearchProgramDto mapToDto(ResearchProgram entity);
}
