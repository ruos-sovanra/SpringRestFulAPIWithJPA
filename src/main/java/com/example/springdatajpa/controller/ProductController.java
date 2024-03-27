package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.ProductRequest;
import com.example.springdatajpa.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public HashMap<String, Object> generateResponse(Object data, String message, int status) {
        HashMap<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", message);
        response.put("status", status);
        return response;
    }

    @GetMapping
    public HashMap<String, Object> getAllProducts() {

        return generateResponse(productService.getAllProducts(), "All products fetched successfully", HttpStatus.OK.value());
    }

    @PostMapping("/")
    public HashMap<String, Object> createProduct(@Valid @RequestBody ProductRequest request) {
        log.info("This is from Input" + request);
        return generateResponse(productService.createdProduct(request), "Product created successfully", HttpStatus.CREATED.value());
    }
    @PatchMapping("/{id}")
    public HashMap<String, Object> updateProduct(@Valid @RequestBody ProductRequest product, @PathVariable Long id) {
        return generateResponse(productService.updateProduct(product, id), "Product updated successfully", HttpStatus.OK.value());
    }
    @DeleteMapping("/{id}")
    public HashMap<String, Object> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return generateResponse(null, "Product deleted successfully", HttpStatus.OK.value());
    }
    @GetMapping("/{id}")
    public HashMap<String, Object> getProductById(@PathVariable Long id) {
        return generateResponse(productService.getProductById(id), "Product fetched successfully", HttpStatus.OK.value());
    }

}
