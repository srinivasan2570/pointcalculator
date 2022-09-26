package com.infogain.pointscalc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.infogain.pointscalc.database.IPaymentsRepository;
import com.infogain.pointscalc.entity.Payments;
import com.infogain.pointscalc.interfaces.IPaymentsService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PaymentsServiceImpl implements IPaymentsService {

	
	@Autowired
    private IPaymentsRepository paymentsRepository;
	@Override
	public Payments findbyPaymentsId(Long id) {       
		log.info("Input Payment Id :",id);
		Optional<Payments> optionalPayments = paymentsRepository.findById(id);
		 return optionalPayments.get();
	}
	@Override
	public List<Payments> findbyCustomerId(Long customerId) {
		//paymentsRepository.findbycustomerId(customerId);
		return null;
	}

}
