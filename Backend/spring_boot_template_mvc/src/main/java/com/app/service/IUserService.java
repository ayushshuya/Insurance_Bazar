package com.app.service;

import java.util.List;

import com.app.dto.UserResponseDto;
import com.app.dto.UserResponseDto;
import com.app.entities.User;

public interface IUserService {
	List<UserResponseDto> getAllUsers();
	// UserResponseDto createUser(UserResponseDto userResponseDto);

	UserResponseDto registerNewUser(UserResponseDto user);

	UserResponseDto getUserById(Long userId);

	//UserResponseDto updateUser(UserResponseDto UserResponseDto, Long userId);

	String deleteUserDetails(Long userID);

	User getCourseById(Long Id);


	UserResponseDto getbyEmailAndPassword(String email, String password);

	UserResponseDto updateUser(UserResponseDto UserResponseDto, Long userId);

}
