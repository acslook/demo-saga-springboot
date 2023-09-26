package com.acs.orchestratorservice.application.core.domain.enums;

public enum SaleEvent {

	CREATED_SALE,
	
	CANCEL_SALE,
	
	FINALIZE_SALE,
	
	PREPARE_INVENTORY,
	
	INVENTORY_PREPARED,
	
	EXECUTE_PAYMENT,
	
	EXECUTE_ROLLBACK,
	
	INVENTORY_ERROR,
	
	PAYMENT_EXECUTED,
	
	PAYMENT_FAILED,
	
}
