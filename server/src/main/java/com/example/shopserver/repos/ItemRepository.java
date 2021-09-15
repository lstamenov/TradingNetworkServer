package com.example.shopserver.repos;

import com.example.shopserver.entities.Item;
import com.example.shopserver.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findById(Long id);
    List<Item> findAll();
    void deleteById(Long id);
    List<Item> getAllByOwnerUsername(String username);
}
