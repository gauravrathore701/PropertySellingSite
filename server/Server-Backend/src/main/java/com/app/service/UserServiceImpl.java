package com.app.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.UserRequest;
import com.app.entities.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserDao userDao;

	@Autowired 
	private ModelMapper mapper;

	@Override
	public String addNewUser(UserRequest request) {
		Users u= mapper.map(request, Users.class);
		userDao.save(u);
		return "User Added";
	}

	@Override
	public List<Users> getAll() {
		return userDao.findAll();
	}
}
