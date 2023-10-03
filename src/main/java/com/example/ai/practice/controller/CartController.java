package com.example.ai.practice.controller;

import com.example.ai.practice.entity.CartItem;
import com.example.ai.practice.entity.Product;
import com.example.ai.practice.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public void addToCart(@RequestParam String username, @RequestParam Product product, @RequestParam Integer quantity) {
        cartService.addToCart(username, product, quantity);
    }

    @GetMapping("/items")
    public List<CartItem> getCartItemsForUser(@RequestParam String username) {
        return cartService.getCartItemsForUser(username);
    }

    @DeleteMapping("/items/{cartItemId}")
    public void removeCartItem(@PathVariable Long cartItemId) {
        cartService.removeCartItem(cartItemId);
    }
}

