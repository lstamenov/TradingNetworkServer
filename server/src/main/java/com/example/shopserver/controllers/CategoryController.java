package com.example.shopserver.controllers;

import com.example.shopserver.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/categories/")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("view/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(service.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> createCategory(@RequestParam String name){
        this.service.addCategory(name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
