package com.ecommerce.project.service;

//import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
import com.ecommerce.project.model.Category;
import com.ecommerce.project.payload.CategoryDTO;
import com.ecommerce.project.payload.CategoryResponse;
//import com.ecommerce.project.controller.*;
import com.ecommerce.project.exceptions.ApiException;
import com.ecommerce.project.exceptions.NoCategoryPresentException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class CategoryServiceImpl implements CategoryService {

	// private long nextId;

	// private List<Category> categories = new ArrayList<>();

	@Autowired
	private CategoryRepository categoryrepo;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder) {

		Sort sortByandOrder = sortOrder.equalsIgnoreCase("asc")
				? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable pageDetails = PageRequest.of(pageNumber, pageSize, sortByandOrder);
		Page<Category> categoryPage = categoryrepo.findAll(pageDetails);
		List<Category> categories = categoryPage.getContent();

		if (categories == null) {
			throw new NoCategoryPresentException("There No Categories Present......");
		}

		List<CategoryDTO> categoryDTOS = categories.stream()
				.map(category -> modelmapper.map(category, CategoryDTO.class))
				.toList();
		CategoryResponse categoryresponse = new CategoryResponse();
		categoryresponse.setContent(categoryDTOS);
		categoryresponse.setPageNumber(categoryPage.getNumber());
		categoryresponse.setPageSize(categoryPage.getSize());
		categoryresponse.setTotalElements(categoryPage.getTotalElements());
		categoryresponse.setTotalPages(categoryPage.getTotalPages());
		categoryresponse.setLastPage(categoryPage.isLast());

		return categoryresponse;
	}

	@Override
	public CategoryDTO createCategory(CategoryDTO categoryDTO) {
		Category category = modelmapper.map(categoryDTO, Category.class);
		Category savedCategory = categoryrepo.findByCategoryName(category.getCategoryName());
		if (savedCategory != null) {
			throw new ApiException("Category with the name " + category.getCategoryName() + " already exists....");
		}
		Category savedcategory = categoryrepo.save(category);
		return modelmapper.map(savedcategory, CategoryDTO.class);
	}

	@Override
	public CategoryDTO deleteCategory(Long categoryId) {
		List<Category> categories = categoryrepo.findAll();
		Category category = categories.stream()
				.filter(c -> c.getCategoryId().equals(categoryId))
				.findFirst().orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
		categoryrepo.delete(category);
		return modelmapper.map(category, CategoryDTO.class);
	}

	@Override
	public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
		Category savedCategory = categoryrepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

		Category category = modelmapper.map(categoryDTO, Category.class);
		category.setCategoryId(categoryId);
		savedCategory = categoryrepo.save(category);
		return modelmapper.map(savedCategory, CategoryDTO.class);
	}
}
