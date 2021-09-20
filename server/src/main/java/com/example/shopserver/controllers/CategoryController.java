package com.example.shopserver.controllers;

import com.example.shopserver.entities.Category;
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

    @GetMapping("view/category/{name}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String name){
        Category category = service.getCategoryByName(name);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("view/{id}")
    public Category getCategoryById(@PathVariable Long id){
        Category category = service.getCategoryById(id);
        return category;
    }

    @PostMapping("add")
    public ResponseEntity<?> createCategory(@RequestParam String name){
        this.service.addCategory(name);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
