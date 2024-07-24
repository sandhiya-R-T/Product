package com.task.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.dao.ProductREpository;
import com.task.product.Product;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductREpository productRepository;

    public void saveProduct(Product product) {
         productRepository.save(product);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}