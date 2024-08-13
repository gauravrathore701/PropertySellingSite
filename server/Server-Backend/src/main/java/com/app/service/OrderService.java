package com.app.service;

import java.util.List;
import com.app.dto.OrdersDTOReponse;
import com.app.dto.OrdersDTORequest;
import com.app.entities.Orders;

public interface OrderService {
	List<OrdersDTOReponse> getAllOrders();

	String AddOrder(OrdersDTORequest request);
	
	OrdersDTOReponse getOrderProperty(Long id);

	List<OrdersDTOReponse> getAllOrdersSeller(Long id);

	List<OrdersDTOReponse> getAllOrdersBuyer(Long id);
	
	List<OrdersDTOReponse> getAllOrderCompleted();
	
	List<OrdersDTOReponse> getAllOrderInProgress();

	String ToggleOrder(Long id);

}
