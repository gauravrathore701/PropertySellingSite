package com.app.dto;


import jakarta.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PropertyRequest {
	@NotBlank
	private String title;
	@NotBlank
	private String address;
	@NotBlank
	private String city;
	@NotBlank
	private String state;
	@NotBlank
	private String district;
	@NotBlank
	private String pincode;
	@NotBlank
	private String propertyType;
	private String status;
	private float price;
	private float propertyArea;
	private int bedrooms;
	private int bathrooms;
	private String description;
}
