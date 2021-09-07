package com.example.shopserver.service;

import com.example.shopserver.entities.Item;
import com.example.shopserver.entities.Order;
import com.example.shopserver.entities.User;
import com.example.shopserver.payload.request.AddItemRequest;
import com.example.shopserver.repos.ItemRepository;
import com.example.shopserver.repos.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

    public void addItem(AddItemRequest request) throws IOException {
        byte[] picture = request.getPicture().getBytes();
        repository.save(new Item(request.getTitle(), request.getDescription(), request.getPrice(), picture, request.getPhoneNumber(), userRepository.getById(request.getOwnerId())));
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
