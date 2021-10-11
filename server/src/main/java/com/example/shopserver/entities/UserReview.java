package com.example.shopserver.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User ratingUser;
    @Column(name = "stars_number")
    private int starsNumber;
    @Column(name = "date_posted")
    private LocalDate datePosted;
    @Column
    private String comment;
    @ManyToOne
    private User ratedUser;

    public UserReview(){}

    public UserReview(User ratingUser, int starsNumber, LocalDate datePosted, String comment, User ratedUser) {
        this.ratingUser = ratingUser;
        this.starsNumber = starsNumber;
        this.datePosted = datePosted;
        this.comment = comment;
        this.ratedUser = ratedUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getRatingUser() {
        return ratingUser;
    }

    public void setRatingUser(User ratingUser) {
        this.ratingUser = ratingUser;
    }

    public int getStarsNumber() {
        return starsNumber;
    }

    public void setStarsNumber(int starsNumber) {
        this.starsNumber = starsNumber;
    }

    public LocalDate getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getRatedUser() {
        return ratedUser;
    }

    public void setRatedUser(User ratedUser) {
        this.ratedUser = ratedUser;
    }
}
