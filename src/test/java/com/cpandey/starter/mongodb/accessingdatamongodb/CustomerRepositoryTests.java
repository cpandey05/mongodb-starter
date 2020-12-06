package com.cpandey.starter.mongodb.accessingdatamongodb;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import com.cpandey.starter.mongodb.accessingdatamongodb.Vehicle;
import com.cpandey.starter.mongodb.accessingdatamongodb.VehicleRepository;

@SpringBootTest
public class CustomerRepositoryTests {

	@Autowired
	VehicleRepository repository;

	Vehicle honda, ferrari, toyota;

	@BeforeEach
	public void setUp() {

		repository.deleteAll();

		honda = repository.save(new Vehicle("Honda City", "Silver"));
		ferrari = repository.save(new Vehicle("Ferrari", "Red"));
		toyota = repository.save(new Vehicle("Toyota", "Red"));
	}

	@Test
	public void setsIdOnSave() {

		Vehicle honda = repository.save(new Vehicle("Honda City", "Silver"));

		assertThat(honda.id).isNotNull();
	}

	@Test
	public void findsByLastName() {

		List<Vehicle> result = repository.findByColor("Silver");

		assertThat(result).hasSize(1).extracting("modelName").contains("Ferrari");
	}

	@Test
	public void findsByExample() {

		Vehicle probe = new Vehicle(null, "Red");

		List<Vehicle> result = repository.findAll(Example.of(probe));

		assertThat(result).hasSize(2).extracting("modelName").contains("Ferrari", "Toyota");
	}
}
