package com.dp.digip.service;


import com.dp.digip.models.User;
import com.dp.digip.models.Role;

import com.dp.digip.models.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;



@Service
public class UserDetailsServiceImpl implements UserDetailsService,UserService{
    @Autowired
    private UserDAO userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        out.println("into userdetails.");	

        User user = userDao.findByUsername(username);
	
	       
	out.println(user.getRole().getRole());	

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), getAuthorities(user.getRole().getRole()));

    }
    private static List<GrantedAuthority> getAuthorities (String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
	authorities.add(new SimpleGrantedAuthority(role));        

	//for (String role : roles) {
        //    authorities.add(new SimpleGrantedAuthority(role));
        //}
        return authorities;
    }

    @Override
    public void save(User newUser) { 
        User user = new User(newUser.getEmail(),newUser.getUsername(),bCryptPasswordEncoder.encode(newUser.getPassword()),new Role(newUser.getRole_temp()) );        
        out.println("and here");
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}

