package com.dp.digip.service;

import com.dp.digip.models.User;
import com.dp.digip.models.Role;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.service.interfaces.StoreService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;





@Service 
public class UserStoreService implements StoreService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDAO userDao;

    public void save(User newUser) { 
        User user = new User(newUser.getEmail(),newUser.getUsername(),bCryptPasswordEncoder.encode(newUser.getPassword()),new Role(newUser.getRole_temp()) );        
        userDao.save(user);
    }


}







