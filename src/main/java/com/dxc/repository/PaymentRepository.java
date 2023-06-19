package com.dxc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.model.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	public Payment getByPaymentId(int paymentId);
}
