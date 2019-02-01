package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllTrainees();
	
	String createTrainee(String trainee);
	
	String deleteTrainee(Long id);

	
//	//joining the tables
//	String getAllTraineesWithTrainers(Long id);
	
}