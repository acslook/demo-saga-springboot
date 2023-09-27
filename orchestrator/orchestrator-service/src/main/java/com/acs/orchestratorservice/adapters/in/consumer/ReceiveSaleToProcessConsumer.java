package com.acs.orchestratorservice.adapters.in.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

import com.acs.orchestratorservice.adapters.out.message.SaleMessage;
import com.acs.orchestratorservice.application.ports.in.WorkflowInputPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ReceiveSaleToProcessConsumer {

	@Autowired
	private List<WorkflowInputPort> workFlows;
	
	@KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
	public void receive(SaleMessage saleMessage) {
		var workflow = workFlows.stream()
				.filter(w -> w.isCalledByTheEvent(saleMessage.getEvent()))
				.findFirst()
				.orElse(null);
		
		if (workflow != null) {
			workflow.execute(saleMessage.getSale());
		} else {
			log.error("Evento não encontrado.");
		}
	}
	
}
