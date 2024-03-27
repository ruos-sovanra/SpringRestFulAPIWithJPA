package com.example.springdatajpa.dto;

import lombok.Builder;

@Builder
public record ProductResponse(Long id, String name, String description, float price, String imageUrl) {
}
