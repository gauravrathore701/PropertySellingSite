package com.app.service;

import java.util.List;

import com.app.dto.PropertyResponse;
import com.app.dto.TagsDTOResponse;

public interface TagsService {
	List<TagsDTOResponse> getAllTags();

	List<PropertyResponse> SeachPropertyByTagName(String tagName);	
}
