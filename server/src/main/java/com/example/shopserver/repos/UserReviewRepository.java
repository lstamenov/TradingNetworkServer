package com.example.shopserver.repos;

import com.example.shopserver.entities.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserReviewRepository extends JpaRepository<UserReview, Long> {
    List<UserReview> getUserReviewByRatedUserId(Long id);
}