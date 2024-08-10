package com.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.dao.AddressDao;
import com.app.dto.AddressDTO;
import com.app.dto.PropertyResponse;
import com.app.entities.Address;
import com.app.entities.Property;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

	@Autowired 
	private AddressDao addressDao;

	@Autowired 
	private ModelMapper mapper;

	@Override
	public List<AddressDTO> getAllAddress() {
		List<Address> addrList=addressDao.findAll();
		ArrayList<AddressDTO> addList=new ArrayList<AddressDTO>();
		for (Address address : addrList) {
			AddressDTO addr=mapper.map(address, AddressDTO.class);
			addList.add(addr);
		}
		return addList;
	}

	@Override
	public Set<PropertyResponse> SeachPropertyByAddrLine1(String addrLine1) {
		List<Address> addrList=addressDao.findByAddLine1Contains(addrLine1);
		Set<PropertyResponse> propList=new HashSet<PropertyResponse>();
		for (Address address : addrList) {
			if(address.getProperty()!=null) {
				Property property=address.getProperty();
				PropertyResponse prop=mapper.map(property, PropertyResponse.class);
				propList.add(prop);
			}
		}
		return propList;
	}

	@Override
	public Set<PropertyResponse> SeachPropertyByAddrLine2(String addrLine2) {
		List<Address> addrList=addressDao.findByAddLine2Contains(addrLine2);
		Set<PropertyResponse> propList=new HashSet<PropertyResponse>();
		for (Address address : addrList) {
			if(address.getProperty()!=null) {
				Property property=address.getProperty();
				PropertyResponse prop=mapper.map(property, PropertyResponse.class);
				propList.add(prop);
			}
		}
		return propList;
	}

	@Override
	public Set<PropertyResponse> SeachPropertyByCity(String city) {
		List<Address> addrList=addressDao.findByCity(city);
		Set<PropertyResponse> propList=new HashSet<PropertyResponse>();
		for (Address address : addrList) {
			if(address.getProperty()!=null) {
				Property property=address.getProperty();
				PropertyResponse prop=mapper.map(property, PropertyResponse.class);
				propList.add(prop);
			}
		}
		return propList;
	}

	@Override
	public Set<PropertyResponse> SeachPropertyByDistrict(String district) {
		List<Address> addrList=addressDao.findByDistrict(district);
		Set<PropertyResponse> propList=new HashSet<PropertyResponse>();
		for (Address address : addrList) {
			if(address.getProperty()!=null) {
				Property property=address.getProperty();
				PropertyResponse prop=mapper.map(property, PropertyResponse.class);
				propList.add(prop);
			}
		}
		return propList;
	}

	@Override
	public Set<PropertyResponse> SeachPropertyByState(String state) {
		List<Address> addrList=addressDao.findByState(state);
		Set<PropertyResponse> propList=new HashSet<PropertyResponse>();
		for (Address address : addrList) {
			if(address.getProperty()!=null) {
				Property property=address.getProperty();
				PropertyResponse prop=mapper.map(property, PropertyResponse.class);
				propList.add(prop);
			}
		}
		return propList;
	}

}
