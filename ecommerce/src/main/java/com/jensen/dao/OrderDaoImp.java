package com.jensen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jensen.entity.Order;

public class OrderDaoImp implements OrderDao {
	
	private Connection conn;

	public OrderDaoImp(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean saveOrder(List<Order> list) {
		boolean f = false;
		
		try {
			String sql = "INSERT INTO orders(order_id, user_name, email, address, phone, product_name, price)"
					+ "VALUES(?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			
			for(Order order : list ) {
				ps.setString(1, order.getOrderId());
				ps.setString(2, order.getUserName());
				ps.setString(3, order.getEmail());
				ps.setString(4, order.getFulladd());
				ps.setString(5, order.getPhnoe());
				ps.setString(6, order.getProductname());
				ps.setString(7, order.getPrice());
				
				//
				ps.addBatch();
			}
			
			int[] count = ps.executeBatch();
			conn.commit();
			f = true;
			conn.setAutoCommit(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public List<Order> getAllOrder() {
		
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		
		try {
			
			String sql = "SELECT * FROM orders";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				order = new Order();
				order.setId(rs.getInt(1));
				order.setOrderId(rs.getString(2));
				order.setUserName(rs.getString(3));
				order.setEmail(rs.getString(4));
				order.setFulladd(rs.getString(5));
				order.setPhnoe(rs.getString(6));
				order.setProductname(rs.getString(7));
				order.setPrice(rs.getString(8));
				
				list.add(order);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

}
