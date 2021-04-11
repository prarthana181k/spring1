package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;

@Repository
//@EnableJpaRepositories
public interface ProductDaoI extends JpaRepository<Product, Integer>{
	//public Product findByNameEqualsIgnoreCaseCategoryEqualsIgnoreCase(String name, String category);
}
