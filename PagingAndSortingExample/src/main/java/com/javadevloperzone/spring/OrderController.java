package com.javadevloperzone.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/saveOrders")
	public String saveOrder(@RequestBody List<OrderDo> orderList) {
		orderService.saveOrder(orderList);
		return "Orders saved successfully";
	}

	@GetMapping("/getAllOrders")
	public List<OrderDo> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/getOrdersWithPagination")
	public OrderUIDto getOrdersWithPagination(@RequestParam int pageNumber, @RequestParam int pageSize) {
		return orderService.getOrdersWithPagination(pageNumber, pageSize);
	}

	@GetMapping("/getLastThreeRecentOrders")
	public List<OrderDo> getLastThreeRecentOrders() {
		return orderService.getLastThreeRecentOrders();
	}

}
