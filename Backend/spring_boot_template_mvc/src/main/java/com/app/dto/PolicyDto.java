package com.app.dto;

import java.time.LocalDate;

import com.app.entities.PolicyType;
import com.app.entities.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PolicyDto {
	
	private Double amount;
	
	private LocalDate purchaseDate;
	
    private PolicyType policy;
    
    private LocalDate validity;
    
    private Long vehicleId;
    
    private Long userId;



}
