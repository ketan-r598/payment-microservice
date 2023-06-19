package com.dxc.exception;

public class PaymentDoesNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentDoesNotExistException() {
		super();
	}

	public PaymentDoesNotExistException(String message) {
		super(message);
	}

	
}
