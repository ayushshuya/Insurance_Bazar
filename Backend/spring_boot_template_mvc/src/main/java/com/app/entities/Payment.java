package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="payment")
public class Payment extends BaseEntity {
	

    
	
    @Column( length=30)
	private Double amount;
	
    @Column( length=30)
	private String mode;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Policy_id")
    //@JsonIgnore
	private Policy policy;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Double amount, String mode, Policy policy) {
		super();
		this.amount = amount;
		this.mode = mode;
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Payment [amount=" + amount + ", mode=" + mode + ", policy=" + policy + "]";
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
    
    
	
    
	
	
	

}
