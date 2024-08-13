package com.app.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.app.dto.PropertyResponsePaginated;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.PropertyDao;
import com.app.dao.TagDao;
import com.app.dao.UserDao;
import com.app.dto.PropertyRequest;
import com.app.dto.PropertyResponse;
import com.app.dto.TagsDTORequest;
import com.app.entities.Address;
import com.app.entities.Property;
import com.app.entities.PropertyType;
import com.app.entities.Tags;
import com.app.entities.Users;

@Service
@Transactional
public class PropertyServiceImpl implements PropertyService {

	@Autowired 
	private PropertyDao propertyDao;

	@Autowired 
	private UserDao userDao;

	@Autowired 
	private AddressDao addressDao;

	@Autowired 
	private TagDao tagDao;

	@Autowired 
	private ModelMapper mapper;

	@Override
	public PropertyResponse addNewProperty(@Valid PropertyRequest request, Long id) {
		System.out.println(request);
		Property p= mapper.map(request, Property.class);
		Set<TagsDTORequest> tagDTO=request.getTags();
		System.out.println(tagDTO);
		Set<Tags> tags = new HashSet<>();
		Users u=userDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid Id Given")));
		Address a= new Address(request.getAddress().getAddLine1(),request.getAddress().getAddLine2(), request.getAddress().getCity(), request.getAddress().getState(),
				request.getAddress().getDistrict() , request.getAddress().getPincode(), p);
		p.setAddress(a);		
		p.setUser(u);
		p.setIsSold(false);
		p.setIsDeleted(false);
		List<Tags> tagsList=tagDao.findAll();
		for (TagsDTORequest tag : tagDTO) {
			System.out.println("Gone in Loop for "+tag);
			System.out.println(tag.getTagName());
			Tags t=mapper.map(tag, Tags.class);
			if(tagsList.contains(t)) {
				int index=tagsList.indexOf(t);
				Tags t1=tagsList.get(index);
				//			tagf=tagDao.findByTagName(tag.getTagName()).orElse(null);
				System.out.println("hello : "+tag);
				//			if(tagf!=null) {
				System.out.println(t1.getTagName()+" "+t1.getTagDesc());
				System.out.println(t1.getProperty());
				t1.getProperty().add(p);
				tags.add(t1);
				System.out.println("Added in Set-Tags");
				System.out.println(tags);
			}
			else {
				System.out.println("Gone in Not Null");
				System.out.println(t.getProperty());
				t.getProperty().add(p);
				tags.add(t);
			}
		}
		System.out.println("Out Loop");
		p.setTags(tags);
		Property savedProp=propertyDao.save(p);
		return mapper.map(savedProp, PropertyResponse.class);
	}

	@Override
	public PropertyResponsePaginated getAll(int page,int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Property> propertyPage = propertyDao.findAll(pageable);
		List<Property> plist = propertyDao.findAll(pageable).getContent();
		List<PropertyResponse> prlist= new ArrayList<PropertyResponse>();
		for (Property property : plist) {
			PropertyResponse pr= mapper.map(property, PropertyResponse.class);
			prlist.add(pr);
		}
		int totalPages = propertyPage.getTotalPages();
		return new PropertyResponsePaginated(prlist, totalPages);
	}
	
	public PropertyResponse getById(Long id) {
		Property property=propertyDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
		PropertyResponse pr=mapper.map(property, PropertyResponse.class);
		pr.setOwner(property.getUser().getFname()+" "+property.getUser().getLname());
		return pr;
	}

	@Override
	public String updatePropertyDetails(PropertyRequest request, Long id) {
		Property p=propertyDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
		Address a= addressDao.findByProperty(p);
		Set<TagsDTORequest> tagDTO=request.getTags();
		Set<Tags> tags = p.getTags();
		// Removing Existing Tags from Property & Vice Versa
		for (Tags tags2 : tags) {
			Optional<Tags> t=tagDao.findByTagName(tags2.getTagName());
			t.get().getProperty().remove(p);
		}
		p.setTags(new HashSet<Tags>());
		a.setAddLine1(request.getAddress().getAddLine1());
		a.setAddLine2(request.getAddress().getAddLine2());
		a.setCity(request.getAddress().getCity());
		a.setDistrict(request.getAddress().getDistrict());
		a.setState(request.getAddress().getState());
		a.setPincode(request.getAddress().getPincode());
		p.setAddress(a);
		p.setTitle(request.getTitle());
		p.setDescription(request.getDescription());
		p.setPropertyType(request.getPropertyType());
		p.setBedrooms(request.getBedrooms());
		p.setWashrooms(request.getWashrooms());
		p.setPrice(request.getPrice());	
		List<Tags> tagsList=tagDao.findAll();
		for (TagsDTORequest tag : tagDTO) {
			System.out.println("Gone in Loop for "+tag);
			System.out.println(tag.getTagName());
			Tags t=mapper.map(tag, Tags.class);
			if(tagsList.contains(t)) {
				int index=tagsList.indexOf(t);
				Tags t1=tagsList.get(index);
				System.out.println("hello : "+tag);
				System.out.println(t1.getTagName()+" "+t1.getTagDesc());
				System.out.println(t1.getProperty());
				t1.getProperty().add(p);
				tags.add(t1);
				System.out.println("Added in Set-Tags");
				System.out.println(tags);
			}
			else {
				System.out.println("Gone in Not Null");
				System.out.println(t.getProperty());
				t.getProperty().add(p);
				tags.add(t);
			}
		}
		p.setTags(tags);
		propertyDao.save(p);
		return "Update Done";
	}

	@Override
	public String sellingProperty(PropertyRequest request, Long Propertyid) {
		Property p=propertyDao.findById(Propertyid).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
		p.setIsSold(true);	
		propertyDao.save(p);
		return "Property Selling Done";
	}

	@Override
	public List<PropertyResponse> seachProductByType(String type) {
		List<Property> plist= propertyDao.findByPropertyType(PropertyType.valueOf(type));
		List<PropertyResponse> prlist= new ArrayList<PropertyResponse>();
		for (Property property : plist) {
			PropertyResponse pr= mapper.map(property, PropertyResponse.class);
			prlist.add(pr);
		}
		return prlist; 
	}

	@Override
	public List<PropertyResponse> seachProductByUser(Long Userid) {
		Users u=userDao.findById(Userid).orElseThrow(()->new ResourceNotFoundException("Invalid User ID"));
		List<Property> plist= propertyDao.findByUser(u);
		List<PropertyResponse> prlist= new ArrayList<PropertyResponse>();
		for (Property property : plist) {
			PropertyResponse pr= mapper.map(property, PropertyResponse.class);
			pr.setOwner(property.getUser().getFname()+" "+property.getUser().getLname());
			prlist.add(pr);
		}
		return prlist; 
	}

	public String deleteProperty(Long id) {
		Property p=propertyDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid ID"));
		p.setIsDeleted(true);
		propertyDao.save(p);
		return "Delete Success";
	}
}
