package com.ecommerce.project.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	private String productName;
	private String image;
	private String description;
	private Integer quantity;
	private double price; //Mrp = 100
	private double discount; // 25rs
	private double specialPrice; // 75rs   Splprice = Mrp-(Discount/100)*100
	
	@ManyToOne
	@JoinColumn(name ="category_id")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "seller_id")	
	private User user;
	
}
