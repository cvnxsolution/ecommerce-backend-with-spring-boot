package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByPriceBetween(BigDecimal low, BigDecimal high);

    @Query("select p from Product p order by p.price desc")
    List<Product> findAllOrderByPriceDesc();
}
