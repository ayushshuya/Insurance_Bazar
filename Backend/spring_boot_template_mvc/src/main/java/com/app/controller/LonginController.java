package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserResponseDto;
import com.app.entities.Login;
import com.app.exception.ResourceNot;
import com.app.service.IUserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class LonginController {
	
	@Autowired
	private IUserService userService;

	@PostMapping("/login")
	public ResponseEntity<UserResponseDto> getUser(@RequestBody Login login)
	{
		System.out.println("in login controller");
		UserResponseDto userDto = this.userService.getbyEmailAndPassword(login.getEmail(), login.getPassword());
		System.out.println("email"+login.getEmail());
		System.out.println("password"+ login.getPassword());
		System.out.println(userDto);
		if(userDto==null)
			throw new ResourceNot(login.getEmail(),login.getPassword(),0);
		
		return new ResponseEntity<UserResponseDto>(userDto,HttpStatus.OK);
		
	}

}
