package com.javadevloperzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javadevloperzone.entities.MarginDo;
import com.javadevloperzone.repositories.MarginRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MarginController {

	@Autowired
	private MarginRepository marginRepository;

	// create margin
	@PostMapping("/createMargin")
	public Mono<MarginDo> createMargin(@RequestBody MarginDo marginDo) {
		return marginRepository.save(marginDo);
	}

	// update margin
	@PostMapping("/updateMargin")
	public void updateMargin(@RequestBody MarginDo marginDo) {
		marginRepository.save(marginDo);
	}

	// get margin by customer id
	@GetMapping("/getMargin/{customerId}")
	public Mono<MarginDo> getCustomerMargin(@PathVariable(value = "customerId") String customerId) {
		return marginRepository.findById(customerId);
	}

	// get all margins
	@GetMapping("/getAllMargins")
	public Flux<MarginDo> getAllMargins() {
		return marginRepository.findAll();
	}

	// delete margin by customer id
	@DeleteMapping("/deleteMargin/{customerId}")
	public void deleteMargin(@PathVariable(value = "customerId") String customerId) {
		marginRepository.deleteById(customerId);
	}

	// stream live margins
	@GetMapping(value = "/stream/margins", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<MarginDo> streamAllMargins() {		
		return marginRepository.findAll();
	}

}
