package com.infosys.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.user.entity.Seller;

public interface SellerRepository extends JpaRepository<Seller, String>{

	List<Seller> findByPhoneNumber(String phoneNumber);
	Seller findByEmail(String emailId);
}
