package com.app.service;

import java.util.List;


import com.app.dto.UserDTORequest;
import com.app.entities.Users;

public interface UserService {
	List<Users> getAll();

	String addNewUser(UserDTORequest request);
	
}
