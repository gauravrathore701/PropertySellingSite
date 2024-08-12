package com.app.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PropertyRequest;
import com.app.service.PropertyService;

import io.swagger.v3.oas.annotations.Operation;

import com.app.dto.ApiResponse;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/Property")
public class PropertyController {
	@Autowired
	private PropertyService PropertyService;
	
	@PostMapping("/add/{userId}")
	@Operation(summary = "To Add new Property")
	public ResponseEntity<?> addNew(@RequestBody @Valid PropertyRequest request ,@PathVariable Long userId){
		return ResponseEntity.ok(PropertyService.addNewProperty(request, userId));
	}
	
	
	@GetMapping("/{PropId}")
	@Operation(summary = "To get Property by PropId")
	public ResponseEntity<?> getById(@PathVariable Long PropId){
		return ResponseEntity.ok(PropertyService.getById(PropId));
	}
	@GetMapping("/list")
	@Operation(summary = "To get All Property")
	public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
		return ResponseEntity.ok(PropertyService.getAll(page,size));
	}
	@PutMapping("/update/{id}")
	@Operation(summary = "To update Property")
	public ResponseEntity<?> updateProperty(@RequestBody PropertyRequest request,@PathVariable Long id){
		System.out.println("------------------------");
		System.out.println(request);
		System.out.println("------------------------");
		return ResponseEntity.ok(new ApiResponse(PropertyService.updatePropertyDetails(request,id)));
	}
	@GetMapping("/type/{type}")
	@Operation(summary = "To Get Property by Type")
	public ResponseEntity<?> getSpecificType(@PathVariable String type){
		return ResponseEntity.ok(PropertyService.seachProductByType(type.toUpperCase()));
	}
	
	@GetMapping("/user/{userId}")
	@Operation(summary = "To Get Property by User")
	public ResponseEntity<?> getSpecificUser(@PathVariable Long userId){
		return ResponseEntity.ok(PropertyService.seachProductByUser(userId));
	}
	@DeleteMapping("/{Propertyid}")
	@Operation(summary = "To Soft Delete Property")
	public ResponseEntity<?> deleteSpecific(@PathVariable Long id){
		return ResponseEntity.ok(new ApiResponse(PropertyService.deleteProperty(id)));
	}
}