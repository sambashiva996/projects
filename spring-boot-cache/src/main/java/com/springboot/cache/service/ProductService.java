package com.springboot.cache.service;

import com.springboot.cache.model.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProductById(Long id);

    Product deleteProduct(Long id);

    List<Product> getAllProducts();
}
