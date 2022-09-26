package com.infogain.pointscalc.interfaces;

import com.infogain.pointscalc.exception.PaymentCalculatorException;
import com.infogain.pointscalc.model.Payments;

public interface IPointsCalculator {

	//public void calculatePoints(Purchase purchase, Payments payments);
	
	public Payments calculatePoints(Double purchaseValue) throws PaymentCalculatorException;
	
}
