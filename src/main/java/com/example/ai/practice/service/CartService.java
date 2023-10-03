package com.example.ai.practice.service;

import com.example.ai.practice.entity.CartItem;
import com.example.ai.practice.entity.Product;
import com.example.ai.practice.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartItemRepository cartItemRepository;

    public CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void addToCart(String username, Product product, Integer quantity) {
        // Get the user's cart.
        CartItem cartItem = cartItemRepository.findByUsernameAndProductId(username, product);

        // If the cart item does not exist, create a new one.
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
        } else {
            // Update the quantity of the existing cart item.
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        // Save the cart item.
        cartItemRepository.save(cartItem);
    }

    public List<CartItem> getCartItemsForUser(String username) {
        return cartItemRepository.findAllByUsername(username);
    }

    public void removeCartItem(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }
}

