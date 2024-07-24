package com.task.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.product.Product;

@Repository
public interface ProductREpository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
}