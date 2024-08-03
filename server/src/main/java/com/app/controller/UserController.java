package com.app.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserRequest;
import com.app.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

import com.app.dto.ApiResponse;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/Users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	@Operation(summary = "To Add new User")
	public ResponseEntity<?> addNew(@RequestBody @Valid UserRequest request){
		return ResponseEntity.ok(new ApiResponse(userService.addNewUser(request)));
	}
	
	@GetMapping("/list")
	@Operation(summary = "To getAll Users")
	public ResponseEntity<?> gettAll(){
		return ResponseEntity.ok(userService.getAll());
	}
}