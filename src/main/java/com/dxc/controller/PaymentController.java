package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.exception.DuplicatePaymentIDException;
import com.dxc.exception.PaymentDoesNotExistException;
import com.dxc.model.Payment;
import com.dxc.service.PaymentService;

@RestController
@RequestMapping("/payment/")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@PostMapping("add")
	public void addHotel(Payment payment) {
		try {
			service.addPayment(payment);
		} catch (DuplicatePaymentIDException e) {
			System.out.println("\nCannot add the payment\n");
			System.out.println(e);
//			e.printStackTrace();
		}
	}
	
	@DeleteMapping("delete")
	public void deleteHotel(Payment payment) {
		try {
			service.deletePayment(payment);
		} catch (PaymentDoesNotExistException e) {
			System.out.println("\nCannot delete the hotel\n");
			System.out.println(e);
//			e.printStackTrace();
		}
	}
	
	@GetMapping("getPayment")
	public Payment getPayment(int id)  {
		
		Payment payment = null;
		try {
			payment = service.getPayment(id);
		} catch (PaymentDoesNotExistException e) {
			System.out.println("\nCannot find the hotel\n");
			System.out.println(e);
			return null;
//			e.printStackTrace();
		}
		return payment;
	}
}
