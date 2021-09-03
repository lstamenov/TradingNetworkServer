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
        Item item = order.getItem();
        String subject = String.format("%s %s - Order", order.getCustomer().getFirstName(),
                order.getCustomer().getLastName());
        String text = String.format("Hello %s%n%n" +
                "Your order is successful. Thank you for shopping from our Trading Network, we hope you like your new %s!%n%n" +
                "Kind regards,%n" +
                "The team", order.getCustomer().getFirstName(), item.getName());
        emailService.sendSimpleMessage(order.getCustomer().getEmail(), subject, text);
        itemRepository.deleteById(order.getItem().getId());
    }
}
