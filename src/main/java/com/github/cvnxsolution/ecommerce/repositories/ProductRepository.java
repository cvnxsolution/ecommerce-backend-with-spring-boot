package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.dtos.ProductDTO;
import com.github.cvnxsolution.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCriteriaRepository {
    List<Product> findByPriceBetween(BigDecimal low, BigDecimal high);

    @Query("select p from Product p order by p.price desc")
    List<Product> findAllOrderByPriceDesc();

    @Query("select count(*) from Product p")
    Long countAllProductsJPQL();

    Long countByPriceBetween(BigDecimal low, BigDecimal high);

    @Query(value = "select count(*) from products p where p.price between :low and :high", nativeQuery = true)
    Long countByPriceBetweenNative(@Param("low") BigDecimal low, @Param("high") BigDecimal high);


    @Modifying
    @Query(value = "update products p set p.price = :newPrice where p.id = :id", nativeQuery = true)
    int updatePriceByIdNativeQuery(@Param("id") Long id,@Param("newPrice") BigDecimal newPrice);


    @Modifying
    @Query("update Product p set p.price = :newPrice where p.id = :id")
    int updatePriceByIdJPQL(@Param("id")Long id, @Param("newPrice") BigDecimal newPrice);


    @Procedure("findProductsByPrice")
    List<Product> findProducts(BigDecimal low, BigDecimal high);


}
