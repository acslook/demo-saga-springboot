package com.acs.orchestratorservice.application.core.usecase;

import com.acs.orchestratorservice.application.core.domain.Sale;
import com.acs.orchestratorservice.application.core.domain.enums.SaleEvent;
import com.acs.orchestratorservice.application.ports.in.WorkflowInputPort;
import com.acs.orchestratorservice.application.ports.out.SendSaleToTopicOutputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryPreparedUseCase implements WorkflowInputPort {

	private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;
	
	public InventoryPreparedUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {				
		this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;		
	}
	
	@Override
	public void execute(Sale sale) {
		log.info("Início do pagamento da venda.");
		sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_PAYMENT, "tp-saga-payment");
		log.info("Pagamento enviado para fila.");
	}

	@Override
	public boolean isCalledByTheEvent(SaleEvent saleEvent) {
		return SaleEvent.INVENTORY_PREPARED.equals(saleEvent);
	}

	
	
}
