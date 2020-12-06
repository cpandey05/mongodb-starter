package com.cpandey.starter.mongodb.accessingdatamongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

	public Vehicle findByModelName(String modelName);
	public List<Vehicle> findByColor(String color);

}
