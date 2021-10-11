package com.example.shopserver.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users",
uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = User.class
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String username;

    @Column(name = "profile_picture")

    @Lob()
    private byte[] profilePicture;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    private String email;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private Set<Item> itemsPosted;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Order> orders;

    @NotNull
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "ratingUser", fetch = FetchType.EAGER)
    private Set<UserReview> reviewsPosted;

    @OneToMany(mappedBy = "ratedUser", fetch = FetchType.EAGER)
    private Set<UserReview> reviewsReceived;

    public User(){}

    public User(String username,String firstName, String lastName, String email, String password, byte[] profilePicture) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.itemsPosted = new HashSet<>();
        this.orders = new HashSet<>();
        this.profilePicture = profilePicture;
        this.reviewsReceived = new LinkedHashSet<>();
        this.reviewsPosted = new LinkedHashSet<>();
    }

    public Set<UserReview> getReviewsPosted() {
        return reviewsPosted;
    }

    public void setReviewsPosted(Set<UserReview> reviewsPosted) {
        this.reviewsPosted = reviewsPosted;
    }

    public Set<UserReview> getReviewsReceived() {
        return reviewsReceived;
    }

    public void setReviewsReceived(Set<UserReview> reviewsReceived) {
        this.reviewsReceived = reviewsReceived;
    }

    public Set<Item> getItemsPosted() {
        return itemsPosted;
    }

    public void setItemsPosted(Set<Item> itemsPosted) {
        this.itemsPosted = itemsPosted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}
