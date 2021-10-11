package com.example.shopserver.controllers;

import com.example.shopserver.repos.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/reviews/")
public class ReviewsController {
    @Autowired
    private UserReviewRepository reviewRepository;

    @GetMapping("view/{userId}")
    public ResponseEntity<?> getAllReviewsByPlayerRatedId(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(this.reviewRepository.getUserReviewByRatedUserId(userId), HttpStatus.OK);
    }
}
