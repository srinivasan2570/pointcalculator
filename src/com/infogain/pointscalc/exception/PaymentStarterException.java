package com.infogain.pointscalc.exception;

public class PaymentStarterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PaymentStarterException(String errrorMesage) {
		super(errrorMesage);
	}

	public PaymentStarterException(String errrorMesage, Throwable throwable) {
		
		super(errrorMesage, throwable);
	}
	
	

}
