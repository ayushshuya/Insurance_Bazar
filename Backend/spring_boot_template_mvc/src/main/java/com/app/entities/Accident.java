package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="accident")
public class Accident extends BaseEntity{
	
	
	
	@Column(length=30)
	private String place;
	
	@Column(name="accident_date", length=30)
	private LocalDate accidentDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name="vehicle_id")
    private Vehicle vehicle;

	public Accident() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accident(String place, LocalDate accidentDate, Vehicle vehicle) {
		super();
		this.place = place;
		this.accidentDate = accidentDate;
		//this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Accident [place=" + place + ", accidentDate=" + accidentDate + ", vehicle="  + "]";
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public LocalDate getAccidentDate() {
		return accidentDate;
	}

	public void setAccidentDate(LocalDate accidentDate) {
		this.accidentDate = accidentDate;
	}

//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}
	
	
	
	
	
	

}
