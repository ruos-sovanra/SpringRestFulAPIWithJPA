package com.example.springdatajpa.service;

import com.example.springdatajpa.dto.OwnerRequest;
import com.example.springdatajpa.dto.OwnerResponse;


import java.util.List;

public interface OwnerService {
    List<OwnerResponse> getAllOwner();
    OwnerResponse createOwner(OwnerRequest request);
    OwnerResponse updateOwner(OwnerRequest request, Long id);
    void deleteOwner(Long id);
}
