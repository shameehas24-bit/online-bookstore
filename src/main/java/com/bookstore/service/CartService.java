package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.entity.CartItem;
import com.bookstore.entity.User;
import com.bookstore.repository.CartRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    private final CartRepository repo;

    public CartService(CartRepository repo) { this.repo = repo; }

    public void addToCart(Book book, User user) {
        CartItem item = new CartItem(null, book, user, 1);
        repo.save(item);
    }

    public List<CartItem> getCart(User user) { return repo.findByUser(user); }
    
    public void clearCart(User user) {
        List<CartItem> items = repo.findByUser(user);
        repo.deleteAll(items);
    }
}
