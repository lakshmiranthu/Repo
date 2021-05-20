package com.infosys.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.user.entity.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, String>{

	List<Buyer> findByPhoneNumber(String phoneNumber);
	Buyer findByEmail(String emailId);
}
