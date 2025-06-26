package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}