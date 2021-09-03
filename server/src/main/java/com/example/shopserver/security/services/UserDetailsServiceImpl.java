package com.example.shopserver.security.services;

import com.example.shopserver.entities.User;
import com.example.shopserver.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByUsername(s)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return UserDetailsImpl.build(user);
    }
}
