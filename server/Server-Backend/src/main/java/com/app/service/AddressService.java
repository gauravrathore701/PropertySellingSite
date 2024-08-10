package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.dto.AddressDTO;
import com.app.dto.PropertyResponse;

public interface AddressService {
	List<AddressDTO> getAllAddress();

	Set<PropertyResponse> SeachPropertyByAddrLine1(String addrLine1);
	
	Set<PropertyResponse> SeachPropertyByAddrLine2(String addrLine2);
	
	Set<PropertyResponse> SeachPropertyByCity(String city);
	
	Set<PropertyResponse> SeachPropertyByDistrict(String district);
	
	Set<PropertyResponse> SeachPropertyByState(String state);	
}
