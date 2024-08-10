package com.app.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Users;
import com.app.entities.WishList;

public interface WishlistDao extends JpaRepository<WishList, Long> {
	List<WishList> findByUser(Users u);
}
