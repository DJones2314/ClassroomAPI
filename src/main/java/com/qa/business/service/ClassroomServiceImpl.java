package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.ClassroomRepository;

public class ClassroomServiceImpl implements ClassroomService {
	

	@Inject
	private ClassroomRepository repo;

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String addTrainee(String trainee) {
		return repo.createTrainee(trainee);
	}

	public String deleteTrainee(Long id) {
		return repo.deleteTrainee(id);
	}

	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}
}
