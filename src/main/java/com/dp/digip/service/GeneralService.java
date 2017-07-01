package com.dp.digip.service;


import com.dp.digip.models.Parent;
import com.dp.digip.models.User;
import com.dp.digip.models.DAO.UserDAO;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import static java.lang.System.out;


@Service
public class GeneralService{

	@Autowired
	UserDAO userDao;

	public Parent parentFromUsername(String username){

		out.println("\n\n\n inside parentFromUsername");

		User user = userDao.findByUsername(username);

		Parent parent = user.getParent();

		if ( parent == null)
			out.println("wtf");			
	
		
	
		return parent;
	}











}
