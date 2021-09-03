package com.example.shopserver.entities;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private User customer;

    private String address;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public Order(){}
    public Order(User customer,
                 String address,
                 Item item) {
        this.customer = customer;
        this.address = address;
        this.item = item;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
