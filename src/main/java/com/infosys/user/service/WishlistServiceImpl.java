package com.infosys.user.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.user.dto.WishlistDTO;
import com.infosys.user.entity.Wishlist;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.repository.WishlistRepository;

@Service("wishlistService")
@Transactional
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;
	

	public String addTowishlist(WishlistDTO wishlistDTO) throws  UserMSException{
		
		Wishlist w = new Wishlist();
		w.setBuyerId(wishlistDTO.getBuyerId());
		w.setProdId(wishlistDTO.getProdId());
		wishlistRepository.save(w);
		return "Product added to wishlist.";
	}
	
	@Override
	public List<WishlistDTO> displayWishlist(String buyerId) throws UserMSException {
		List<WishlistDTO> wishlistDtoList = new ArrayList<>();
		if(wishlistRepository.findAll().isEmpty())
			throw new UserMSException("Empty Wishlist");
		else {
			List<Wishlist> wishlist = wishlistRepository.findAll();
			for(Wishlist w: wishlist) {
				WishlistDTO wishlistDto = new WishlistDTO();
				wishlistDto.setBuyerId(w.getBuyerId());
				wishlistDto.setProdId(w.getProdId());
				wishlistDtoList.add(wishlistDto);
			}
		}
		return wishlistDtoList;
	}

	public String deleteProdcutFromWishlist(Integer prodId) throws UserMSException{
		Wishlist c= wishlistRepository.findByProdId(prodId);
		wishlistRepository.delete(c);
		return "Product is deleted from your wishlist";
	}
	
	public String deleteWishlist(WishlistDTO wishlistDTO) throws UserMSException{
		Wishlist c= wishlistRepository.findByProdId(wishlistDTO.getProdId());
		wishlistRepository.delete(c);
		return "Product is deleted from your wishlist";
	}


	
}
