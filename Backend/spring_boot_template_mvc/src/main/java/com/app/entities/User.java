package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User extends BaseEntity {
	
    @Column(name="first_name", length =30)
    private String firstName;
    
    @Column(name="last_name", length =30)
    private String lastName;
    
    @Column(name="mobile_no", length=30)
    private String mobileNo;
    
    @Column( length=30)
    private String address;
    
    private LocalDate dob;
    
    @Column( length=30)
    private String email;
    
    @Column( length=30)
    private String password;
    
    @Enumerated(EnumType.STRING)
    @Column( length=30)
    private UserRole role;
    
    @JsonIgnore
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    @JsonManagedReference
    
	private List<Vehicle> vehicle;
    
    @JsonIgnore
    @OneToMany(mappedBy="user", cascade = CascadeType.ALL)
    @JsonManagedReference
	private List<Policy> policy=new ArrayList<Policy>();

	}
