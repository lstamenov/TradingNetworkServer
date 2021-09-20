package com.example.shopserver.repos;

import com.example.shopserver.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Transactional
    Category findByName(String name);

    @Transactional
    @Override
    List<Category> findAllById(Iterable<Long> iterable);
}
