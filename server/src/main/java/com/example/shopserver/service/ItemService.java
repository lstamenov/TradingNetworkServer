package com.example.shopserver.service;

import com.example.shopserver.entities.Item;
import com.example.shopserver.entities.Order;
import com.example.shopserver.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private OrderService orderService;

    public void addItem(String title, String desc, double price, MultipartFile pic, String number, String email, String password) throws IOException {
        byte[] picture = pic.getBytes();
        repository.save(new Item(title, desc, price, picture, number, email, password));
    }

    public Item getItemById(Long id){
        Optional<Item> item = repository.findById(id);
        return item.orElse(null);
    }

    public List<Item> getAll(){
        return repository.findAll();
    }

    public void purchaseItem(Order order){
        orderService.purchaseItem(order);
    }
}
