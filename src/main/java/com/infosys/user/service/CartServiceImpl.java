package com.infosys.user.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.user.dto.CartDTO;
import com.infosys.user.entity.Cart;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.repository.CartRepository;

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	

	public String fillCart(CartDTO cartDTO) throws UserMSException{
		Cart cart = new Cart();
		cart.setBuyerId(cartDTO.getBuyerId());
		cart.setProdId(cartDTO.getProdId());
		cart.setQuantity(cartDTO.getQuantity());
		cartRepository.save(cart);
		return "Items added to cart.";
	}
	public String deleteProdcutFromCart(Integer prodId) throws UserMSException{
		Cart c= cartRepository.findByProdId(prodId);
		cartRepository.delete(c);
		return "Product is deleted from your cart";
	}

	@Override
	public List<CartDTO> displayCart(String buyerId) throws UserMSException {
		List<CartDTO> cartDtoList = new ArrayList<>();
		if(cartRepository.findAll().isEmpty())
			throw new UserMSException("Your cart is empty. To view your products, please add items to cart.");
		else {
			List<Cart> wishlist = cartRepository.findAll();
			for(Cart w: wishlist) {
				CartDTO cartDto = new CartDTO();
				cartDto.setBuyerId(w.getBuyerId());
				cartDto.setProdId(w.getProdId());
				cartDtoList.add(cartDto);
			}
		}
		return cartDtoList;
	}
}