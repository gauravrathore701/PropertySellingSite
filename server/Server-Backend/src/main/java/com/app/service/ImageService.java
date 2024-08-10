package com.app.service;

import java.util.List;

import jakarta.validation.Valid;

import com.app.dto.ImageDTORequest;
import com.app.dto.ImageDTOResponse;
import com.app.dto.UserImageDTO;

public interface ImageService {
	ImageDTOResponse getImage(Long imageId);
	List<ImageDTOResponse> getAll();

	String addNewImageProperty(@Valid ImageDTORequest imageBody, Long propertyId);
	
	String addNewImageUser(@Valid ImageDTORequest imageBody, Long userId);

	String DeletePropertyImages(Long imageId);
	
	List<ImageDTOResponse> SeachImagesByProperty(Long propertyId);	
}
