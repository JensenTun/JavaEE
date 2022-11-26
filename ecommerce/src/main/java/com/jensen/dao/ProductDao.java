package com.jensen.dao;

import java.util.List;

import com.jensen.entity.Product;

public interface ProductDao {
	
	
	public boolean addProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductById(int id);
	
	public boolean updateProduct(Product product);
	
	public boolean deleteProduct(int id);

}
