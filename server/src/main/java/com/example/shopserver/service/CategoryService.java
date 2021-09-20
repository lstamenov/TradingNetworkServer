package com.example.shopserver.service;

import com.example.shopserver.entities.Category;
import com.example.shopserver.repos.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public void addCategory(String name){
        Category category = new Category(name);
        repository.saveAndFlush(category);
    }

    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    public Category getCategoryByName(String name) {
        return repository.findByName(name);
    }

    public Category getCategoryById(Long id) {
        return repository.getById(id);
    }
}
