package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.app.entities.VehicleType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehicleDto {
	
	//@Column(length = 30)
    //private Long id;
	
	@Column(unique = true)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "type required here(enter in CAPITALS)")
	
     private VehicleType type;

	@Column(length = 30)
	@NotBlank(message = "name must be provided")
	private String company;


	@Column(length = 30)
	
	private LocalDate regdate;
	
	@Column
	private Long userId;
	
	
	
    
	
	

}
