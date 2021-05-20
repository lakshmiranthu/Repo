package com.infosys.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.user.dto.BuyerDTO;
import com.infosys.user.entity.Buyer;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.repository.BuyerRepository;

@Service("buyerService")
@Transactional
public class BuyerServiceImpl implements BuyerService {

	
	private static String id = "B1";
	
	@Autowired
	private BuyerRepository buyerRepository;
	
	@Override
	public BuyerDTO authenticateBuyer(String emailId, String password) throws UserMSException {
		BuyerDTO buyerDto = new BuyerDTO();
		Buyer buyer = buyerRepository.findByEmail(emailId.toLowerCase());
		if(!password.equals(buyer.getPassword()))
			throw new UserMSException("Invalid Credentials");
		buyerDto.setEmail(buyer.getEmail());
		buyerDto.setBuyerId(buyer.getBuyerId());
		buyerDto.setIsActive(buyer.getIsActive());
		buyerDto.setIsPriviledged(buyer.getIsPriviledged());
		buyerDto.setName(buyer.getName());
		buyerDto.setPassword(buyer.getPassword());
		buyerDto.setPhoneNumber(buyer.getPhoneNumber());
		buyerDto.setRewardPoints(buyer.getRewardPoints());
		return buyerDto;
	}
	
	//register as buyer
	@Override
	public String regsiterNewBuyer(BuyerDTO buyerDto) throws UserMSException{
		String registeredWithEmailID = null;
		boolean isEmailNotAvailable = buyerRepository.findById(buyerDto.getEmail()).isEmpty();
		boolean isPhoneNumberNotAvailable = buyerRepository.findByPhoneNumber(buyerDto.getPhoneNumber()).isEmpty();
		if(isEmailNotAvailable) {
			if(isPhoneNumberNotAvailable) {
				Buyer buyer = new Buyer();
				int max = Integer.MIN_VALUE;
				if(buyerRepository.findAll().isEmpty())
				{
					max = Integer.parseInt(id.substring(1));
				}
				else {
					List<Buyer> buyers = buyerRepository.findAll();
					for(Buyer b: buyers) {
						if(Integer.parseInt(b.getBuyerId().substring(1)) > max)
							max = Integer.parseInt(b.getBuyerId().substring(1));
					}
				}
				buyer.setBuyerId("B" + (max + 1));
				buyer.setEmail(buyerDto.getEmail());
				buyer.setIsActive(buyerDto.getIsActive());
				buyer.setIsPriviledged(buyerDto.getIsPriviledged());
				buyer.setName(buyerDto.getName());
				buyer.setPassword(buyerDto.getPassword());
				buyer.setPhoneNumber(buyerDto.getPhoneNumber());
				buyer.setRewardPoints(buyerDto.getRewardPoints());
				registeredWithEmailID = buyer.getEmail();
				buyerRepository.save(buyer);
			}
			else throw new UserMSException("Phone Number already in use");
		}
		else throw new UserMSException("Email ID already in use");
		
		return registeredWithEmailID;
	}
	
}
