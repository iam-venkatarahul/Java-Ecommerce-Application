package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.payload.CartDTO;
import com.ecommerce.project.payload.CartItemDTO;

public interface CartService {

    String createOrUpdateCartWithItems(List<CartItemDTO> cartItems);

    CartDTO addProductToCart(Long productId, Integer quantity);

    List<CartDTO> getAllCarts();
    
}
