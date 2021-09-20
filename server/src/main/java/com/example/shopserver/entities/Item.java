package com.example.shopserver.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name = "items")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id"
//)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    @Column(length = 1000)
    private String description;
    @Column
    private double price;
    @Lob()
    private byte[] picture;

    @Column
    private String number;

    @Column(name = "date_posted")
    private Date datePosted;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "owner_id")
    @NotNull
    private User owner;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

//    @OneToOne(mappedBy = "item")
//    Order order;


    public Item(){}

    public Item(String name, String description, double price, byte[] picture, String number, User owner, Category category){
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.number = number;
        this.datePosted = new Date();
        this.owner = owner;
        this.category = category;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
