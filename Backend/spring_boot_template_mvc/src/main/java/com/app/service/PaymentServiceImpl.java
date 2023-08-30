package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.PaymentDto;
import com.app.entities.Payment;
import com.app.entities.Policy;
import com.app.exception.ResourceNotFound;
import com.app.repository.PaymentEntityRepository;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService{
	
	@Autowired
	private PaymentEntityRepository Paymentrepo;
	
	@Autowired
	 private ModelMapper mapper;
	
	@Autowired
	private IPolicyService serviceimp;
	
	@Override
	public Payment addNewPayment(Payment newPayment) {
	return Paymentrepo.save(newPayment);
	}
	
	@Override
	public List<Payment> getAllPayments() {
		return Paymentrepo.findAll();
	}

	@Override
	public Payment getPaymentById(Long Id) {
		Payment newPayment = Paymentrepo.findById(Id).orElseThrow(() -> new ResourceNotFound("Invalid Id, Payment not found!!!"));
		return newPayment;
	}

	


	@Override
	public Payment updatePayment(Payment updatedcourse) {
		Payment updcourse = Paymentrepo.findById(updatedcourse.getId()).orElseThrow(
				() -> new ResourceNotFound("Invalid Id, Could not update!!!"));
		updcourse.setMode(updatedcourse.getMode());
		updcourse.setAmount(updatedcourse.getAmount());

		return updcourse;
	}
	
	@Override
	public String deletePaymentDetails(Long userID) {
		String mesg = "Emp id invalid , can't delete emp details ";
		if (Paymentrepo.existsById(userID)) {
			Paymentrepo.deleteById(userID);
			mesg = "User with ID=" + userID + "  deleted !";
		}
		return mesg;
	}
	@Override
	public Payment addStudent(PaymentDto newstudent) {
		
		Payment stud=mapper.map(newstudent,Payment.class);
		
		Policy course=serviceimp.getPolicyById(newstudent.getPolicyId());
		
		stud.setPolicy(course);
		
		return Paymentrepo.save(stud);
	}

}
