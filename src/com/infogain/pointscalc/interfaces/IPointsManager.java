package com.infogain.pointscalc.interfaces;

import com.infogain.pointscalc.exception.PaymentStarterException;

public interface IPointsManager {

	public void doGeneratePoints(String amount)throws PaymentStarterException;
}
