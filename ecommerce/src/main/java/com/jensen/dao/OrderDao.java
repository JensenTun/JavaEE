package com.jensen.dao;

import java.util.List;

import com.jensen.entity.Order;
import com.jensen.entity.Product;

public interface OrderDao {

	public boolean saveOrder(List<Order> list);
	
	public List<Order> getAllOrder();
}
