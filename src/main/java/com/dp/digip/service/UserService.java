package com.dp.digip.service;

import com.dp.digip.models.User;

public interface UserService{

	public void save(User user); 

	public User findByUsername(String username);	

} 
