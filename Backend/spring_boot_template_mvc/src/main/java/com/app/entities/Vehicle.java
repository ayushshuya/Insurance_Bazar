package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="vehicle")

public class Vehicle extends BaseEntity{

	
	
	@Enumerated(EnumType.STRING)
    @Column( length=30)
    private VehicleType type;
	
	@Column(name="vehicle_company")
	private String company;
	
	@Column(name="registration_date")
	private LocalDate regdate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	@JsonBackReference
	private User user;
	
//	@JsonIgnore
//	@OneToMany(mappedBy="vehicle", cascade = CascadeType.ALL)
//	@JsonManagedReference
	
	//private List<Accident> accident;

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public LocalDate getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDate regdate) {
		this.regdate = regdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public List<Accident> getAccident() {
//		return accident;
//	}
//
//	public void setAccident(List<Accident> accident) {
//		this.accident = accident;
//	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", company=" + company + ", regdate=" + regdate + ", user="  + "]";
	}

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(VehicleType type, String company, LocalDate regdate, User user, List<Accident> accident) {
		super();
		this.type = type;
		this.company = company;
		this.regdate = regdate;
		this.user = user;
		//this.accident = accident;
	}

	
	
	
	
	
}
