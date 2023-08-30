package com.app.service;

import java.util.List;

import com.app.dto.PaymentDto;
import com.app.entities.Payment;

public interface IPaymentService {
	
	Payment addNewPayment(Payment newPayment);
	List<Payment> getAllPayments();
	Payment getPaymentById(Long Id);
	String deletePaymentDetails(Long PaymentID);
	Payment updatePayment(Payment updatedPayment);
	Payment addStudent(PaymentDto stud);

}
