package com.acs.orchestratorservice.application.core.domain;

import java.math.BigDecimal;

import com.acs.orchestratorservice.application.core.domain.enums.SaleStatus;

public class Sale {
	
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	
	public Sale(Integer id, Integer productId, Integer userId, BigDecimal value, SaleStatus status, Integer quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.value = value;
		this.status = status;
		this.quantity = quantity;
	}

	private Integer id;
	
	private Integer productId;
	
	private Integer userId;
	
	private BigDecimal value;
	
	private SaleStatus status;
	
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public SaleStatus getStatus() {
		return status;
	}

	public void setStatus(SaleStatus status) {
		this.status = status;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
