package com.example.shopserver.controllers;

import com.example.shopserver.entities.Item;
import com.example.shopserver.entities.Order;
import com.example.shopserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/no-auth")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestParam("itemName") String itemName,@RequestParam("itemDesc")
            String itemDesc,@RequestParam("itemPrice") double itemPrice, @RequestParam("picture") MultipartFile picture,
            @RequestParam("itemNumber") String itemNumber, @RequestParam("email") String email, @RequestParam("password") String password) throws IOException {
        service.addItem(itemName, itemDesc, itemPrice, picture, itemNumber, email, password);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/order")
    public ResponseEntity<?> makeOrder(@RequestParam("customerEmail") String customerEmail,
                                       @RequestParam("customerFirstName") String customerFirstName,
                                       @RequestParam("customerLastName") String customerLastName,
                                       @RequestParam("address") String address,
                                       @RequestParam("itemId") Long itemId){
        service.purchaseItem(new Order(customerEmail, customerFirstName, customerLastName, address, itemId));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable("id") Long id){
        return service.getItemById(id);
    }

    @GetMapping("/all-items")
    public List<Item> getAllItems(){
        return this.service.getAll();
    }
}
