package com.ecommerce.project.service;

//import java.io.IOException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.project.model.Product;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.model.*;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import com.ecommerce.project.repository.*;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private CategoryRepository categoryrepo;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@Override ///Add Product By Category ID
	public ProductDTO addProduct(Long categoryId, Product product) {
		Category category = categoryrepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category" , "categoryId" , "categoryId"));
		product.setImage("deafualt.png");
		product.setCategory(category);
		double specialPrice = product.getPrice() - (product.getDiscount() * 0.01) * product.getPrice();
		// SpecialPrice = Mrp - discount
		product.setSpecialPrice(specialPrice);
		Product savedproduct = productrepo.save(product);
		return modelmapper.map(savedproduct , ProductDTO.class);
	}

	
	@Override
	public ProductResponse getAllProducts() {
		List<Product> products = productrepo.findAll();
		List<ProductDTO> productdtos = products.stream()
				.map(product -> modelmapper.map(product, ProductDTO.class))
				.toList();
		ProductResponse productresponse = new ProductResponse();
		productresponse.setContent(productdtos);
		return productresponse;
	}

	@Override
	public ProductResponse getProductsByCategory(Long categoryId) {
		Category category = categoryrepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category" , "categoryId" , "categoryId"));
		List<Product> products = productrepo.findByCategoryOrderByPriceAsc(category);
		List<ProductDTO> productdtos = products.stream()
				.map(product -> modelmapper.map(product, ProductDTO.class))
				.toList();
		ProductResponse productresponse = new ProductResponse();
		productresponse.setContent(productdtos);
		return productresponse;
	}

	@Override
	public ProductResponse getProductsByKeyword(String keyword) {
		List<Product> products = productrepo.findByProductNameLikeIgnoreCase('%' + keyword + '%');
		List<ProductDTO> productdtos = products.stream()
				.map(product -> modelmapper.map(product, ProductDTO.class))
				.toList();
		ProductResponse productresponse = new ProductResponse();
		productresponse.setContent(productdtos);
		return productresponse;
	}

	 @Override
	    public ProductDTO updateProduct(Long productId, Product product) {
	        Product productFromDb = productrepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

//	        Product product = modelMapper.map(productDTO, Product.class);
//
//	        productFromDb.setProductName(product.getProductName());
//	        productFromDb.setDescription(product.getDescription());
//	        productFromDb.setQuantity(product.getQuantity());
//	        productFromDb.setDiscount(product.getDiscount());
//	        productFromDb.setPrice(product.getPrice());
//	        productFromDb.setSpecialPrice(product.getSpecialPrice());

	        Product savedProduct = productrepo.save(productFromDb);
	        return modelmapper.map(savedProduct, ProductDTO.class);
	    }
	
	 @Override
	    public ProductDTO deleteProduct(Long productId) {
	        Product product = productrepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
	        productrepo.delete(product);
	        return modelmapper.map(product, ProductDTO.class);
	    }
	
//	 @Override
//	 public ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException {
//	        Product productFromDb = productrepo.findById(productId)
//	                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));
//
//	        String fileName = fileService.uploadImage(path, image);
//	        productFromDb.setImage(fileName);
//
//	        Product updatedProduct = productrepo.save(productFromDb);
//	        return modelmapper.map(updatedProduct, ProductDTO.class);
//	    }
	
	
	
	
	

}
