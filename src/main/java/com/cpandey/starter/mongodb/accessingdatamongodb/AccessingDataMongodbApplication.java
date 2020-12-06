package com.cpandey.starter.mongodb.accessingdatamongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private VehicleRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Vehicle("Honda City", "Silver"));
		repository.save(new Vehicle("Ferrari", "Red"));

		// fetch all customers
		System.out.println("Vehicles found with findAll():");
		System.out.println("-------------------------------");
		for (Vehicle vehicle: repository.findAll()) {
			System.out.println(vehicle);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Vehicle found with findByModelName('Honda City'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByModelName("Honda City"));

		System.out.println("Customers found with findByColor('Red'):");
		System.out.println("--------------------------------");
		for (Vehicle vehicle : repository.findByColor("Red")) {
			System.out.println(vehicle);
		}

	}

}
