package com.example.shopserver.repos;

import com.example.shopserver.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Transactional
    Optional<Item> findById(Long id);
    @Transactional
    List<Item> findAll();
    void deleteById(Long id);
    List<Item> getAllByOwnerUsername(String username);
}
