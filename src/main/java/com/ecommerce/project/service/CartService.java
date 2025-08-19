/*
 * CartService.java
 * CartService is an interface that defines the operations for managing shopping carts in an e-commerce application.
 * It has methods to -
 *        1. Add a product to the cart
 *        2. Get all carts
 *        3. Get the cart of the logged-in user
 *        4. Update the quantity of a product in the cart
 *        5. Delete a product from the cart
 *        6. Create or update a cart with items (products)
 * 
 */
package com.ecommerce.project.service;

import com.ecommerce.project.payload.CartDTO;
import com.ecommerce.project.payload.CartItemDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface CartService {
    
    CartDTO addProductToCart(Long productId, Integer quantity);

    List<CartDTO> getAllCarts();

    CartDTO getCart(String emailId, Long cartId);

    @Transactional
    CartDTO updateProductQuantityInCart(Long productId, Integer quantity);

    String deleteProductFromCart(Long cartId, Long productId);

    void updateProductInCarts(Long cartId, Long productId);

    String createOrUpdateCartWithItems(List<CartItemDTO> cartItems);
}
