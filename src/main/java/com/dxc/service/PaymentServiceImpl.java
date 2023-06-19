package com.dxc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dxc.exception.DuplicatePaymentIDException;
import com.dxc.exception.PaymentDoesNotExistException;
import com.dxc.model.Payment;
import com.dxc.repository.PaymentRepository;

public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repo;

	@Override
	public void addPayment(Payment payment) throws DuplicatePaymentIDException {
		int id = payment.getPaymentId();
		Optional<Payment> p = Optional.of(repo.getByPaymentId(id));

		if (p.isEmpty()) {
			repo.save(p.get());
			System.out.println("\nPayment Saved Successfully\n");
			return;
		}
		throw new DuplicatePaymentIDException();
	}

	@Override
	public void deletePayment(Payment payment) throws PaymentDoesNotExistException {

		int id = payment.getPaymentId();
		Optional<Payment> p = Optional.of(repo.getByPaymentId(id));

		if (p.isEmpty()) {
			throw new PaymentDoesNotExistException();
		}
		repo.deleteById(id);
		System.out.println("\nPayment Deleted Successfully\n");
	}

	@Override
	public Payment getPayment(int id) throws PaymentDoesNotExistException {
		Optional<Payment> p = Optional.of(repo.getByPaymentId(id));

		if (p.isEmpty()) {
			throw new PaymentDoesNotExistException();
		}
		return p.get();
	}

}