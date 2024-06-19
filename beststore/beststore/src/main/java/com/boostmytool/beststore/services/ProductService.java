package com.boostmytool.beststore.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.boostmytool.beststore.models.Product;

public interface ProductService {
	 Page<Product> findAll(Pageable pageable);
	 Page<Product> search(String keyword, Pageable pageable);
}
