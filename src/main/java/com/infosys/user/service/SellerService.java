package com.infosys.user.service;

import com.infosys.user.dto.SellerDTO;
import com.infosys.user.exception.UserMSException;

public interface SellerService {
	
	String regsiterNewSeller(SellerDTO sellerDto) throws UserMSException;
	
	SellerDTO authenticateSeller(String emailId, String password) throws UserMSException;

}
