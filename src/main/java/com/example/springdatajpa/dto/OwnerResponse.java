package com.example.springdatajpa.dto;

import lombok.Builder;

@Builder
public record OwnerResponse(Long id, String name , String address, String city, String telephone) {
}
