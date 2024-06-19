package com.boostmytool.beststore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boostmytool.beststore.models.Product;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    private ProductsRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> search(String keyword, Pageable pageable) {
        return productRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(keyword, keyword, pageable);
    }
}

