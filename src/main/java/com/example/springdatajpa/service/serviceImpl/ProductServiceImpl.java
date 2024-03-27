package com.example.springdatajpa.service.serviceImpl;

import com.example.springdatajpa.dto.ProductRequest;
import com.example.springdatajpa.dto.ProductResponse;
import com.example.springdatajpa.mapping.ProductMapper;
import com.example.springdatajpa.repository.ProductRepository;
import com.example.springdatajpa.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream().map(productMapper::mapToProductResponse).toList();
    }

    @Override
    public ProductResponse createdProduct(ProductRequest request) {

        return productMapper.mapToProductResponse(productRepository.save(productMapper.mapToProductRequest(request)));
    }

    @Override
    public ProductResponse updateProduct(ProductRequest request, Long id) {
        return productRepository.findById(id).map(product -> {
            product.setName(request.name());
            product.setPrice(request.price());
            product.setDescription(request.description());
            product.setImageUrl(request.imageUrl());
            return productMapper.mapToProductResponse(productRepository.save(product));
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public ProductResponse getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::mapToProductResponse).orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
