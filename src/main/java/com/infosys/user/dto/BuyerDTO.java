package com.infosys.user.dto;

import javax.validation.constraints.Pattern;

import com.sun.istack.NotNull;

public class BuyerDTO {

	
	private String buyerId;
	@NotNull
	@Pattern(regexp = "[A-z]{1,}[ ][A-z ]{1,}", message = "Please provide correct name")
	private String name;
	@NotNull
	@Pattern(regexp = "[A-z0-9]{1,}[@][A-z]{1,}(.com)", message = "Please provide correct email id") //wrong
	private String email;
	@NotNull
	@Pattern(regexp = "[987][0-9]{9}", message = "Enter a 10 digit mobile number")
	private String phoneNumber;
	@NotNull
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{7,20}", message = "Please provide a password of minimum 7 characters and maximum of 20 characters. Your password can contain at least one uppercase, at least one lowercase, at least one digit and also one special character amongst - !@#&%^$*")
	private String password;
	@Pattern(regexp = "(true|false)", message = "isPrivileged can be true or false")
	private String isPriviledged;
	private String rewardPoints;
	@Pattern(regexp = "(true|false)", message = "isActive can be true or false")
	private String isActive;
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsPriviledged() {
		return isPriviledged;
	}
	public void setIsPriviledged(String isPriviledged) {
		this.isPriviledged = isPriviledged;
	}
	public String getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(String rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "BuyerDTO [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", isPriviledged=" + isPriviledged + ", rewardPoints=" + rewardPoints
				+ ", isActive=" + isActive + "]";
	}
	
	
}
