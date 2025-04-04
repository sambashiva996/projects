package com.springboot.cache.service;

import com.springboot.cache.exception.ProductException;
import com.springboot.cache.model.Product;
import com.springboot.cache.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductException("Data Not Found"));
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductException("Data Not Found"));

        productRepository.deleteById(id);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
