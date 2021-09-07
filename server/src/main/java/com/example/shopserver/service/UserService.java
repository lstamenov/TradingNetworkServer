package com.example.shopserver.service;

import com.example.shopserver.entities.User;
import com.example.shopserver.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserByUsername(String username){
        Optional<User> byUsername = repository.findByUsername(username);
        return byUsername.orElse(null);
    }
}
