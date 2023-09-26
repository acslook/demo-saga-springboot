package com.acs.sale.application.core.usecase;

import com.acs.sale.application.core.domain.Sale;
import com.acs.sale.application.ports.in.FindSaleByIdInputPort;
import com.acs.sale.application.ports.out.FindSaleByIdOutputPort;

public class FindSaleByIdUseCase implements FindSaleByIdInputPort {
	
	private final FindSaleByIdOutputPort findSaleByIdOutputPort;
	
	public FindSaleByIdUseCase(FindSaleByIdOutputPort findSaleByIdOutputPort) {
		this.findSaleByIdOutputPort = findSaleByIdOutputPort;
	}
	
	public Sale find(final Integer id) {
		return findSaleByIdOutputPort.find(id)
				.orElseThrow(() -> new RuntimeException("Venda não encontrada!"));
	}
	
}
