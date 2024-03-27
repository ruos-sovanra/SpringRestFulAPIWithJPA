package com.example.springdatajpa.dto;

import lombok.Builder;

@Builder
public record OwnerRequest(String name , String address, String city, String telephone ) {
}
