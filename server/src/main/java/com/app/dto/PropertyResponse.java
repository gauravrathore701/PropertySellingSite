package com.app.dto;


import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

import com.app.entities.Address;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PropertyResponse {
	private Long id;
	@NotBlank
	private String title;
	private Address address;
	@NotBlank
	private String propertyType;
	private float price;
	private float propertyArea;
	private int bedrooms;
	private int bathrooms;
	private String description;
	private LocalDateTime UpdatedDateTime;
	private LocalDateTime createdDateTime;
}
