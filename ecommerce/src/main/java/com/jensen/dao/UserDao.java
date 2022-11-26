package com.jensen.dao;

import com.jensen.entity.User;

public interface UserDao {
	
	public boolean register(User user);
	
	public User login(String email, String password);

}
