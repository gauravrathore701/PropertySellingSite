package com.app.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDTO;
import com.app.dto.UserPasswordChangeDTO;
import com.app.dto.UserUpdateDTO;
import com.app.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

import com.app.dto.ApiResponse;
import com.app.dto.LoginDTO;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/Users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	@Operation(summary = "To Add new User")
	public ResponseEntity<?> addNewUser(@RequestBody @Valid UserDTO request){
		return ResponseEntity.ok(new ApiResponse(userService.addNewUser(request)));
	}
	
	@PostMapping("/admin-add")
	@Operation(summary = "To Add new Admin")
	public ResponseEntity<?> addNewAdmin(@RequestBody @Valid UserDTO request){
		return ResponseEntity.ok(new ApiResponse(userService.addNewAdmin(request)));
	}
	
	@GetMapping("/list")
	@Operation(summary = "To getAll Users")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(userService.getAll());
	}
	
	@PostMapping("/login")
	@Operation(summary = "To Login Functionality")
	public ResponseEntity<?> userLogin(@RequestBody @Valid LoginDTO request){
		return ResponseEntity.ok(userService.getUserByEmail(request));
	}
	
	@PutMapping("/profile")
	@Operation(summary = "To Update User Profile")
	public ResponseEntity<?> UpdateUser(@RequestBody @Valid UserUpdateDTO request){
		return ResponseEntity.ok(new ApiResponse(userService.UpdateProfile(request)));
	}
	
	@PutMapping("/password")
	@Operation(summary = "To Update User Password")
	public ResponseEntity<?> UpdateUserPassword(@RequestBody @Valid UserPasswordChangeDTO request){
		return ResponseEntity.ok(new ApiResponse(userService.UpdatePassword(request)));
	}
	
}