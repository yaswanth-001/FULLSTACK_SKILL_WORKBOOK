package com.klef.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    // Insert sample data
    @PostMapping
    public Product addProduct(@RequestBody Product p) {
        return repo.save(p);
    }

    // Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Price filter
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min, @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sorted
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.getSortedProducts();
    }

    // Expensive
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.getExpensiveProducts(price);
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}