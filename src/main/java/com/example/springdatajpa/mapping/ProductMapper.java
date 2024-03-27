package com.example.springdatajpa.mapping;

import com.example.springdatajpa.dto.ProductRequest;
import com.example.springdatajpa.dto.ProductResponse;
import com.example.springdatajpa.model.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponse mapToProductResponse(Product product) ;
    Product mapToProductRequest(ProductRequest productRequest);
    @AfterMapping
    default void setId(@MappingTarget Product product ){
       if (product.getId() == 0){
           product.setId(0);
       }

    }
}
