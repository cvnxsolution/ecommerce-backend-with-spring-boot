package com.github.cvnxsolution.ecommerce.dtos;


import java.math.BigDecimal;

interface CategoryDTO {
    Byte getId();
    String getName();
}


public interface ProductDTO {
    Long getId();
    String getName();
    BigDecimal getPrice();
    String getDescription();
    CategoryDTO getCategory();
}
