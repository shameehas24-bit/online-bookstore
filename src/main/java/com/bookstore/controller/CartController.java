package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.entity.User;
import com.bookstore.service.BookService;
import com.bookstore.service.CartService;
import com.bookstore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    private final CartService cartService;
    private final BookService bookService;
    private final UserService userService;

    public CartController(CartService cartService, BookService bookService, UserService userService) {
        this.cartService = cartService;
        this.bookService = bookService;
        this.userService = userService;
    }

    @PostMapping("/cart/add/{id}")
    public String addToCart(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        User user = userService.getUserById(1L); // Using '1L' as the dummy logged-in user

        if (book != null && user != null) {
            cartService.addToCart(book, user);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        User user = userService.getUserById(1L);
        model.addAttribute("cartItems", cartService.getCart(user));
        return "cart";
    }
    
    @PostMapping("/checkout")
    public String checkout(Model model) {
        User user = userService.getUserById(1L);
        cartService.clearCart(user); // Empty the cart on checkout
        model.addAttribute("message", "Purchase Successful!");
        return "checkout_success";
    }
}
