package com.infosys.user.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.user.dto.SellerDTO;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.service.SellerService;
import com.netflix.discovery.DiscoveryClient;

@CrossOrigin
@RestController
@RequestMapping(value = "/seller-api")
@Validated
public class SellerAPI {

	

	
	@Autowired
	private SellerService sellerService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> athenticateSeller(@Valid @RequestBody SellerDTO sellerDto) throws UserMSException{
		SellerDTO sellerDtoFromDb = sellerService.authenticateSeller(sellerDto.getEmail(), sellerDto.getPassword());
		return new ResponseEntity<>("Login Successful of " + sellerDtoFromDb.getName(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/sellers")
	public ResponseEntity<String> registerSeller(@Valid @RequestBody SellerDTO sellerDto) throws UserMSException{
		String registeredWithEmailId = sellerService.regsiterNewSeller(sellerDto);
		registeredWithEmailId = "Regsitered New Seller with Email ID: " + registeredWithEmailId;
		return new ResponseEntity<>(registeredWithEmailId, HttpStatus.OK);
	}
}
