package com.example.shopserver.payload.request;

import org.springframework.web.multipart.MultipartFile;

public class EditItemRequest {
    private String title;
    private double price;
    private String description;
    private String number;
    private MultipartFile picture;

    public EditItemRequest(){}

    public EditItemRequest(String title, double price, String description, String number, MultipartFile picture) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.number = number;
        this.picture = picture;
    }

    public EditItemRequest(String title, double price, String description, String number) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.number = number;
        this.picture = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public MultipartFile getPicture() {
        return picture;
    }

    public void setPicture(MultipartFile picture) {
        this.picture = picture;
    }
}
