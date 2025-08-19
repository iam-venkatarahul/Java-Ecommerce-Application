package com.ecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.project.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find a cart by user ID or to delete a cart by user ID
    // Optional<Cart> findByUserId(Long userId);
    // void deleteByUserId(Long userId);
}
