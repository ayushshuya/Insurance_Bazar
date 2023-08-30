package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserEntityRepository extends JpaRepository<User,Long> {

	@Query("SELECT u FROM User u WHERE u.email = ?1 and u.password = ?2")
	User findByEmailAndPassword(String email,String password);
	 

}
