package com.app.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PropertyDao;
import com.app.dao.UserDao;
import com.app.dao.WishlistDao;
import com.app.dto.WishListDTOReponse;
import com.app.dto.WishListDTORequest;
import com.app.entities.Property;
import com.app.entities.Users;
import com.app.entities.WishList;

@Service
@Transactional
public class WishlistServiceImpl implements WishlistService {

	@Autowired 
	private WishlistDao wishlistDao;

	@Autowired 
	private UserDao userDao;

	@Autowired 
	private PropertyDao propertyDao;

	@Override
	public List<WishListDTOReponse> getAllWishlist() {
		List<WishList> wishlist=wishlistDao.findAll();
		List<WishListDTOReponse> wishlistDTO= new ArrayList<WishListDTOReponse>();
		for (WishList wish : wishlist) {
			if(wish.isOnCart()==false) {
				WishListDTOReponse wishDTO=new WishListDTOReponse();
				wishDTO.setId(wish.getId());
				wishDTO.setUserid(wish.getUser().getId());
				wishDTO.setProperty(wish.getProperty().getId());
				wishDTO.setOnCart(wish.isOnCart());
				wishlistDTO.add(wishDTO);
			}
		}
		return wishlistDTO;
	}

	@Override
	public List<WishListDTOReponse> getAllCart() {
		List<WishList> wishlist=wishlistDao.findAll();
		List<WishListDTOReponse> wishlistDTO= new ArrayList<WishListDTOReponse>();
		for (WishList wish : wishlist) {
			if(wish.isOnCart()==true) {
				WishListDTOReponse wishDTO=new WishListDTOReponse();
				wishDTO.setId(wish.getId());
				wishDTO.setUserid(wish.getUser().getId());
				wishDTO.setProperty(wish.getProperty().getId());
				wishDTO.setOnCart(wish.isOnCart());
				wishlistDTO.add(wishDTO);
			}
		}
		return wishlistDTO;
	}

	@Override
	public List<WishListDTOReponse> getAllWishlistUser(Long userId) {
		Users u=userDao.findById(userId).orElseThrow((()->new ResourceNotFoundException("Invalid UserId Given")));
		List<WishList> wishlist=wishlistDao.findByUser(u);
		List<WishListDTOReponse> wishlistDTO= new ArrayList<WishListDTOReponse>();
		for (WishList wish : wishlist) {
			if(wish.isOnCart()==false) {
				WishListDTOReponse wishDTO=new WishListDTOReponse();
				wishDTO.setId(wish.getId());
				wishDTO.setUserid(wish.getUser().getId());
				wishDTO.setProperty(wish.getProperty().getId());
				wishDTO.setOnCart(wish.isOnCart());
				wishlistDTO.add(wishDTO);
			}
		}
		return wishlistDTO;
	}

	@Override
	public List<WishListDTOReponse> getAllCartUser(Long userId) {
		Users u=userDao.findById(userId).orElseThrow((()->new ResourceNotFoundException("Invalid UserId Given")));
		List<WishList> wishlist=wishlistDao.findByUser(u);
		List<WishListDTOReponse> wishlistDTO= new ArrayList<WishListDTOReponse>();
		for (WishList wish : wishlist) {
			if(wish.isOnCart()==true) {
				WishListDTOReponse wishDTO=new WishListDTOReponse();
				wishDTO.setId(wish.getId());
				wishDTO.setUserid(wish.getUser().getId());
				wishDTO.setProperty(wish.getProperty().getId());
				wishDTO.setOnCart(wish.isOnCart());
				wishlistDTO.add(wishDTO);
			}
		}
		return wishlistDTO;
	}

	@Override
	public String AddUserWishlist(WishListDTORequest request) {
		Users u=userDao.findById(request.getUserid()).orElseThrow((()->new ResourceNotFoundException("Invalid UserId Given")));
		Property p=propertyDao.findById(request.getPropertyid()).orElseThrow((()->new ResourceNotFoundException("Invalid PropertyId Given")));
		List<WishList> wishlist= wishlistDao.findAll();
		for (WishList wish : wishlist) {
			if(wish.getProperty().equals(p) && wish.getUser().equals(u)) {
				if(wish.isOnCart()==false)
					throw new ResourceNotFoundException("Record Already in Wishlist");
				else
					throw new ResourceNotFoundException("Record Already in Cart");
			}
		}
		WishList w=new WishList();
		w.setProperty(p);
		w.setUser(u);
		w.setOnCart(false);
		wishlistDao.save(w);
		return "WishList Record Added";
	}

	@Override
	public String AddUserCart(WishListDTORequest request) {
		Users u=userDao.findById(request.getUserid()).orElseThrow((()->new ResourceNotFoundException("Invalid UserId Given")));
		Property p=propertyDao.findById(request.getPropertyid()).orElseThrow((()->new ResourceNotFoundException("Invalid PropertyId Given")));
		List<WishList> wishlist= wishlistDao.findAll();
		boolean found=true;
		for (WishList wish : wishlist) {
			if(wish.getProperty().equals(p) && wish.getUser().equals(u)) {
				if(wish.isOnCart()==true)
					throw new ResourceNotFoundException("Record Already in Cart");
				else
					wish.setOnCart(true);
				found=false;
				wishlistDao.save(wish);
			}
		}
		if(found) {
			WishList w=new WishList();
			w.setProperty(p);
			w.setUser(u);
			w.setOnCart(true);
			wishlistDao.save(w);
		}
		return "Cart Record Added";
	}

	@Override
	public String ToggleWishlistCart(Long id) {
		WishList w=wishlistDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid WishlistId Given")));
		if(w.isOnCart()==true)
			w.setOnCart(false);
		else
			w.setOnCart(true);
		wishlistDao.save(w);
		return "Record Toggled";
	}

	@Override
	public String DeleteFromWishlist(Long id) {
		WishList w=wishlistDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid WishlistId Given")));
		wishlistDao.delete(w);
		return "Record Deleted";
	}


}
