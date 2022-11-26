package com.jensen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jensen.entity.Product;

public class ProductDaoImp implements ProductDao {
	
	private Connection conn;

	public ProductDaoImp(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addProduct(Product product) {
		boolean f = false;
		
		
		try {
			String sql = "INSERT INTO product(name, price, description, image) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, product.getName());
			ps.setString(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getImage());
			
			int row = ps.executeUpdate();
			
			if(row > 0) {
				f = true;
			}else {
				f = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		
		Product product = null;
		
		try {
			
			String sql = "SELECT * FROM product";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setImage(rs.getString(5));
				
				list.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Product getProductById(int id) {
		Product product = null;
		
		try {
			
			String sql = "SELECT * FROM product WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getString(3));
				product.setDescription(rs.getString(4));
				product.setImage(rs.getString(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}

	public boolean updateProduct(Product product) {
		boolean f = false;
		
		try {
			
			String sql = "UPDATE product SET name=?, price=?, description=?, image=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getPrice());
			ps.setString(3, product.getDescription());
			ps.setString(4, product.getImage());
			ps.setInt(5, product.getId());
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public boolean deleteProduct(int id) {
		boolean f = false;
		
		try {
			
			String sql = "DELETE FROM product WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	

}
