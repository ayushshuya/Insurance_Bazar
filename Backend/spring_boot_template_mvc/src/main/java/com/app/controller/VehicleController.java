package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VehicleDto;
import com.app.entities.Vehicle;
import com.app.service.IUserService;
import com.app.service.IVehicleService;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:3000")

public class VehicleController {
	
	@Autowired
	private IVehicleService vehicleservice;
	
	
	
	@GetMapping
	public List<Vehicle> getAllVehicles(){
		return vehicleservice.getAllVehicles();
	}
	
	@GetMapping("/{vid}")
	public Vehicle getVehicleById(@PathVariable Long vid) {
		return vehicleservice.getVehicleById(vid);
	}
	
//	@PostMapping
//	public Vehicle addVehicle(@RequestBody Vehicle newVehicle) {
//		return vehicleservice.addNewVehicle(newVehicle);
//	}
	
//	@PostMapping("/")
//	public ResponseEntity<?> createUser(@Valid @RequestBody VehicleDto UserResponseDto) {
//		VehicleDto registerUserResponseDto = this.vehicleservice.registerNewUser(UserResponseDto);
//		return new ResponseEntity<>(registerUserResponseDto, HttpStatus.CREATED);
//	}
	
	@DeleteMapping("/{vid}")
	public String deleteVehicle(@PathVariable Long vid) {
		return vehicleservice.deleteVehicleDetails(vid);
	}
	
	@PutMapping
	public Vehicle updateVehicle(@RequestBody @Valid Vehicle updVehicle) {
		return vehicleservice.updateVehicle(updVehicle);
	}
	
	@PostMapping("/add")
	public Vehicle addStudent(@RequestBody VehicleDto stud) {
		return vehicleservice.addStudent(stud);
	}
	
	
	
	
	
	

}
