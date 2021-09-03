package com.example.shopserver.repos;

import com.example.shopserver.entities.Role;
import com.example.shopserver.entities.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
