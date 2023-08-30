package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PaymentDto {
	
	
	
	private Double amount;
	
	private String mode;
	
	private Long policyId;

}
