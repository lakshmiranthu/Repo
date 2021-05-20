package com.infosys.user.service;

import com.infosys.user.dto.BuyerDTO;
import com.infosys.user.exception.UserMSException;

public interface BuyerService {
	
	String regsiterNewBuyer(BuyerDTO buyerDto) throws UserMSException;
	
	BuyerDTO authenticateBuyer(String emailId, String password) throws UserMSException;

}
