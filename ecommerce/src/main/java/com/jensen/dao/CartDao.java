package com.jensen.dao;

import java.util.List;

import com.jensen.entity.Cart;

public interface CartDao {

	public boolean add(Cart cart);
	
	/// for order
	public List<Cart> getProductByUser(int userId);
	
	
	// removelFor Book
	public boolean deleteProduct(int pid, int uid, int cid);
}
