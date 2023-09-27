package com.acs.orchestratorservice.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.acs.orchestratorservice.adapters.out.message.SaleMessage;
import com.acs.orchestratorservice.application.core.domain.Sale;
import com.acs.orchestratorservice.application.core.domain.enums.SaleEvent;
import com.acs.orchestratorservice.application.ports.out.SendSaleToTopicOutputPort;

@Component
public class SendSaleToTopicAdapter implements SendSaleToTopicOutputPort {

	@Autowired
	private KafkaTemplate<String, SaleMessage> kafkaTemplate;
	
	@Override
	public void send(Sale sale, SaleEvent saleEvent, String topic) {
		var saleMessage = new SaleMessage(sale, saleEvent);		
		kafkaTemplate.send(topic, saleMessage);
	}

}
