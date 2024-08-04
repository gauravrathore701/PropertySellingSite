package com.app.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PropertyDao;
import com.app.dao.UserDao;
import com.app.dto.PropertyRequest;
import com.app.dto.PropertyResponse;
import com.app.entities.Address;
import com.app.entities.Property;
import com.app.entities.Users;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

	@Autowired 
	private PropertyDao propertyDao;

	@Autowired 
	private UserDao userDao;

	@Autowired 
	private ModelMapper mapper;

	@Override
	public String addNewProperty(@Valid PropertyRequest request, Long id) {
		Property p= mapper.map(request, Property.class);
		Users u=userDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid Id Given")));
		Address a= new Address(request.getAddress(), request.getCity(), request.getState(),request.getDistrict() , request.getPincode());
		p.setAddress(a);
		p.setUser(u);
		p.setIsDeleted(false);
		propertyDao.save(p);
		return "Product Added";
	}

	@Override
	public List<PropertyResponse> getAll() {
		List<Property> plist = propertyDao.findAll();
		List<PropertyResponse> prlist= new ArrayList<PropertyResponse>();
		for (Property property : plist) {
			PropertyResponse pr= mapper.map(property, PropertyResponse.class);
			prlist.add(pr);
		}
		return prlist; 
	}

	@Override
	public String UpdatePropertyDetails(PropertyRequest request, Long id) {
		Property p=propertyDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
		p.setTitle(request.getTitle());
		p.setDescription(request.getDescription());
		Address a= new Address(request.getAddress(), request.getCity(), request.getState(),request.getDistrict() , request.getPincode());
		p.setAddress(a);
		p.setPropertyType(request.getPropertyType());
		p.setBedrooms(request.getBathrooms());
		p.setBathrooms(request.getBathrooms());
		p.setPrice(request.getPrice());		
		propertyDao.save(p);
		return "Update Done";
	}
	@Override
	public List<PropertyResponse> SeachProductByType(String type) {
		List<Property> plist= propertyDao.findByPropertyType(type);
		List<PropertyResponse> prlist= new ArrayList<PropertyResponse>();
		for (Property property : plist) {
			PropertyResponse pr= mapper.map(property, PropertyResponse.class);
			prlist.add(pr);
		}
		return prlist; 
	}

	@Override
	public List<PropertyResponse> SeachProductByUser(Long Userid) {
		Users u=userDao.findById(Userid).orElseThrow(()->new ResourceNotFoundException("Invalid User ID"));
		List<Property> plist= propertyDao.findByUser(u);
		List<PropertyResponse> prlist= new ArrayList<PropertyResponse>();
		for (Property property : plist) {
			PropertyResponse pr= mapper.map(property, PropertyResponse.class);
			prlist.add(pr);
		}
		return prlist; 
	}

	public String DeleteProperty(Long id) {
		Property p=propertyDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
		p.setIsDeleted(true);
		propertyDao.save(p);
		return "Delete Success";
	}
}
