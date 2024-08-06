package com.app.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Property;
import com.app.entities.PropertyType;
import com.app.entities.Users;


public interface PropertyDao extends JpaRepository<Property, Long> {

	List<Property> findByPropertyType(PropertyType type);
	
	List<Property> findByUser(Users u);
}
