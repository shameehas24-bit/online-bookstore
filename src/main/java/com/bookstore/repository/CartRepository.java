package com.bookstore.repository;

import com.bookstore.entity.CartItem;
import com.bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
