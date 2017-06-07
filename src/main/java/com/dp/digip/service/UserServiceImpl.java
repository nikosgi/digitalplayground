package com.dp.digip.service;

import com.dp.digip.models.User;
import com.dp.digip.models.DAO.UserDAO;
import com.dp.digip.models.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        out.println("did i arrive here ?");
	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        out.println("arrived here");
	user.setRole(new Role("admin"));
	out.println("and here");
	userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}

