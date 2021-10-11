package com.example.shopserver.service;

import com.example.shopserver.entities.User;
import com.example.shopserver.entities.UserReview;
import com.example.shopserver.payload.request.AddReviewRequest;
import com.example.shopserver.repos.UserRepository;
import com.example.shopserver.repos.UserReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UserReviewRepository reviewRepository;

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

    public void addUserReview(AddReviewRequest request){
        User ratedUser = repository.getUserById(request.getRatedUserId());
        User ratingUser = repository.getUserById(request.getRatingUserId());

        UserReview review = new UserReview(ratingUser, request.getStarsRated(), request.getDatePosted(), request.getComment(), ratedUser);
        reviewRepository.save(review);
        ratedUser.getReviewsReceived().add(review);
        ratingUser.getReviewsPosted().add(review);
        repository.save(ratingUser);
        repository.save(ratedUser);
    }

    public List<User> usersByIds(Long[] ids){
        List<User> users = new ArrayList<>();
        Arrays.stream(ids).forEach(id -> users.add(repository.getUserById(id)));
        return users;
    }
}
