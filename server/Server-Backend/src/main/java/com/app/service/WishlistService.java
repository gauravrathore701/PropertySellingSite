package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.dto.AddressDTO;
import com.app.dto.PropertyResponse;
import com.app.dto.WishListDTOReponse;
import com.app.dto.WishListDTORequest;

public interface WishlistService {
	List<WishListDTOReponse> getAllWishlist();

	List<WishListDTOReponse> getAllCart();

	List<WishListDTOReponse> getAllWishlistUser(Long id);

	List<WishListDTOReponse> getAllCartUser(Long id);

	String AddUserWishlist(WishListDTORequest request);

	String AddUserCart(WishListDTORequest request);
	
	String ToggleWishlistCart(Long id);

	String DeleteFromWishlist(Long id);
}
