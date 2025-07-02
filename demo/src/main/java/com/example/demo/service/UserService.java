package com.example.demo.service;

import com.example.demo.pojo.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void registerUser(User user);
    boolean loginUser(String username, String password);
    boolean existsByUsername(String username);
}
