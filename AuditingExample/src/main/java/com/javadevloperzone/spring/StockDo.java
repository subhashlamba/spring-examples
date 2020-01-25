package com.javadevloperzone.spring;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class StockDo extends Auditable<String> {

	@Id
	@GeneratedValue
	private Long itemId;

	private String itemName;

	private String availableUnits;
	

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getAvailbleUnits() {
		return availableUnits;
	}

	public void setAvailbleUnits(String availbleUnits) {
		this.availableUnits = availbleUnits;
	}

	@Override
	public String toString() {
		return "Stock [itemId=" + itemId + ", itemName=" + itemName + ", availbleUnits=" + availableUnits + "]";
	}

}
