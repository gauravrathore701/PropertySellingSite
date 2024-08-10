package com.app.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import com.app.dto.ApiResponse;
import com.app.dto.ImageDTORequest;
import com.app.dto.UserImageDTO;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/Image")
public class ImageController {
	@Autowired
	private ImageService imageService;
	@GetMapping("/{imageId}")
	@Operation(summary = "To get Specific Image")
	public ResponseEntity<?> getSpecific(@PathVariable Long imageId ){
		return ResponseEntity.ok(imageService.getImage(imageId));
	}
	
	@PostMapping("/add/{propertyId}")
	@Operation(summary = "To Add new Image per Property")
	public ResponseEntity<?> addNewImageProperty(@ModelAttribute @Valid ImageDTORequest request ,@PathVariable Long propertyId){
		return ResponseEntity.ok(new ApiResponse(imageService.addNewImageProperty(request, propertyId)));
	}
	@PostMapping("/add/user/{userId}")
	@Operation(summary = "To Add new Image per User")
	public ResponseEntity<?> addImageUser(@ModelAttribute @Valid ImageDTORequest request ,@PathVariable Long userId){
		return ResponseEntity.ok(new ApiResponse(imageService.addNewImageUser(request, userId)));
	}
	@GetMapping("/list")
	@Operation(summary = "To get All Images")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(imageService.getAll());
	}
	@GetMapping("/list/{propertyId}")
	@Operation(summary = "To Get Images by Property")
	public ResponseEntity<?> getSpecificProperty(@PathVariable Long propertyId){
		return ResponseEntity.ok(imageService.SeachImagesByProperty(propertyId));
	}
	@DeleteMapping("/{imageId}")
	@Operation(summary = "To Delete Image")
	public ResponseEntity<?> updateProperty(@PathVariable Long imageId){
		return ResponseEntity.ok(new ApiResponse(imageService.DeletePropertyImages(imageId)));
	}
}