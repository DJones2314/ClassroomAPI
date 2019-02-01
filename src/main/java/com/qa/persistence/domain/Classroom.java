package com.qa.persistence.domain;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;


@Entity
public class Classroom {

	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long ClassroomID;

	private Long trainerId;
	
	

	
//	private List<Trainer> trainerList;
//
//	  public List<Trainer> getTrainerList() {
//	      return trainerList;
//	  }
//
//	  public void setTrainerList(List<Trainer> trainerList) {
//	      this.trainerList = trainerList;
//	  }

	  
	
	private String traineeName;
	
	public Classroom() {

	}

	public Classroom(String traineeName, Long ClassroomID, Long trainerId) {
		this.traineeName = traineeName;
		this.ClassroomID = ClassroomID;
		this.trainerId = trainerId;
	}

	
	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Long getClassroomID() {
		return ClassroomID;
	}

	public void setClassroomID(Long classroomID) {
		this.ClassroomID = classroomID;
	}

}
