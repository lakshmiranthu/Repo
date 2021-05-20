package com.infosys.user.service;

import java.util.List;

import com.infosys.user.dto.CartDTO;
import com.infosys.user.exception.UserMSException;

public interface CartService {

	List<CartDTO> displayCart(String buyerId) throws UserMSException;
	String fillCart(CartDTO cartDTO) throws UserMSException;
	String deleteProdcutFromCart(Integer prodId) throws UserMSException;
}
