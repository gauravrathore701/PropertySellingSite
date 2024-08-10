package com.app.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.OrdersDao;
import com.app.dao.PropertyDao;
import com.app.dao.UserDao;
import com.app.dto.OrdersDTOReponse;
import com.app.dto.OrdersDTORequest;
import com.app.entities.Orders;
import com.app.entities.Property;
import com.app.entities.Users;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired 
	private OrdersDao ordersDao;

	@Autowired 
	private UserDao userDao;

	@Autowired 
	private PropertyDao propertyDao;

	@Override
	public List<OrdersDTOReponse> getAllOrders() {
		List<Orders> orderList=ordersDao.findAll();
		List<OrdersDTOReponse> ordrList=new ArrayList<OrdersDTOReponse>();
		for (Orders order : orderList) {
			OrdersDTOReponse orderDTO=new OrdersDTOReponse();
			orderDTO.setId(order.getId());
			orderDTO.setAmount(order.getAmount());
			orderDTO.setOrderCompleted(order.isOrderComplete());
			orderDTO.setPropertyId(order.getProperty().getId());
			orderDTO.setUserId(order.getBuyer().getId());
			ordrList.add(orderDTO);
		}
		return ordrList;
	}

	@Override
	public String AddOrder(OrdersDTORequest request) {
		Users u=userDao.findById(request.getUserid()).orElseThrow((()->new ResourceNotFoundException("Invalid UserId Given")));
		Property p=propertyDao.findById(request.getPropertyid()).orElseThrow((()->new ResourceNotFoundException("Invalid PropertyId Given")));
		if(u.equals(p.getUser())) {
			throw new ResourceNotFoundException("Seller cannot Buy thier own Property");
		}
		List<Orders> orders= ordersDao.findAll();
		for (Orders order : orders) {
			if(order.getProperty().equals(p) && order.getBuyer().equals(u))
				throw new ResourceNotFoundException("Record Already in Orders");
			else if(order.getProperty().equals(p))
				throw new ResourceNotFoundException("Property Already in Orders");
		}
		Orders order=new Orders(p, u, false,p.getPrice());
		ordersDao.save(order);
		return "Order Record Added";
	}

	@Override
	public OrdersDTOReponse getOrderProperty(Long id) {
		Property p=propertyDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid PropertyId Given")));
		Orders order= ordersDao.findByProperty(p).orElseThrow((()->new ResourceNotFoundException("No Such Order Exists")));
		OrdersDTOReponse orderDTO=new OrdersDTOReponse();
		orderDTO.setId(order.getId());
		orderDTO.setAmount(order.getAmount());
		orderDTO.setOrderCompleted(order.isOrderComplete());
		orderDTO.setPropertyId(order.getProperty().getId());
		orderDTO.setUserId(order.getBuyer().getId());
		return orderDTO;
	}

	@Override
	public List<OrdersDTOReponse> getAllOrdersSeller(Long id) {
		Users u=userDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid Seller's Id Given")));
		List<Orders> orderList=ordersDao.findByPropertyUser(u);
		List<OrdersDTOReponse> ordrList=new ArrayList<OrdersDTOReponse>();
		for (Orders order : orderList) {
			OrdersDTOReponse orderDTO=new OrdersDTOReponse();
			orderDTO.setId(order.getId());
			orderDTO.setAmount(order.getAmount());
			orderDTO.setOrderCompleted(order.isOrderComplete());
			orderDTO.setPropertyId(order.getProperty().getId());
			orderDTO.setUserId(order.getBuyer().getId());
			ordrList.add(orderDTO);
		}
		return ordrList;
	}

	@Override
	public List<OrdersDTOReponse> getAllOrdersBuyer(Long id) {
		Users u=userDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid Buyer's Id Given")));
		List<Orders> orderList=ordersDao.findByBuyer(u);
		List<OrdersDTOReponse> ordrList=new ArrayList<OrdersDTOReponse>();
		for (Orders order : orderList) {
			OrdersDTOReponse orderDTO=new OrdersDTOReponse();
			orderDTO.setId(order.getId());
			orderDTO.setAmount(order.getAmount());
			orderDTO.setOrderCompleted(order.isOrderComplete());
			orderDTO.setPropertyId(order.getProperty().getId());
			orderDTO.setUserId(order.getBuyer().getId());
			ordrList.add(orderDTO);
		}
		return ordrList;
	}

	@Override
	public List<OrdersDTOReponse> getAllOrderCompleted() {
		List<Orders> orderList=ordersDao.findByOrderComplete(true);
		List<OrdersDTOReponse> ordrList=new ArrayList<OrdersDTOReponse>();
		for (Orders order : orderList) {
			OrdersDTOReponse orderDTO=new OrdersDTOReponse();
			orderDTO.setId(order.getId());
			orderDTO.setAmount(order.getAmount());
			orderDTO.setOrderCompleted(order.isOrderComplete());
			orderDTO.setPropertyId(order.getProperty().getId());
			orderDTO.setUserId(order.getBuyer().getId());
			ordrList.add(orderDTO);
		}
		return ordrList;
	}

	@Override
	public List<OrdersDTOReponse> getAllOrderInProgress() {
		List<Orders> orderList=ordersDao.findByOrderComplete(false);
		List<OrdersDTOReponse> ordrList=new ArrayList<OrdersDTOReponse>();
		for (Orders order : orderList) {
			OrdersDTOReponse orderDTO=new OrdersDTOReponse();
			orderDTO.setId(order.getId());
			orderDTO.setAmount(order.getAmount());
			orderDTO.setOrderCompleted(order.isOrderComplete());
			orderDTO.setPropertyId(order.getProperty().getId());
			orderDTO.setUserId(order.getBuyer().getId());
			ordrList.add(orderDTO);
		}
		return ordrList;
	}

	@Override
	public String ToggleOrder(Long id) {
		Orders order=ordersDao.findById(id).orElseThrow((()->new ResourceNotFoundException("Invalid OrderId Given")));
		if(order.isOrderComplete()) {
			throw new ResourceNotFoundException("Order Already Processed");
		}
		else
			order.setOrderComplete(true);
		return "Order Status Changed";
	}

}
