package com.nikil.medical.research.microserviceone.dto;

import java.util.Date;


public class ResearchProgramDto {

	
	private Integer programId;
	private String programName;
	private Date programDate;
	
	
	public Integer getProgramId() {
		return programId;
	}
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public Date getProgramDate() {
		return programDate;
	}
	public void setProgramDate(Date programDate) {
		this.programDate = programDate;
	}
	
	
	
}
