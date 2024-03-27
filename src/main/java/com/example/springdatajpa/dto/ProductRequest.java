package com.example.springdatajpa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.NonNull;

@Builder
public record ProductRequest(
        @NonNull
        @NotEmpty
        String name,
        @NonNull
        String description,
        @Positive
        float price,
        @NonNull
        String imageUrl) {
}
