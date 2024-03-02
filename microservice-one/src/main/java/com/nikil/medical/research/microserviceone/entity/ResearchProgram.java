package com.nikil.medical.research.microserviceone.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "research_program")
public class ResearchProgram {

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="program_id")
	private Integer programId;
	
	@Column(name="name",length=255,nullable=false)
	private String programName;
	
    @Temporal(TemporalType.DATE)
    @Column(name="date",nullable=false,updatable=false)
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
