package com.nikil.medical.research.microserviceone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikil.medical.research.microserviceone.entity.ResearchProgram;

@Repository
public interface ResearchProgramRepository extends JpaRepository<ResearchProgram, Integer>{

}
