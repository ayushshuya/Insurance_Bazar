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

import com.app.apiresponse.ApiResponse;
import com.app.dto.UserResponseDto;
import com.app.entities.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {
	
	@Autowired 
	private IUserService userservice;
	
	@GetMapping
	public List<UserResponseDto> getAllUsers(){
		return userservice.getAllUsers();
	}
	
//	 @PostMapping
//	 public ResponseEntity<UserResponseDto> createUser(@RequestBody UserResponseDto userResponseDTO) {
//     UserResponseDto createdUserResponseDto = userservice.createUser(userResponseDTO);
//	 return ResponseEntity.status(HttpStatus.CREATED).body(createdUserResponseDto);
//	 }

	@PostMapping("/")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserResponseDto UserResponseDto) {
		UserResponseDto registerUserResponseDto = this.userservice.registerNewUser(UserResponseDto);
		return new ResponseEntity<>(registerUserResponseDto, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<?> updateUser(@PathVariable long userId,@RequestBody UserResponseDto UserResponseDto) {
		UserResponseDto updateUserResponseDto = this.userservice.updateUser(UserResponseDto, userId);
		return ResponseEntity.ok(updateUserResponseDto);
	}

	@DeleteMapping("/{userID}")
	public ApiResponse deleteuserdetails(@PathVariable long userID) {
		System.out.println("delete user details"+userID);
		return new ApiResponse(userservice.deleteUserDetails(userID), true);
		
	}
//	

	@GetMapping("/{cid}")
	public User getCourseById(@PathVariable Long cid) {
		return userservice.getCourseById(cid);
	}
	
//	@GetMapping("/{userId}")
//	public UserResponseDto getUserByID(@PathVariable Long userID) {
//		System.out.println("user with  "+userID+"  is--");
//		return userservice.getUserById(userID);
	
}

