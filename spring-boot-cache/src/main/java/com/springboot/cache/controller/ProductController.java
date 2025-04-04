package com.springboot.cache.controller;

import com.springboot.cache.model.Product;
import com.springboot.cache.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-controller")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    @CachePut(cacheNames = "product", key = "#product.id")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        log.info("saveProduct() started");
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @GetMapping("/product/{id}")
    @Cacheable(cacheNames = "product", key = "#id")
    public ResponseEntity<Product> getProduct(@PathVariable Long id){
        log.info("getProduct() started : '{}'", id);
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }

    @DeleteMapping("/product/{id}")
    @CacheEvict(cacheNames = "product", key = "#id")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id){
        log.info("deleteProduct() started : '{}'", id);
        return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
    }

    @GetMapping("/products")
    @Cacheable(cacheNames = "products", value = "products")
    public ResponseEntity<List<Product>> productList(){
        log.info("productList() started");
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

}
