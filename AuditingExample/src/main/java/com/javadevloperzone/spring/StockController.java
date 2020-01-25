package com.javadevloperzone.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

	@Autowired
	private StockRepository stockRepository;

	@PostMapping("/saveStock")
	public String saveStock(@RequestBody StockDo stockDo) {

		stockRepository.save(stockDo);

		return "stock saved successfully";
	}

	@PostMapping("/updateStock")
	public String updateStock(@RequestBody StockDo stockDo) {

		stockRepository.save(stockDo);

		return "stock updated successfully";
	}

	@GetMapping("/getStock")
	public Iterable<StockDo> getStock() {
		return stockRepository.findAll();
	}

}
