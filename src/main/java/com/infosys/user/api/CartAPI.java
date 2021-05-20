package com.infosys.user.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.user.dto.CartDTO;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.service.CartService;
import com.netflix.discovery.DiscoveryClient;

@CrossOrigin
@RestController
@RequestMapping(value = "/buyer-api")
@Validated
public class CartAPI {

	

	
	@Autowired
	private CartService cartService;

	
	@GetMapping(value = "/cart")
	public ResponseEntity<List<CartDTO>> displayCart(@RequestBody String buyerId) throws UserMSException{
		List<CartDTO> wishlist = cartService.displayCart(buyerId);
		return new ResponseEntity<>(wishlist, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/cart/add")
	public ResponseEntity<String> addToCart(@RequestBody CartDTO cartDTO) throws UserMSException {
		String msg = cartService.fillCart(cartDTO);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/cart/delete/{prodId}")
	public ResponseEntity<String> deleteCartItems(@PathVariable Integer prodId) throws UserMSException {
		String msg = cartService.deleteProdcutFromCart(prodId);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
