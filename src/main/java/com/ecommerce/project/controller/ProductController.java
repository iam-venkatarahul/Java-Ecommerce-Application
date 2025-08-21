/*
 * Product Controller
 * 
 */



package com.ecommerce.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;
import com.ecommerce.project.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	//Adding Products to a Specific Category Id
	@PostMapping("/admin/categories/{categoryId}/product") 
	public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product , @PathVariable Long categoryId){
		
		ProductDTO savedproductdto = productservice.addProduct(categoryId , product);
		return new ResponseEntity<>(savedproductdto , HttpStatus.CREATED);
	}
	
	
	//Getting all products
	@GetMapping("/public/products")
	public ResponseEntity<ProductResponse>getAllProducts(){
		ProductResponse productresponse = productservice.getAllProducts();
		return new ResponseEntity<>(productresponse , HttpStatus.OK);
		}
	
	//Get Products by a CategoryId
	@GetMapping("/public/categories/{categoryId}/products")
	public ResponseEntity<ProductResponse> getProductsByCategory(@PathVariable Long  categoryId){
		ProductResponse productresponse = productservice.getProductsByCategory(categoryId);
		return new ResponseEntity<>(productresponse , HttpStatus.OK);
	}
	
	//Get products by keyword
	@GetMapping("/public/products/keyword/{Keyword}")
	public ResponseEntity<ProductResponse> getProductsByKeyword(@PathVariable String Keyword){
		ProductResponse productresponse = productservice.getProductsByKeyword(Keyword);
		return new ResponseEntity<>(productresponse , HttpStatus.OK);
	}
	
	
	@PutMapping("/admin/products/{ProductId}")
	public ResponseEntity<ProductDTO> updateProduct(@RequestBody Product product , 
			@PathVariable Long productId){
		ProductDTO productdto = productservice.updateProduct(productId , product); 
		return new ResponseEntity<>(productdto , HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/admin/products/{productId}")
	public ResponseEntity<ProductDTO> deleteProduct(@PathVariable Long productId){
		ProductDTO productdto = productservice.deleteProduct(productId); 
		return new ResponseEntity<>(productdto , HttpStatus.ACCEPTED);	
	}
	
//	@PutMapping("/products/{productId}/image")
//    public ResponseEntity<ProductDTO> updateProductImage(@PathVariable Long productId,
//                                                         @RequestParam("image")MultipartFile image) throws IOException {
//        ProductDTO updatedProduct = productservice.updateProductImage(productId, image);
//        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
//    }
}













