package com.acs.orchestratorservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acs.orchestratorservice.adapters.out.SendSaleToTopicAdapter;
import com.acs.orchestratorservice.application.core.usecase.InventoryFailureUseCase;

@Configuration
public class InventoryFailureConfig {

	@Bean
	public InventoryFailureUseCase inventoryFailureUseCase(
			SendSaleToTopicAdapter sendSaleToTopicAdapter) {
		return new InventoryFailureUseCase(sendSaleToTopicAdapter);
	}
	
}
