package com.app.service;

import java.util.List;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.LoginDTO;
import com.app.dto.UserDTO;
import com.app.dto.UserPasswordChangeDTO;
import com.app.dto.UserUpdateDTO;
import com.app.entities.Address;
import com.app.entities.Users;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserDao userDao;

	@Autowired 
	private ModelMapper mapper;

	@Override
	public String addNewUser(UserDTO request) {
		Users u= mapper.map(request, Users.class);
		u.setAdmin(false);
		u.setDob(request.getDob());
		userDao.save(u);
		return "User Added";
	}
	@Override
	public List<Users> getAll() {
		return userDao.findAll();
	}
	@Override
	public UserDTO getUserByEmail(LoginDTO request) {
		Users u=userDao.findByEmail(request.getEmail());
		if(u==null || !u.getPassword().equals(request.getPassword()))
			throw new ResourceNotFoundException("Invalid User Credentials");
		return mapper.map(u, UserDTO.class);
	}
	@Override
	public String addNewAdmin(UserDTO request) {
		Users u= mapper.map(request, Users.class);
		u.setAdmin(true);
		userDao.save(u);
		return "Admin Added";
	}
	@Override
	public String UpdateProfile(UserUpdateDTO request) {
		Users u=userDao.findByEmail(request.getEmail());
		if(u==null)
			throw new ResourceNotFoundException("Invalid User Credentials");
		u.setAddress(mapper.map(request.getAddress(),Address.class));
		u.setFname(request.getFname());
		u.setLname(request.getLname());
		u.setPhone(request.getPhone());
		u.setUsername(request.getUsername());
		u.setDob(request.getDob());
		userDao.save(u);
		return "Profile Updated";
	}
	@Override
	public String UpdatePassword(UserPasswordChangeDTO request) {
		Users u=userDao.findByEmail(request.getEmail());
		if(u==null ||!u.getPassword().equals(request.getPassword()))
			throw new ResourceNotFoundException("Invalid User Credentials");
		u.setPassword(request.getNewPassword());
		userDao.save(u);
		return "Password Updated";
	}
}
