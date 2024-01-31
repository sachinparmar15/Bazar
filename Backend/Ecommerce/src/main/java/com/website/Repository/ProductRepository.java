package com.website.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.website.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByCategory(String category);

	List<Product> findByNameContainingOrDetailsContainingOrCategoryContaining(String name, String details,
			String category);

	List<Product> findAll();


}
