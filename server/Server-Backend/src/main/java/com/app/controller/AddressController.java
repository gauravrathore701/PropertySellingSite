package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.AddressService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/Address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	@GetMapping("/list")
	@Operation(summary = "To get All Addresses")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(addressService.getAllAddress());
	}
	
	@GetMapping("/list/Line1/{line1}")
	@Operation(summary = "To Get Property by AddressLine1")
	public ResponseEntity<?> getPropertyByLine1(@PathVariable String line1){
		return ResponseEntity.ok(addressService.SeachPropertyByAddrLine1(line1));
	}
	
	@GetMapping("/list/Line2/{line2}")
	@Operation(summary = "To Get Property by AddressLine2")
	public ResponseEntity<?> getPropertyByLine2(@PathVariable String line2){
		return ResponseEntity.ok(addressService.SeachPropertyByAddrLine1(line2));
	}
	@GetMapping("/list/City/{city}")
	@Operation(summary = "To Get Property by City")
	public ResponseEntity<?> getPropertyByCity(@PathVariable String city){
		return ResponseEntity.ok(addressService.SeachPropertyByCity(city));
	}
	@GetMapping("/list/District/{district}")
	@Operation(summary = "To Get Property by District")
	public ResponseEntity<?> getPropertyByDistrict(@PathVariable String district){
		return ResponseEntity.ok(addressService.SeachPropertyByDistrict(district));
	}
	@GetMapping("/list/State/{state}")
	@Operation(summary = "To Get Property by State")
	public ResponseEntity<?> getPropertyByState(@PathVariable String state){
		return ResponseEntity.ok(addressService.SeachPropertyByState(state));
	}
}