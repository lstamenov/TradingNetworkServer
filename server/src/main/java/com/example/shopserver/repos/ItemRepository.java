package com.example.shopserver.repos;

import com.example.shopserver.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById(Long id);
    void deleteById(Long id);
}
