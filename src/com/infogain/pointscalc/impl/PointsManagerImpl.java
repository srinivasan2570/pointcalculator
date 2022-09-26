package com.infogain.pointscalc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.pointscalc.exception.PaymentCalculatorException;
import com.infogain.pointscalc.interfaces.IPaymentsService;
import com.infogain.pointscalc.interfaces.IPointsCalculator;
import com.infogain.pointscalc.interfaces.IPointsManager;
import com.infogain.pointscalc.model.Payments;

@Service
public class PointsManagerImpl implements IPointsManager {

	@Autowired
	private IPointsCalculator pointsCalc;
	
	@Autowired
    private IPaymentsService paymentsService;
	
	@Override
	public void doGeneratePoints(String amount)throws PaymentCalculatorException {
		
		Payments payments = pointsCalc.calculatePoints(Double.valueOf(amount));
		

	}

}
