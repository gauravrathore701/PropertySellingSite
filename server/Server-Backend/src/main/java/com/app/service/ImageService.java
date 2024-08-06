package com.app.service;

import java.util.List;

import jakarta.validation.Valid;

import com.app.dto.ImageDTORequest;
import com.app.dto.ImageDTOResponse;

public interface ImageService {
	ImageDTOResponse getImage(Long imageId);
	List<ImageDTOResponse> getAll();

	String addNewImage(@Valid ImageDTORequest imageBody, Long propertyId);

	String DeletePropertyImages(Long imageId);
	
	List<ImageDTOResponse> SeachImagesByProperty(Long propertyId);	
}
