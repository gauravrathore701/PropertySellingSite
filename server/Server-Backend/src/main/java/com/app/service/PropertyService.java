package com.app.service;

import java.util.List;

import jakarta.validation.Valid;

import com.app.dto.PropertyRequest;
import com.app.dto.PropertyResponse;

public interface PropertyService {
	List<PropertyResponse> getAll();

	String addNewProperty(@Valid PropertyRequest request, Long Userid);

	String UpdatePropertyDetails(PropertyRequest request, Long Propertyid);
	
	String SellingProperty(PropertyRequest request, Long Propertyid);

	List<PropertyResponse> SeachProductByType(String category);
	
	List<PropertyResponse> SeachProductByUser(Long Userid);
	
	String DeleteProperty(Long id);
	
}
