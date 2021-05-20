package com.infosys.user.entity;

import java.io.Serializable;

public class CompositeKeyWishlist implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public String buyerId;
	public Integer prodId;
	
	public CompositeKeyWishlist() {
	}
	public CompositeKeyWishlist(String buyerId, Integer prodId) {
		this.buyerId = buyerId;
		this.prodId = prodId;
	}
}
