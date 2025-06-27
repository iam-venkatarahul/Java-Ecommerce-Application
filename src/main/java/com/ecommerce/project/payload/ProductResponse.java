package com.ecommerce.project.payload;

import java.util.List;
import lombok.*;

public class ProductResponse {
	
	@Getter
	@Setter
	List<ProductDTO> content;

}
