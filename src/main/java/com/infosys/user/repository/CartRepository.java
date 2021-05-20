package com.infosys.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infosys.user.entity.Cart;
import com.infosys.user.entity.CompositeKeyCart;

public interface CartRepository extends JpaRepository<Cart, CompositeKeyCart>{
	
	@Query("select C from Cart C where C.prodId = :prodId")
	public Cart findByProdId(@Param("prodId") Integer prodId);
}
