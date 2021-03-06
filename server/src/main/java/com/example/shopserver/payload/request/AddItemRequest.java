package com.example.shopserver.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class AddItemRequest {
    private String title;
    private String description;
    private double price;
    private String phoneNumber;
    private MultipartFile picture;
    private Long ownerId;
    private Long categoryId;

    public AddItemRequest(String title, String description, double price, String phoneNumber, MultipartFile picture, Long ownerId, Long categoryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.picture = picture;
        this.ownerId = ownerId;
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
