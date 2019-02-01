package com.qa.business.service;

import javax.inject.Inject;


import com.qa.persistence.repository.TrainerRepository;


public class TrainerServiceImpl2 implements TrainerService {
	

	@Inject
	private TrainerRepository repo;

	public String getAllTrainers() {
		return repo.getAllTrainers();
	}

	public String addTrainer(String trainer) {
		return repo.createTrainer(trainer);
	}

	public String deleteTrainer(Long id) {
		return repo.deleteTrainer(id);
	}

	public void setRepo(TrainerRepository repo) {
		this.repo = repo;
	}

	
}
