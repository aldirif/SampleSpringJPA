package com.rapidtech.springdatajpapgsql.service;

import com.rapidtech.springdatajpapgsql.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product saveOrUpdateProduct(Product product);
    void deleteProduct(Long id);
    List<Product> findAllByName(String name);
    List<Product> findAllByPrice(double price);
}