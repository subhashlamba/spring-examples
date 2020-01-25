package com.javadevloperzone.spring;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_TAB")
public class OrderDo {

	@Id
	@GeneratedValue
	@Column(name = "ORDER_ID")
	private Long orderId;

	@Column(name = "ORDERED_BY")
	private String orderedBy;

	@Column(name = "ORDER_AT")
	private Date orderAt;

	@Column(name = "ORDERED_ITEM")
	private String orderedItem;

	@Column(name = "DELIVERY_ADRESS")
	private String deliveryAddress;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}

	public Date getOrderAt() {
		return orderAt;
	}

	public void setOrderAt(Date orderAt) {
		this.orderAt = orderAt;
	}

	public String getOrderedItem() {
		return orderedItem;
	}

	public void setOrderedItem(String orderedItem) {
		this.orderedItem = orderedItem;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "OrderDo [orderId=" + orderId + ", orderedBy=" + orderedBy + ", orderAt=" + orderAt + ", orderedItem="
				+ orderedItem + ", deliveryAddress=" + deliveryAddress + "]";
	}

}
