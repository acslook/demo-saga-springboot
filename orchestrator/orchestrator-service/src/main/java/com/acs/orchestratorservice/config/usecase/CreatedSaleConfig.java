package com.acs.orchestratorservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acs.orchestratorservice.adapters.out.SendSaleToTopicAdapter;
import com.acs.orchestratorservice.application.core.usecase.CreatedSaleUseCase;

@Configuration
public class CreatedSaleConfig {

	@Bean
	public CreatedSaleUseCase createdSaleUseCase(
			SendSaleToTopicAdapter sendSaleToTopicAdapter) {
		return new CreatedSaleUseCase(sendSaleToTopicAdapter);
	}
	
}
