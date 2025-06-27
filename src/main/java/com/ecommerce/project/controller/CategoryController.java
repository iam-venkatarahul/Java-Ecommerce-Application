package com.ecommerce.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
import com.ecommerce.project.service.CategoryService;
import com.ecommerce.project.config.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryservice;
	
	public CategoryController(CategoryService categoryservice) {
		super();
		this.categoryservice = categoryservice;
	}
	@GetMapping("/public/categories")
	public ResponseEntity<CategoryResponse> getAllCategories(
			@RequestParam(name = "pageNumber" , defaultValue = AppConstants.Page_Number , required = false) Integer pageNumber,
			@RequestParam(name = "pageSize" , defaultValue = AppConstants.Page_Size , required = false) Integer pageSize ,
			@RequestParam(name = "sortBy", defaultValue = AppConstants.Sort_By , required = false) String sortBy ,
			@RequestParam(name = "sortOrder" , defaultValue = AppConstants.Sort_Order , required = false) String sortOrder){
		CategoryResponse categoryresponse = categoryservice.getAllCategories(pageNumber , pageSize , sortBy , sortOrder);
		return new ResponseEntity<>(categoryresponse , HttpStatus.OK);
	}
	@PostMapping("/public/categories")
	public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
		CategoryDTO SavedcategoryDTO = categoryservice.createCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(SavedcategoryDTO , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/admin/categories/{categoryId}")
	public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
		CategoryDTO deletedCategory = categoryservice.deleteCategory(categoryId);
		return new ResponseEntity<>( deletedCategory , HttpStatus.OK);
	}

	@PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable Long categoryId){
            CategoryDTO savedCategoryDTO = categoryservice.updateCategory(categoryDTO, categoryId);
            return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }
}



