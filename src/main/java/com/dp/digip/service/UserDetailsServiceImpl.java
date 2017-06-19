package com.dp.digip.service;


import com.dp.digip.models.User;
import com.dp.digip.models.Role;
import com.dp.digip.service.UserStoreService;
import com.dp.digip.components.AuthenticationFacade;

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
import org.springframework.security.core.Authentication;




import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import static java.lang.System.out;




@Service
public class UserDetailsServiceImpl implements UserDetailsService//,UserDetails
{

    @Autowired 
    private AuthenticationFacade authenticationFacade;

    @Autowired
    private UserDAO userDao;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        out.println("into userdetails.");	

	
        User user = userDao.findByUsername(username);
	if (user == null)	
		throw new UsernameNotFoundException("User '" +username + "' could not be found.");


	//Authentication auth = authenticationFacade.getAuthentication();
	//if ( auth != null ) 
	//	out.println(auth.getName() );i

	//grant authorities
	String role = user.getRole().getRole();
	
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
	 
        //for (String role : roles) {
        //        //    authorities.add(new SimpleGrantedAuthority(role));
        //                //}
        //


     
	out.println("the role of user "+user.getUsername()+" is "+user.getRole().getRole());	

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities );

    }
/*
Here we can implement UserDetails interface 

	Collection<? extends GrantedAuthority> 	getAuthorities()
	String 	getPassword()
	String 	getUsername()
	boolean isAccountNonExpired()
	boolean isAccountNonLocked()
	boolean isCredentialsNonExpired()
	boolean isEnabled()

	
    public List<GrantedAuthority> getAuthorities (){
	Authentication auth = authenticationFacade.getAuthentication();
    }
*/

    private static List<GrantedAuthority> getAuthorities (String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
	authorities.add(new SimpleGrantedAuthority(role));        

	//for (String role : roles) {
        //    authorities.add(new SimpleGrantedAuthority(role));
        //}
        return authorities;
    }



}

