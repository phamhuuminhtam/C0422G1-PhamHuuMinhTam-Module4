package com.register.service;

import com.register.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    void adđ(User user);
    List<User> findAll() ;
}
