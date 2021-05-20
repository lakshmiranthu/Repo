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
import org.springframework.web.client.RestTemplate;

import com.infosys.user.dto.CartDTO;
import com.infosys.user.dto.WishlistDTO;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.service.CartService;
import com.infosys.user.service.WishlistService;
import com.netflix.discovery.DiscoveryClient;

@CrossOrigin
@RestController
@RequestMapping(value = "/buyer-api")
@Validated
public class WishhlistAPI {

	

	
	@Autowired
	private WishlistService wishlistService;

	@Autowired
	private CartService cartService;
	
	@GetMapping(value = "/wishlist")
	public ResponseEntity<List<WishlistDTO>> displayWishlist(@RequestBody String buyerId) throws UserMSException{
		List<WishlistDTO> wishlist = wishlistService.displayWishlist(buyerId);
		return new ResponseEntity<>(wishlist, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/wishlist/add")
	public ResponseEntity<String> addToWishlist(@RequestBody WishlistDTO wishlistDTO) throws UserMSException{
		String uri = "http://localhost:8100/viewProduct/";
		RestTemplate rest = new RestTemplate();
		rest.getForObject(uri+wishlistDTO.getProdId(),String.class);
		String msg = wishlistService.addTowishlist(wishlistDTO);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	@PostMapping(value="/wishlist/move/{quantity}")
	public ResponseEntity<String> moveToCart(@RequestBody WishlistDTO wishlistDTO,@PathVariable Integer quantity) throws UserMSException{
		CartDTO c = new CartDTO();
		c.setBuyerId(wishlistDTO.getBuyerId());
		c.setProdId(wishlistDTO.getProdId());
		c.setQuantity(quantity);
		String msg = cartService.fillCart(c);
		wishlistService.deleteWishlist(wishlistDTO);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/wishlist/delete/{prodId}")
	public ResponseEntity<String> deleteWishlistItems(@PathVariable Integer prodId) throws UserMSException {
		String msg = wishlistService.deleteProdcutFromWishlist(prodId);
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
}
