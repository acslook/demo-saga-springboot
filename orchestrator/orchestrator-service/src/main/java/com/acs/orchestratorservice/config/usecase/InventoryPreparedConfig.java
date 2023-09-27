package com.acs.orchestratorservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acs.orchestratorservice.adapters.out.SendSaleToTopicAdapter;
import com.acs.orchestratorservice.application.core.usecase.InventoryFailureUseCase;
import com.acs.orchestratorservice.application.core.usecase.InventoryPreparedUseCase;

@Configuration
public class InventoryPreparedConfig {

	@Bean
	public InventoryPreparedUseCase inventoryPreparedUseCase(
			SendSaleToTopicAdapter sendSaleToTopicAdapter) {
		return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
	}
	
}
