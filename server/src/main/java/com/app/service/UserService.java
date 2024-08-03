package com.app.service;

import java.util.List;


import com.app.dto.UserRequest;
import com.app.entities.Users;

public interface UserService {
	List<Users> getAll();

	String addNewUser(UserRequest request);
	
}
