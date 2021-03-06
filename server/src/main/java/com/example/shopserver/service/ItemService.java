package com.example.shopserver.service;

import com.example.shopserver.entities.Category;
import com.example.shopserver.entities.Item;
import com.example.shopserver.entities.Order;
import com.example.shopserver.payload.request.AddItemRequest;
import com.example.shopserver.payload.request.EditItemRequest;
import com.example.shopserver.repos.CategoryRepository;
import com.example.shopserver.repos.ItemRepository;
import com.example.shopserver.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void addItem(AddItemRequest request) throws IOException {
        byte[] picture = request.getPicture().getBytes();
        Optional<Category> category = categoryRepository.findById(request.getCategoryId());
        repository.save(new Item(request.getTitle(), request.getDescription(), request.getPrice(), picture, request.getPhoneNumber(), userRepository.getById(request.getOwnerId()), category.orElseThrow()));
    }

    public Item getItemById(Long id){
        Optional<Item> item = repository.findById(id);
        return item.orElse(null);
    }

    public List<Item> getAll(){
        return repository.findAll();
    }

    public void editItem(EditItemRequest request, Long itemId) throws IOException {
        Item item = getItemById(itemId);
        item.setName(request.getTitle());
        item.setPrice(request.getPrice());
        item.setDescription(request.getDescription());
        item.setNumber(request.getNumber());
        if (request.getPicture() != null){
            item.setPicture(request.getPicture().getBytes());
        }
        repository.save(item);
    }

    public void deleteItemById(Long id){
        repository.deleteById(id);
    }

    public void purchaseItem(Order order){
        orderService.purchaseItem(order);
    }
}
