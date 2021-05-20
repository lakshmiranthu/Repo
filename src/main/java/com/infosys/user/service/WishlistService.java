package com.infosys.user.service;

import java.util.List;

import com.infosys.user.dto.WishlistDTO;
import com.infosys.user.exception.UserMSException;

public interface WishlistService {
	
	List<WishlistDTO> displayWishlist(String buyerId) throws UserMSException;
	String addTowishlist(WishlistDTO wishlistDTO) throws  UserMSException;
	String deleteProdcutFromWishlist(Integer prodId) throws UserMSException;
	String deleteWishlist(WishlistDTO wishlistDTO) throws UserMSException;
}
