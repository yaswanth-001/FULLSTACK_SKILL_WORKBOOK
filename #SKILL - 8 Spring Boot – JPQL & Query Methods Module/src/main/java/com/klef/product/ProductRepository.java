package com.klef.product;

import org.springframework.data.jpa.repository.*;
import java.util.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    // Derived Query Methods
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL Queries
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getSortedProducts();

    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensiveProducts(double price);

    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getByCategory(String category);
}