package com.bookstore.service;

import com.bookstore.entity.User;
import com.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) { this.repo = repo; }

    public User getUserById(Long id) { return repo.findById(id).orElse(null); }
}
