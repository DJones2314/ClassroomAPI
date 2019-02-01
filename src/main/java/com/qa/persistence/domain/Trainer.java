package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainer {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String trainerName;
	
	public Trainer() {

	}

	public Trainer(String trainerName) {
		this.trainerName = trainerName;
	}

	
	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String traineeName) {
		this.trainerName = trainerName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
