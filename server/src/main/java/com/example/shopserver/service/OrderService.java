package com.example.shopserver.service;

import com.example.shopserver.emailsender.EmailServiceImpl;
import com.example.shopserver.entities.Item;
import com.example.shopserver.entities.Order;
import com.example.shopserver.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private EmailServiceImpl emailService;

    public void purchaseItem(Order order){
        Item item = itemRepository.getById(order.getItemId());
        String subject = String.format("%s %s - Order", order.getCustomerFirstName(),
                order.getCustomerLastName());
        String text = String.format("Hello %s%n%n" +
                "Your order is successful. Thank you for shopping from our Trading Network, we hope you like your new %s!%n%n" +
                "Kind regards,%n" +
                "The team", order.getCustomerFirstName(), item.getName());
        emailService.sendSimpleMessage(order.getCustomerEmail(), subject, text);
        itemRepository.deleteById(order.getItemId());
    }
}
