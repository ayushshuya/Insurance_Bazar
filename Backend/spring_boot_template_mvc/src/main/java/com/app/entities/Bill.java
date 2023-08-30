package com.app.entities;

import java.time.LocalDate;

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
@Table(name="Bill")
public class Bill extends BaseEntity{
	
	
	
	@Column(name="bill_amount", length=30)
	private Double billAmount;
	
	@Column(name="bill_date", length=30)
	private LocalDate billDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	@JsonIgnore
	private Payment payment;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Double billAmount, LocalDate billDate, Payment payment) {
		super();
		this.billAmount = billAmount;
		this.billDate = billDate;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Bill [billAmount=" + billAmount + ", billDate=" + billDate + ", payment=" + payment + "]";
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
	
	

}
