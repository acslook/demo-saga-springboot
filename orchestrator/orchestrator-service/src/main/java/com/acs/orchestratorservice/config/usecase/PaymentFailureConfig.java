package com.acs.orchestratorservice.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acs.orchestratorservice.adapters.out.SendSaleToTopicAdapter;
import com.acs.orchestratorservice.application.core.usecase.PaymentFailureUseCase;

@Configuration
public class PaymentFailureConfig {

	@Bean
	public PaymentFailureUseCase paymentFailureUseCase(
			SendSaleToTopicAdapter sendSaleToTopicAdapter) {
		return new PaymentFailureUseCase(sendSaleToTopicAdapter);
	}	
	
}
