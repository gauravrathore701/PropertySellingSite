package com.app.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Property;
import com.app.entities.Address;


public interface AddressDao extends JpaRepository<Address, Long> {

	Address findByProperty(Property p);
	List<Address> findByAddLine1Contains(String line1);
	List<Address> findByAddLine2Contains(String line2);
	List<Address> findByCity(String city);
	List<Address> findByDistrict(String district);
	List<Address> findByState(String state);
}
