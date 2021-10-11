package com.example.shopserver.payload.request;

import java.time.LocalDate;

public class AddReviewRequest {
    private Long ratingUserId;
    private int starsRated;
    private String comment;
    private Long ratedUserId;
    private LocalDate datePosted;

    public AddReviewRequest(Long ratingUserId, int starsRated, String comment, Long ratedUserId) {
        this.ratingUserId = ratingUserId;
        this.starsRated = starsRated;
        this.comment = comment;
        this.ratedUserId = ratedUserId;
        this.datePosted = LocalDate.now();
    }

    public Long getRatingUserId() {
        return ratingUserId;
    }

    public void setRatingUserId(Long ratingUserId) {
        this.ratingUserId = ratingUserId;
    }

    public int getStarsRated() {
        return starsRated;
    }

    public void setStarsRated(int starsRated) {
        this.starsRated = starsRated;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getRatedUserId() {
        return ratedUserId;
    }

    public void setRatedUserId(Long ratedUserId) {
        this.ratedUserId = ratedUserId;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }
}
