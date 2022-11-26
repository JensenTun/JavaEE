package com.jensen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jensen.entity.Cart;

public class CartDAOImp implements CartDao {

	private Connection conn;
	
	public CartDAOImp(Connection con) {
		this.conn = con;
	}

	public boolean add(Cart c) {
		boolean f = false;
		
		try {
			String sql = "INSERT INTO cart(pid, uid, title, price, totalPrice)VALUES(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getCid());
			ps.setInt(2, c.getUserId());
			ps.setString(3, c.getProductName());
			ps.setDouble(4, c.getPrice());
			ps.setDouble(5, c.getTotalPrice());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public List<Cart> getProductByUser(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		
		Cart c = null;
		double totalPrice = 0;
		
		try {
			
			String sql = "SELECT * FROM cart WHERE uid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Cart(); 
				c.setCid(rs.getInt(1));
				c.setPid(rs.getInt(2));
				c.setUserId(rs.getInt(3));
				c.setProductName(rs.getString(4));
				c.setPrice(rs.getDouble(5));
				
				totalPrice = totalPrice + rs.getDouble(6);
				c.setTotalPrice(totalPrice);
				
				
				list.add(c);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public boolean deleteProduct(int pid, int uid, int cid) {
		boolean f = false;
		
		try {
			
			String sql = "DELETE FROM cart WHERE pid=? AND uid=? AND cid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
