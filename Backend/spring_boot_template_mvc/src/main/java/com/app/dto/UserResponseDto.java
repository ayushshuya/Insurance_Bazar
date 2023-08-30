package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.entities.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponseDto {
	
	@Column(length = 30)
	private Long Id;

	@Column(length = 30)
	@NotBlank(message = "name must be provided")
	private String firstName;


	@Column(length = 30)
	@NotBlank(message = "name must be provided")
	private String lastName;
	
	@Column(length = 10, unique = true)
	@NotBlank
	@Length(min = 10,max=10,message = "please enter a valid number")
	@Pattern(regexp = "^[789]\\d{9}$")
	private String mobileNo;
	
	@Column(length = 30)
	@NotBlank(message = "address must be provided")
	private String address;
	
	@Column(length = 30)
	private LocalDate dob;

	@Column(length = 30, unique = true)
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Length(min = 3, max = 10, message = "invalid password")
	private String password;
	
    @Column(unique = true)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "role required here(enter in CAPITALS)")
	
     private UserRole role;

	

	

	
	
//	private String firstName;
//	 private String lastName;
//	 private String mobileNo;
//	 private String address;
//	 private String email;
//	 
//	 
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getMobileNo() {
//		return mobileNo;
//	}
//	public void setMobileNo(String mobileNo) {
//		this.mobileNo = mobileNo;
//	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	@Override
//	public String toString() {
//		return "UserResponseDto [firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo
//				+ ", address=" + address + ", email=" + email + "]";
//	}
	
	

	 
	 

}
