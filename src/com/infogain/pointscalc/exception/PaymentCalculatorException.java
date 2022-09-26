package com.infogain.pointscalc.exception;

public class PaymentCalculatorException extends PaymentStarterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentCalculatorException(String errrorMesage) {
		super(errrorMesage);
		
	}
	
	public PaymentCalculatorException(String errrorMesage, Throwable throwable ) {
		super(errrorMesage, throwable);
		
	}

}
