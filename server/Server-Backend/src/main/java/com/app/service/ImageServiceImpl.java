package com.app.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.ImagesDao;
import com.app.dao.PropertyDao;
import com.app.dao.UserDao;
import com.app.dto.ImageDTORequest;
import com.app.dto.ImageDTOResponse;
import com.app.dto.UserImageDTO;
import com.app.entities.Images;
import com.app.entities.Property;
import com.app.entities.Users;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired 
	private ImagesDao imageDao;

	@Autowired 
	private PropertyDao propertyDao;
	
	@Autowired 
	private UserDao userDao;

	@Autowired 
	private ModelMapper mapper;

	@Override
	public ImageDTOResponse getImage(Long imageId) {
		Images img=imageDao.findById(imageId).orElseThrow((()->new ResourceNotFoundException("Invalid Property Id Given")));
		ImageDTOResponse imgDTO = mapper.map(img, ImageDTOResponse.class);
		return imgDTO;
	}
	@Override
	public List<ImageDTOResponse> getAll() {
		List<Images> imgList=imageDao.findAll();
		List<ImageDTOResponse> imgDList=new ArrayList<ImageDTOResponse>();
		for (Images image : imgList) {
			ImageDTOResponse img=mapper.map(image, ImageDTOResponse.class);
			imgDList.add(img);
		}
		return imgDList;
	}

	@Override
	public String addNewImageProperty(@Valid ImageDTORequest imageBody, Long propertyId) {
		Property p= propertyDao.findById(propertyId).orElseThrow((()->new ResourceNotFoundException("Invalid Property Id Given")));
		MultipartFile[] images= imageBody.getImageLink();
		for (MultipartFile image : images) {
			Images img=mapper.map(image, Images.class);
			img.setProperty(p);
			String link ="src/main/resources/static/"+image.getOriginalFilename();
			try {

				FileUtils.writeByteArrayToFile(new File(link), image.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			img.setImageLink(image.getOriginalFilename());
			imageDao.save(img);
		}
		return "Image Added Successfully";
	}

	@Override
	public String DeletePropertyImages(Long imageId) {
		Images img=imageDao.findById(imageId).orElseThrow((()->new ResourceNotFoundException("Invalid Image Id Given")));
		imageDao.delete(img);
		return "Image has Been Removed";
	}

	@Override
	public List<ImageDTOResponse> SeachImagesByProperty(Long propertyId) {
		Property p= propertyDao.findById(propertyId).orElseThrow((()->new ResourceNotFoundException("Invalid Property Id Given")));
		List<Images> imgList=imageDao.findByProperty(p);
		List<ImageDTOResponse> imgDList=new ArrayList<ImageDTOResponse>();
		for (Images image : imgList) {
			ImageDTOResponse img=mapper.map(image, ImageDTOResponse.class);
			imgDList.add(img);
		}
		return imgDList;
	}
	@Override
	public String addNewImageUser(@Valid ImageDTORequest imageBody, Long userId) {
		Users u= userDao.findById(userId).orElseThrow((()->new ResourceNotFoundException("Invalid User Id Given")));
		MultipartFile[] images= imageBody.getImageLink();
		for (MultipartFile image : images) {
			try {
				u.setProfilePicture(image.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Image Added Successfully";
	}

}
