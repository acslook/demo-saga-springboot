package com.acs.orchestratorservice.application.core.usecase;

import com.acs.orchestratorservice.application.core.domain.Sale;
import com.acs.orchestratorservice.application.core.domain.enums.SaleEvent;
import com.acs.orchestratorservice.application.ports.in.WorkflowInputPort;
import com.acs.orchestratorservice.application.ports.out.SendSaleToTopicOutputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreatedSaleUseCase implements WorkflowInputPort {

	private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;
	
	public CreatedSaleUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {		
		this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
	}

	@Override
	public void execute(Sale sale) {
		log.info("Início da separação do estoque");
		sendSaleToTopicOutputPort.send(sale, SaleEvent.PREPARE_INVENTORY, "tp-saga-inventory");
		log.info("Enviado para fila da separação do estoque");
	}

	@Override
	public boolean isCalledByTheEvent(SaleEvent saleEvent) {
		return SaleEvent.CREATED_SALE.equals(saleEvent);
	}

}
