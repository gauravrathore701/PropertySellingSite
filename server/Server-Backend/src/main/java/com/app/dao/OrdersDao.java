package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Orders;
import com.app.entities.Property;
import com.app.entities.Users;

public interface OrdersDao extends JpaRepository<Orders, Long> {
	List<Orders> findByBuyer(Users u);
	Optional<Orders> findByProperty(Property p);
	List<Orders> findByPropertyUser(Users u);
	List<Orders> findByOrderComplete(boolean os);
}
