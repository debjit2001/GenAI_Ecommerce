package com.example.ai.practice.repository;

import com.example.ai.practice.entity.CartItem;
import com.example.ai.practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByUsernameAndProductId(String username, Product product);

    List<CartItem> findAllByUsername(String username);
}

