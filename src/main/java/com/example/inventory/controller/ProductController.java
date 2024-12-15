package com.example.inventory.controller;

import com.example.inventory.entity.Product;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Fetch all products
    @GetMapping
    public List<Product> fetchAllProducts() {
        return productService.getAllProducts();
    }

    // Fetch a product by its ID
    @GetMapping("/{id}")
    public Product fetchProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
    }

    // Create a new product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Delete a product by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
