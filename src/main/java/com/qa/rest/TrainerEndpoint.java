package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.TrainerService;


@Path("/trainer")
public class TrainerEndpoint {
	
	@Inject
	private TrainerService service;

	@Path("/getAllTrainers")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainers() {
		return service.getAllTrainers();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainer(String trainer) {
		return service.addTrainer(trainer);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainer(@PathParam("id") Long id) {
		return service.deleteTrainer(id);
	}

	public void setService(TrainerService service) {
		this.service = service;
	}

}
