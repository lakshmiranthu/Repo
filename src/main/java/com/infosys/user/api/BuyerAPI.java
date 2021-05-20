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

import com.infosys.user.dto.BuyerDTO;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.service.BuyerService;
import com.netflix.discovery.DiscoveryClient;

@CrossOrigin
@RestController
@RequestMapping(value = "/buyer-api")
@Validated
public class BuyerAPI {

	
	
	@Autowired
	private BuyerService buyerService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> athenticateBuyer(@Valid @RequestBody BuyerDTO buyerDto) throws UserMSException{
		BuyerDTO buyerDtoFromDb = buyerService.authenticateBuyer(buyerDto.getEmail(), buyerDto.getPassword());
		return new ResponseEntity<>("Login Successful of " + buyerDtoFromDb.getName(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/buyers")
	public ResponseEntity<String> registerBuyer(@Valid @RequestBody BuyerDTO buyerDto) throws UserMSException{
		String registeredWithEmailId = buyerService.regsiterNewBuyer(buyerDto);
		registeredWithEmailId = "Regsitered New Buyer with Email ID: " + registeredWithEmailId;
		return new ResponseEntity<>(registeredWithEmailId, HttpStatus.OK);
	}
}
