package com.github.cvnxsolution.ecommerce.repositories;

import com.github.cvnxsolution.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("select c from Category c join fetch c.products where c.name = :name")
    Category findByName(@Param("name") String name);


}
