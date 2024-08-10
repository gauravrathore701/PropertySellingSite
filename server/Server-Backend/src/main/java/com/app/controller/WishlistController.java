package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.WishListDTORequest;
import com.app.service.WishlistService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/wishlist")
public class WishlistController {
	@Autowired
	private WishlistService wishlistService;
	
	@GetMapping("/list/wishlist")
	@Operation(summary = "To get All Wishlist")
	public ResponseEntity<?> getAllWishlist(){
		return ResponseEntity.ok(wishlistService.getAllWishlist());
	}
	
	@GetMapping("/list/cart")
	@Operation(summary = "To get All Cart Items")
	public ResponseEntity<?> getAllCart(){
		return ResponseEntity.ok(wishlistService.getAllCart());
	}
	
	@GetMapping("/list/wishlist/{userId}")
	@Operation(summary = "To get All Wishlist Items by UserId")
	public ResponseEntity<?> getUserWishlist(@PathVariable Long userId){
		return ResponseEntity.ok(wishlistService.getAllWishlistUser(userId));
	}
	
	@GetMapping("/list/cart/{userId}")
	@Operation(summary = "To get All Cart Items by UserId")
	public ResponseEntity<?> getUserCart(@PathVariable Long userId){
		return ResponseEntity.ok(wishlistService.getAllCartUser(userId));
	}
	
	@PostMapping("/add/cart")
	@Operation(summary = "To Add Cart Item")
	public ResponseEntity<?> AddUserCart(@RequestBody WishListDTORequest request){
		return ResponseEntity.ok(new ApiResponse(wishlistService.AddUserCart(request)));
	}
	
	@PostMapping("/add/wishlist")
	@Operation(summary = "To Add Wishlst Item")
	public ResponseEntity<?> AddUserWishlist(WishListDTORequest request){
		return ResponseEntity.ok(new ApiResponse(wishlistService.AddUserWishlist(request)));
	}
	
	@PutMapping("/toggle/{id}")
	@Operation(summary = "To Toggle Wishlst/Cart Record")
	public ResponseEntity<?> ToggleWishlistCart(@PathVariable Long id){
		return ResponseEntity.ok(new ApiResponse(wishlistService.ToggleWishlistCart(id)));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "To Delete Wishlst/Cart Record")
	public ResponseEntity<?> DeleteWishlistCart(@PathVariable Long id){
		return ResponseEntity.ok(new ApiResponse(wishlistService.DeleteFromWishlist(id)));
	}
	
}