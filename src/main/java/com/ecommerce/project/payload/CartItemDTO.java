/*
 * CartItemDTO.java
 * CartItemDTO is a Data Transfer Object (DTO) used to transfer cart item data
 * between the server and client in an e-commerce application.
 */

package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long productId;
    private Integer quantity;
}