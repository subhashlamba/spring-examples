package com.javadevloperzone.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	// save list of orders
	public void saveOrder(List<OrderDo> orderList) {
		for (OrderDo orderDo : orderList) {
			orderRepository.save(orderDo);
		}

	}

	// get All orders sort by ordered item
	public List<OrderDo> getAllOrders() {

		List<OrderDo> orderList = new ArrayList<>();
		Iterable<OrderDo> orderIterator = orderRepository.findAll(Sort.by("orderAt").descending());
		for (OrderDo order : orderIterator) {
			orderList.add(order);
		}

		return orderList;

	}

	// get orders with pagination
	public OrderUIDto getOrdersWithPagination(int pageNumber, int pageSize) {

		OrderUIDto orderUIDto = new OrderUIDto();

		Pageable paging = PageRequest.of(pageNumber, pageSize);
		Page<OrderDo> page = orderRepository.findAll(paging);
		// Slice<OrderDo> orderIterator = orderRepository.findAll(paging);

		if (page.hasContent()) {
			orderUIDto.setOrderDoList(page.getContent());
		} else {
			orderUIDto.setOrderDoList(new ArrayList<>());
		}
		
		orderUIDto.setNumberOfTotalPages(page.getTotalPages());
		orderUIDto.setNumberOfElements(page.getTotalElements());
		orderUIDto.setIsFirst(page.isFirst());
		orderUIDto.setIsLast(page.isLast());
		

		return orderUIDto;

	}

	// get last 3 recent orders
	public List<OrderDo> getLastThreeRecentOrders() {

		List<OrderDo> orderList = new ArrayList<>();

		Sort sort = Sort.by("orderAt").descending();
		Pageable paging = PageRequest.of(0, 3, sort);
		Iterable<OrderDo> orderIterator = orderRepository.findAll(paging);

		for (OrderDo order : orderIterator) {
			orderList.add(order);
		}

		return orderList;
	}

}
