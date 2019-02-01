package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Trainer;
//import com.qa.business.service.ClassroomService;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TrainerDBRepository implements TrainerRepository{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getAllTrainers() {
		Query query = manager.createQuery("Select a FROM Trainer a");
		List<Trainer> trainers = (List<Trainer>) query.getResultList();
		return util.getJSONForObject(trainers);
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainer(String trainer) {
		Trainer aTrainer = util.getObjectForJSON(trainer, Trainer.class);
		manager.persist(aTrainer);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainer(Long id) {
		Trainer trainerInDB = findTrainer(id);
		if (trainerInDB != null) {
			manager.remove(trainerInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}

	private Trainer findTrainer(Long id) {
		return manager.find(Trainer.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
