package com.basics.springboot.basics.service;

import com.basics.springboot.basics.entity.User;
import com.basics.springboot.basics.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService{
    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String MESSAGE_USER_NOT_FOUND = "Error looking for email user";

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByUserEmail(email).orElseThrow(() -> new RuntimeException(MESSAGE_USER_NOT_FOUND));
    }

    @Override
    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    @Transactional
    public void save(List<User> users) {
        users.stream()
                .peek(user -> logger.info("Insert: " + user))
                .forEach(user -> userRepository.save(user));
    }
}
