package com.cpandey.starter.mongodb.accessingdatamongodb;

import org.springframework.data.annotation.Id;


public class Vehicle {

	@Id
	public String id;

	public String modelName;
	public String color;

	public Vehicle() {}

	public Vehicle(String modelName, String color) {
		this.modelName = modelName;
		this.color = color;
	}

	@Override
	public String toString() {
		return String.format(
				"Vehicle[id=%s, modelName='%s', color='%s']",
				id, modelName, color);
	}

}

