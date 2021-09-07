package com.example.shopserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

//    @OneToOne(mappedBy = "item")
//    Order order;


    public Item(){}

    public Item(String name, String description, double price, byte[] picture, String number, User owner){
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.number = number;
        this.datePosted = new Date();
        this.owner = owner;
//        this.order = null;
    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
