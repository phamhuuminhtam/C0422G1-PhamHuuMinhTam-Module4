package com.codegym.service.impl;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
