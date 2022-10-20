package com.rapidtech.springdatajpapgsql.controller;

import com.rapidtech.springdatajpapgsql.model.Product;
import com.rapidtech.springdatajpapgsql.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.findAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product){
        return productService.saveOrUpdateProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/byname")
    public List<Product> getProductByName(@RequestParam(name = "name")String name){
        return productService.findAllByName(name);
    }

    @GetMapping("/byprice")
    public List<Product> getProductByPrice(@RequestParam(name="price") double price){
        return productService.findAllByPrice(price);
    }
}