package com.basics.springboot.basics.service;

import com.basics.springboot.basics.entity.User;

import java.util.List;

public interface UserService {
        User getUserByEmail(String email);
        List<User> getUsersByName(String name);
        void save(List<User> users);
}
