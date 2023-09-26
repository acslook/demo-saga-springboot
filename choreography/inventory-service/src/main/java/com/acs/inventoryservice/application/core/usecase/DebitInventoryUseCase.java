package com.acs.inventoryservice.application.core.usecase;

import com.acs.inventoryservice.application.core.domain.Sale;
import com.acs.inventoryservice.application.core.domain.enums.SaleEvent;
import com.acs.inventoryservice.application.ports.in.DebitInventoryInputPort;
import com.acs.inventoryservice.application.ports.in.FindInventoryByProductIdInputPort;
import com.acs.inventoryservice.application.ports.out.SendToKafkaOutputPort;
import com.acs.inventoryservice.application.ports.out.UpdateInventoryOutputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebitInventoryUseCase implements DebitInventoryInputPort {
	
	private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
	
	private final UpdateInventoryOutputPort updateInventoryOutputPort;
	
	private final SendToKafkaOutputPort sendToKafkaOutputPort;
	
	public DebitInventoryUseCase(
			FindInventoryByProductIdInputPort findInventoryByProductIdInputPort,
			UpdateInventoryOutputPort updateInventoryOutputPort,
			SendToKafkaOutputPort sendToKafkaOutputPort) {
		this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
		this.updateInventoryOutputPort = updateInventoryOutputPort;
		this.sendToKafkaOutputPort = sendToKafkaOutputPort;
	}
	
	public void debit(Sale sale) {
		try {
			var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
			
			if(inventory.getQuantity() < sale.getQuantity()) {
				throw new RuntimeException("Estoque insuficiente.");
			}
			
			inventory.debitQuantity(sale.getQuantity());
			
			updateInventoryOutputPort.update(inventory);
			
			sendToKafkaOutputPort.send(sale, SaleEvent.UPDATED_INVENTORY);
		} catch (Exception e) {
			log.error("Houve um erro = {}", e.getMessage());
			sendToKafkaOutputPort.send(sale, SaleEvent.ROLLBACK_INVETORY);
		}
	}
	
}
