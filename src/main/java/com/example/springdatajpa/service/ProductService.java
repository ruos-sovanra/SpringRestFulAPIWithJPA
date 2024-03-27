package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.ProductRequest;
import com.example.springdatajpa.dto.ProductResponse;


import java.util.List;


public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProductResponse createdProduct(ProductRequest request);
    ProductResponse updateProduct(ProductRequest request,Long id);
    void deleteProduct(Long id);
    ProductResponse getProductById(Long id);


}
