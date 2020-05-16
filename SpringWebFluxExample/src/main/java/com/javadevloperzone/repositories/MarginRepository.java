package com.javadevloperzone.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.javadevloperzone.entities.MarginDo;

public interface MarginRepository extends ReactiveMongoRepository<MarginDo, String> {
	
}
