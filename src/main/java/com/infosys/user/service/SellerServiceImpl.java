package com.infosys.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infosys.user.dto.SellerDTO;
import com.infosys.user.entity.Seller;
import com.infosys.user.exception.UserMSException;
import com.infosys.user.repository.SellerRepository;

@Service("sellerService")
@Transactional
public class SellerServiceImpl implements SellerService {

	
	private static String id = "S1";
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public SellerDTO authenticateSeller(String emailId, String password) throws UserMSException {
		SellerDTO sellerDto = new SellerDTO();
		Seller seller = sellerRepository.findByEmail(emailId.toLowerCase());
		System.out.println(seller.getPassword());
		if(!password.equals(seller.getPassword()))
			throw new UserMSException("Invalid Credentials");
		sellerDto.setEmail(seller.getEmail());
		sellerDto.setSellerId(seller.getSellerId());
		sellerDto.setIsActive(seller.getIsActive());
		sellerDto.setName(seller.getName());
		sellerDto.setPassword(seller.getPassword());
		sellerDto.setPhoneNumber(seller.getPhoneNumber());
		return sellerDto;
	}
	
	//register as seller
	@Override
	public String regsiterNewSeller(SellerDTO sellerDto) throws UserMSException{
		String registeredWithEmailID = null;
		boolean isEmailNotAvailable = sellerRepository.findById(sellerDto.getEmail()).isEmpty();
		boolean isPhoneNumberNotAvailable = sellerRepository.findByPhoneNumber(sellerDto.getPhoneNumber()).isEmpty();
		if(isEmailNotAvailable) {
			if(isPhoneNumberNotAvailable) {
				Seller seller = new Seller();
				int max = Integer.MIN_VALUE;
				if(sellerRepository.findAll().isEmpty())
				{
					max = Integer.parseInt(id.substring(1));
				}
				else {
					List<Seller> sellers = sellerRepository.findAll();
					for(Seller b: sellers) {
						if(Integer.parseInt(b.getSellerId().substring(1)) > max)
							max = Integer.parseInt(b.getSellerId().substring(1));
					}
				}
				seller.setSellerId("S" + (max + 1));
				seller.setEmail(sellerDto.getEmail());
				seller.setIsActive(sellerDto.getIsActive());
				seller.setName(sellerDto.getName());
				seller.setPassword(sellerDto.getPassword());
				seller.setPhoneNumber(sellerDto.getPhoneNumber());
				registeredWithEmailID = seller.getEmail();
				sellerRepository.save(seller);
			}
			else throw new UserMSException("Phone Number already in use");
		}
		else throw new UserMSException("Email ID already in use");
		
		return registeredWithEmailID;
	}
	
}