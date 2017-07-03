package com.dp.digip.service;

import com.dp.digip.models.DTO.UserObject;
import com.dp.digip.models.DTO.ParentObject;
import com.dp.digip.models.User;
import com.dp.digip.models.Role;
import com.dp.digip.models.Parent;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.service.interfaces.UserService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.System.out;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDAO userDao;

    public void saveUser(UserObject newUser,ParentObject newParent) { 

	  Parent parent = new Parent(newParent);
	  User user = new User(newUser.getEmail(),newUser.getUsername(),bCryptPasswordEncoder.encode(newUser.getPassword()) ,new Role(newUser.getRole()), parent, newUser.getImage()); 
      
	  out.println(user.getEmail());
      out.println("BLABLABLA");
	  userDao.save(user);
//        User user = new User(newUser.getEmai13l(),newUser.getUsername(),bCryptPasswordEncoder.encode(newUser.getPassword()),new Role(newUser.getRole_temp()) );        
//        userDao.save(user);
    }



} 
