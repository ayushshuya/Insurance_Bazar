package com.app.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="policy")
public class Policy extends BaseEntity {
	
	
	
	@Column(length = 20)
	private Double amount;
	
	@Column(name="purchase_date",length = 20)
	private LocalDate purchaseDate;
	
	@Column(length = 20)
	private LocalDate validity;
	
	@Enumerated(EnumType.STRING)
    @Column( length=30)
    private PolicyType policy;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JsonIgnore
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

		
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	@JsonBackReference
	private User user;

	

	
	
	
	
	
	
	
	
	
	
	

}
