package com.acs.orchestratorservice.application.ports.in;

import com.acs.orchestratorservice.application.core.domain.Sale;
import com.acs.orchestratorservice.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {

	void execute(Sale sale);
	
	boolean isCalledByTheEvent(SaleEvent saleEvent);
	
}
