package com.dp.digip.service;

import com.dp.digip.models.DAO.RoleDAO;
import com.dp.digip.models.Role;
import com.dp.digip.models.User;
import com.dp.digip.models.DAO.UserDAO;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.Iterable;
import java.util.HashSet;
import java.util.Set;
import static com.google.common.collect.Sets.*;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userRepository;
    @Autowired
    private RoleDAO roleRepository;
    //@Autowired
    //private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
	// we need to encrpyt the pass        
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
