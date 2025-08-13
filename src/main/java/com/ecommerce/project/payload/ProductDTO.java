package com.ecommerce.project.payload;

//import com.ecommerce.project.model.Category;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	
	private Long productId;
	private String productName;
	private String description;
	private String image;
	private Integer quantity;
	private double price;
	private double discount;
	private double specialPrice;
	

}
