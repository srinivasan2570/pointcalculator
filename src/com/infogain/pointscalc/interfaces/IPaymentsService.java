package com.infogain.pointscalc.interfaces;

import java.util.List;

import com.infogain.pointscalc.entity.Payments;

public interface IPaymentsService {

	Payments findbyPaymentsId(Long id);
	
	List<Payments> findbyCustomerId(Long customerId);
}
