package com.example.shopserver.entities;

public class Order {
    private String customerEmail;
    private String customerFirstName;
    private String customerLastName;
    private String address;
    private Long itemId;

    public Order(String customerEmail,
                 String customerFirstName,
                 String customerLastName,
                 String address,
                 Long itemId) {
        this.customerEmail = customerEmail;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.address = address;
        this.itemId = itemId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getItemId() {
        return this.itemId;
    }

}
