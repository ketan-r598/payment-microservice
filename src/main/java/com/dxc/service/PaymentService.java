package com.dxc.service;

import com.dxc.exception.DuplicatePaymentIDException;
import com.dxc.exception.PaymentDoesNotExistException;
import com.dxc.model.Payment;

public interface PaymentService {
	public void addPayment(Payment payment) throws DuplicatePaymentIDException;
	public void deletePayment(Payment payment) throws PaymentDoesNotExistException;
	public Payment getPayment(int id) throws PaymentDoesNotExistException;
}