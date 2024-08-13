package com.app.service;

import java.util.List;

import jakarta.validation.Valid;

import com.app.dto.PropertyRequest;
import com.app.dto.PropertyResponse;
import com.app.dto.PropertyResponsePaginated;

public interface PropertyService {
	
	PropertyResponse getById(Long id);
	
	PropertyResponsePaginated getAll(int page,int size);

	PropertyResponse addNewProperty(@Valid PropertyRequest request, Long Userid);

	String updatePropertyDetails(PropertyRequest request, Long Propertyid);
	
	String sellingProperty(PropertyRequest request, Long Propertyid);

	List<PropertyResponse> seachProductByType(String category);
	
	List<PropertyResponse> seachProductByUser(Long Userid);
	
	String deleteProperty(Long id);
	
}
