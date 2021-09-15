package com.example.shopserver.controllers;

import com.example.shopserver.entities.Item;
import com.example.shopserver.entities.Order;
import com.example.shopserver.payload.request.AddItemRequest;
import com.example.shopserver.payload.request.EditItemRequest;
import com.example.shopserver.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/items")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping("/add")
    public ResponseEntity<?> addItem(@RequestParam("title") String title,
                                     @RequestParam("description")String description,
                                     @RequestParam("price") double price,
                                     @RequestParam("phoneNumber") String phoneNumber,
                                     @RequestParam("picture") MultipartFile picture,
                                     @RequestParam("ownerId") Long ownerId,
                                     @RequestParam("categoryName") String categoryName) throws IOException {
        AddItemRequest request = new AddItemRequest(title, description, price, phoneNumber, picture, ownerId, categoryName);
        service.addItem(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/order")
    public ResponseEntity<?> makeOrder(@RequestBody Order order){
        service.purchaseItem(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/edit/{itemId}")
    public ResponseEntity<?> editItem(@PathVariable Long itemId, @ModelAttribute EditItemRequest request){
        try {
            service.editItem(request, itemId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/edit/delete/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long itemId){
        service.deleteItemById(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("view/{id}")
    public Item getItemById(@PathVariable("id") Long id){
        return service.getItemById(id);
    }

    @GetMapping("view/all")
    public List<Item> getAllItems(){
        return this.service.getAll();
    }
}
