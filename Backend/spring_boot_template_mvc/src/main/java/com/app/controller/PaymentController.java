package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PaymentDto;
import com.app.entities.Payment;
import com.app.service.IPaymentService;
@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:3000")

public class PaymentController {
	
	@Autowired
	private IPaymentService Paymentservice;
	
	@GetMapping
	public List<Payment> getAllPayments(){
		return Paymentservice.getAllPayments();
	}
	
	@GetMapping("/{vid}")
	public Payment getPaymentById(@PathVariable Long vid) {
		return Paymentservice.getPaymentById(vid);
	}
	
//	@PostMapping
//	public Payment addPayment(@RequestBody Payment newPayment) {
//		return Paymentservice.addNewPayment(newPayment);
//	}
	
	@DeleteMapping("/{vid}")
	public String deletePayment(@PathVariable Long vid) {
		return Paymentservice.deletePaymentDetails(vid);
	}
	
	@PutMapping
	public Payment updatePayment(@RequestBody @Valid Payment updPayment) {
		return Paymentservice.updatePayment(updPayment);
	}
	
	@PostMapping("/add")
	public Payment addStudent(@RequestBody PaymentDto stud) {
		return Paymentservice.addStudent(stud);
	}

}

