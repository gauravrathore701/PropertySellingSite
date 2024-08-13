package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.dto.ApiResponse;
import com.app.dto.OrdersDTORequest;
import com.app.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@Validated
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/list")
	@Operation(summary = "To get All Orders")
	public ResponseEntity<?> getAllOrders(){
		return ResponseEntity.ok(orderService.getAllOrders());
	}
	
	@PostMapping("/add")
	@Operation(summary = "To Add Order Record")
	public ResponseEntity<?> AddUserWishlist(OrdersDTORequest request){
		return ResponseEntity.ok(new ApiResponse(orderService.AddOrder(request)));
	}
	
	@GetMapping("/list/property/{propId}")
	@Operation(summary = "To get All Orders by Property")
	public ResponseEntity<?> getAllOrdersByProperty(@PathVariable Long propId){
		return ResponseEntity.ok(orderService.getOrderProperty(propId));
	}
	
	@GetMapping("/list/seller/{userId}")
	@Operation(summary = "To get All Orders by Seller")
	public ResponseEntity<?> getAllOrdersBySeller(@PathVariable Long userId){
		return ResponseEntity.ok(orderService.getAllOrdersSeller(userId));
	}
	
	@GetMapping("/list/buyer/{userId}")
	@Operation(summary = "To get All Orders by Buyer")
	public ResponseEntity<?> getAllOrdersByBuyer(@PathVariable Long userId){
		return ResponseEntity.ok(orderService.getAllOrdersBuyer(userId));
	}
	
	@GetMapping("/list/complete")
	@Operation(summary = "To get All Completed Orders")
	public ResponseEntity<?> getAllCompletedOrders(){
		return ResponseEntity.ok(orderService.getAllOrderCompleted());
	}
	
	@GetMapping("/list/in-progress")
	@Operation(summary = "To get All In-Progress Orders")
	public ResponseEntity<?> getAllInProgressOrders(){
		return ResponseEntity.ok(orderService.getAllOrderInProgress());
	}
	
	@PutMapping("/toggle/{id}")
	@Operation(summary = "To Complete Order Record")
	public ResponseEntity<?> ToggleWishlistCart(@PathVariable Long id){
		return ResponseEntity.ok(new ApiResponse(orderService.ToggleOrder(id)));
	}
	
}