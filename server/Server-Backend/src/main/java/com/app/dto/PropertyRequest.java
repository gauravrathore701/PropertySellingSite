package com.app.dto;


import java.util.Set;

import com.app.entities.Address;
import com.app.entities.PropertyType;
import com.app.entities.Tags;

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
	private String description;
	private float price;
	private float propertyArea;
	private PropertyType propertyType;
	private int bedrooms;
	private int washrooms;
	private AddressDTO address;
	private Set<TagsDTO> tags;
}
