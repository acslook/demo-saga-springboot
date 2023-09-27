package com.acs.orchestratorservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acs.orchestratorservice.adapters.out.SendSaleToTopicAdapter;
import com.acs.orchestratorservice.application.core.usecase.PaymentExecutedUseCase;

@Configuration
public class PaymentExecutedConfig {

	@Bean
	public PaymentExecutedUseCase paymentExecutedUseCase(
			SendSaleToTopicAdapter sendSaleToTopicAdapter) {
		return new PaymentExecutedUseCase(sendSaleToTopicAdapter);
	}
	
}
