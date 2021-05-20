package com.infosys.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infosys.user.entity.CompositeKeyWishlist;
import com.infosys.user.entity.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, CompositeKeyWishlist>{
	
	@Query("select W from Wishlist W where W.prodId = :prodId")
	public Wishlist findByProdId(@Param("prodId") Integer prodId);
}
