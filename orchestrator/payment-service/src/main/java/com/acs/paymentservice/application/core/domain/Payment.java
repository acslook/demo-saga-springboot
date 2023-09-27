package com.acs.paymentservice.application.core.domain;

import java.math.BigDecimal;

public class Payment {

	public Payment() {
		
	}
	
	public Payment(Integer id, Integer userId, Integer saleId, BigDecimal value) {
		super();
		this.id = id;
		this.userId = userId;
		this.saleId = saleId;
		this.value = value;
	}

	private Integer id;
	
	private Integer userId;
	
	private Integer saleId;
	
	private BigDecimal value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSaleid() {
		return saleId;
	}

	public void setSaleid(Integer saleid) {
		this.saleId = saleid;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
