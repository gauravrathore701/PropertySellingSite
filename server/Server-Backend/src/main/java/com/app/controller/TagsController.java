package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.TagsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/Tags")
public class TagsController {
	@Autowired
	private TagsService tagsService;
	@GetMapping("/list")
	@Operation(summary = "To get All Tags")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(tagsService.getAllTags());
	}
	
	@GetMapping("/list/property/{tagName}")
	@Operation(summary = "To Get Property by TagName")
	public ResponseEntity<?> getPropertyByLine1(@PathVariable String tagName){
		return ResponseEntity.ok(tagsService.SeachPropertyByTagName(tagName));
	}
}