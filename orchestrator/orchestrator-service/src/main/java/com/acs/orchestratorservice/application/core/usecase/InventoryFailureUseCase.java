package com.acs.orchestratorservice.application.core.usecase;

import com.acs.orchestratorservice.application.core.domain.Sale;
import com.acs.orchestratorservice.application.core.domain.enums.SaleEvent;
import com.acs.orchestratorservice.application.ports.in.WorkflowInputPort;
import com.acs.orchestratorservice.application.ports.out.SendSaleToTopicOutputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InventoryFailureUseCase implements WorkflowInputPort {

	private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;
	
	public InventoryFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {				
		log.info("Erro ao debitar estoque.");
		this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;		
		log.info("Cancelamento da venda postado na fila.");
	}
	
	@Override
	public void execute(Sale sale) {
		sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
	}

	@Override
	public boolean isCalledByTheEvent(SaleEvent saleEvent) {
		return SaleEvent.INVENTORY_ERROR.equals(saleEvent);
	}

	
	
}
