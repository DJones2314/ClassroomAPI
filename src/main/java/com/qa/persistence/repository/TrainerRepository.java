package com.qa.persistence.repository;

public interface TrainerRepository {

	String getAllTrainers();
	
	String createTrainer(String trainee);
	
	String deleteTrainer(Long id);

}