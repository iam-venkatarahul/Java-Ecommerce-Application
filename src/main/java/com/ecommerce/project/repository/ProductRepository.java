//This is part of an e-commerce project			

package com.ecommerce.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.model.Product;

import jakarta.persistence.Id;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategoryOrderByPriceAsc(Category category);

	List<Product> findByProductNameLikeIgnoreCase(String keyword);
}
