package com.dp.digip.service;


import com.dp.digip.models.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
