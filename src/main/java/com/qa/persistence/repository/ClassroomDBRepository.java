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

//import com.qa.business.service.ClassroomService;
import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	@Override
	public String getAllTrainees() {
		Query query = manager.createQuery("Select a FROM Classroom a");
	  		return util.getJSONForObject(query.getResultList());
	          }
	


	
	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Classroom aTrainee = util.getObjectForJSON(trainee, Classroom.class);
		manager.persist(aTrainee);
		return "{\"message\": \"trainee has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Long id) {
		Classroom traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"trainee sucessfully deleted\"}";
	}

	private Classroom findTrainee(Long id) {
		return manager.find(Classroom.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
