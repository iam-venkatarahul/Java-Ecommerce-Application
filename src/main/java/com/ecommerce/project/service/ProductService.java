package com.ecommerce.project.service;

//import java.io.IOException;

//import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;

public interface ProductService {

	ProductDTO addProduct(Long categoryId , Product product);

	ProductResponse getAllProducts();

	ProductResponse getProductsByCategory(Long categoryId);

	ProductResponse getProductsByKeyword(String keyword);

	ProductDTO updateProduct(Long productId, Product product);

	ProductDTO deleteProduct(Long productId);

	//ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
