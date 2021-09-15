package com.example.shopserver.service;

import com.example.shopserver.entities.User;
import com.example.shopserver.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserByUsername(String username){
        Optional<User> byUsername = repository.findByUsername(username);
        return byUsername.orElse(null);
    }

    public User getUserById(Long id){
        return repository.getUserById(id);
    }

    public void changeProfilePicture(MultipartFile picture, Long userId) throws IOException {
        User user = repository.getUserById(userId);
        user.setProfilePicture(picture.getBytes());
        repository.save(user);
    }
}
