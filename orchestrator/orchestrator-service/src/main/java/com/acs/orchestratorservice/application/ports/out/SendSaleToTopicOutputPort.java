package com.acs.orchestratorservice.application.ports.out;

import com.acs.orchestratorservice.application.core.domain.Sale;
import com.acs.orchestratorservice.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

	void send(Sale sale, SaleEvent saleEvent, String topic);
	
}
