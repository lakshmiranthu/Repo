package com.infosys.user.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "buyer")
public class Buyer {
	
	@Id
	private String buyerId;
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String password;
	private String isPriviledged;
	private String rewardPoints;
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
		return "Buyer [buyerId=" + buyerId + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + ", isPriviledged=" + isPriviledged + ", rewardPoints=" + rewardPoints
				+ ", isActive=" + isActive + "]";
	}
	
}
