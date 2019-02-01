package com.qa.persistence.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long trainerId;
	
	private String trainerName;
	
	private Integer ClassroomID;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "ClassroomID", cascade = CascadeType.ALL)
	private Collection<Classroom> trainees = new LinkedHashSet<Classroom>();


	public Trainer() {

	}

	public Trainer(String trainerName, Integer classroomID, Long trainerId) {
		this.trainerName = trainerName;
		this.ClassroomID = classroomID;
		this.trainerId = trainerId;
	}

	
	public Integer getClassroomID() {
		return ClassroomID;
	}

	public void setClassroomID(Integer classroomID) {
		ClassroomID = classroomID;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}
	
	

}
