package com.boostmytool.beststore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boostmytool.beststore.models.Product;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public Page<Product> findAll(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    public Page<Product> search(String keyword, Pageable pageable) {
        return productsRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(keyword, keyword, pageable);
    }

    public Product findById(Integer id) {
        Optional<Product> result = productsRepository.findById(id);
        return result.orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
