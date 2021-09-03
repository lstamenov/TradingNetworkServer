package com.example.shopserver.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private double price;
    @Lob()
    private byte[] picture;
    @Column
    private String number;
    @Column(name = "date_posted")
    private Date datePosted;
    @Column
    private String email;
    @Column
    private String password;

    public Item(){}

    public Item(String name, String description, double price, byte[] picture, String number, String email, String password){
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.number = number;
        this.datePosted = new Date();
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
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
}
