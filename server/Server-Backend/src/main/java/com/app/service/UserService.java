package com.app.service;

import java.util.List;

import com.app.dto.LoginDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserPasswordChangeDTO;
import com.app.dto.UserUpdateDTO;
import com.app.entities.Users;

public interface UserService {
	List<Users> getAll();

	String addNewUser(UserDTO request);
	
	String addNewAdmin(UserDTO request);
	
	UserDTO getUserByEmail(LoginDTO request);
	
	String UpdateProfile(UserUpdateDTO request);
	
	String UpdatePassword(UserPasswordChangeDTO request);
	
}
