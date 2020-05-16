package com.javadevloperzone.entities;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document("MARGIN")
@Data
public class MarginDo {

	@Id
	@Field("CUSTOMER_ID")
	private String customerId;

	@Field("margin")
	private BigDecimal margin;

}
