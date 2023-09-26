package com.acs.orchestratorservice.application.core.usecase;

import com.acs.orchestratorservice.application.core.domain.Sale;
import com.acs.orchestratorservice.application.core.domain.enums.SaleEvent;
import com.acs.orchestratorservice.application.ports.in.WorkflowInputPort;
import com.acs.orchestratorservice.application.ports.out.SendSaleToTopicOutputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentFailureUseCase implements WorkflowInputPort {

	private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;
	
	public PaymentFailureUseCase(SendSaleToTopicOutputPort sendSaleToTopicOutputPort) {				
		this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
	}
	
	@Override
	public void execute(Sale sale) {
		log.info("Erro no pagamento.");
		sendSaleToTopicOutputPort.send(sale, SaleEvent.EXECUTE_ROLLBACK, "tp-saga-inventory");
		sendSaleToTopicOutputPort.send(sale, SaleEvent.CANCEL_SALE, "tp-saga-sale");
		log.info("Rollback do estoque e cancelamento da venda postado na fila.");
	}

	@Override
	public boolean isCalledByTheEvent(SaleEvent saleEvent) {
		return SaleEvent.PAYMENT_FAILED.equals(saleEvent);
	}

}
