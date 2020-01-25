package com.javadevloperzone.spring;

import java.util.List;

public class OrderUIDto {

	private Long numberOfElements;
	private int numberOfTotalPages;
	private List<OrderDo> orderDoList;
	private Boolean isFirst;
	private Boolean isLast;
	
	

	public Long getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(Long numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public int getNumberOfTotalPages() {
		return numberOfTotalPages;
	}

	public void setNumberOfTotalPages(int numberOfTotalPages) {
		this.numberOfTotalPages = numberOfTotalPages;
	}

	public List<OrderDo> getOrderDoList() {
		return orderDoList;
	}

	public void setOrderDoList(List<OrderDo> orderDoList) {
		this.orderDoList = orderDoList;
	}

	public Boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}

	public Boolean getIsLast() {
		return isLast;
	}

	public void setIsLast(Boolean isLast) {
		this.isLast = isLast;
	}

	@Override
	public String toString() {
		return "OrderUIDto [numberOfElements=" + numberOfElements + ", numberOfTotalPages=" + numberOfTotalPages
				+ ", orderDoList=" + orderDoList + ", isFirst=" + isFirst + ", isLast=" + isLast + "]";
	}

}
