/*
 * CartDTO.java
 * DTO is a design pattern used to transfer data between software application subsystems.
 * It is often used to encapsulate data and send it from one subsystem of an application to
 * This class represents a Data Transfer Object (DTO) for the Cart entity.
 * It is used to transfer cart data between the server and client.
 */

package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private Long cartId;
    private Double totalPrice = 0.0;
    private List<ProductDTO> products = new ArrayList<>();
}