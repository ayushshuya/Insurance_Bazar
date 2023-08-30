package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.app.dto.UserResponseDto;
import com.app.entities.User;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.UserEntityRepository;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserEntityRepository userepo;

	@Autowired
	private ModelMapper mapper;

//	@Override
//	public List<UserResponseDto> getAllUsers() {
//		return userepo.findAll();
//	}
//
//	 @Override
//	    public UserResponseDto createUser(UserResponseDto authorDTO) {
//	        User user = new User();
//	        user.setFirstName(authorDTO.getFirstName());
//	        user.setLastName(authorDTO.getLastName());
//	        user.setAddress(authorDTO.getAddress());
//	        user.setEmail(authorDTO.getEmail());
//	       
//	        user = userepo.save(user);
//	        return authorDTO;
//	    }

//	

	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> users = this.userepo.findAll();

		List<UserResponseDto> UserResponseDtos = users.stream()
				.map(user -> this.mapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
		return UserResponseDtos;
	}

	@Override
	public UserResponseDto registerNewUser(UserResponseDto UserResponseDto) {
		User user = this.mapper.map(UserResponseDto, User.class);
		User savedUser = this.userepo.save(user);
		return this.mapper.map(savedUser, UserResponseDto.class);
	}

	@Override
	public UserResponseDto updateUser(UserResponseDto UserResponseDto, Long userId) {
		User user = userepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Not a Valid User id", userId));

		user.setFirstName(UserResponseDto.getFirstName());
		user.setLastName(UserResponseDto.getLastName());
		user.setEmail(UserResponseDto.getEmail());
		user.setMobileNo(UserResponseDto.getMobileNo());
		user.setRole(UserResponseDto.getRole());
		user.setAddress(UserResponseDto.getAddress());

		User updateUser = this.userepo.save(user);

		return this.mapper.map(updateUser, UserResponseDto.class);
	}

	@Override
	public UserResponseDto getUserById(Long userId) {
		User user = userepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Please proivide a valid id", userId));

		return this.mapper.map(user, UserResponseDto.class);
	}

	@Override
	public String deleteUserDetails(Long userID) {
		String mesg = "Emp id invalid , can't delete emp details ";
		if (userepo.existsById(userID)) {
			userepo.deleteById(userID);
			mesg = "User with ID=" + userID + "  deleted !";
		}
		return mesg;
	}

	@Override
	public User getCourseById(Long Id) {
		User newuser = userepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("not found", Id));
		return newuser;
	}

	@Override
	public UserResponseDto getbyEmailAndPassword(String email, String password) {
		System.out.println(email);
		System.out.println(password);
		User user = this.userepo.findByEmailAndPassword(email, password);
		if (user != null)
			return this.mapper.map(user, UserResponseDto.class);
		return null;
	}

}
