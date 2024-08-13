package com.app.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Users;

public interface UserDao extends JpaRepository<Users, Long> {
	
	Users findByEmail(String email);

}
