package com.example.shopserver.controllers;

import com.example.shopserver.entities.User;
import com.example.shopserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("view/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        User userByUsername = service.getUserByUsername(username);
        return ResponseEntity.ok(userByUsername);
    }

    @PostMapping("change/profile-picture")
    public ResponseEntity<?> changeProfilePicture(@RequestParam MultipartFile picture, @RequestParam Long userId){
        try {
            service.changeProfilePicture(picture, userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
