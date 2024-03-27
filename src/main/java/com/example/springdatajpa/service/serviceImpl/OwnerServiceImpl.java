package com.example.springdatajpa.service.serviceImpl;

import com.example.springdatajpa.dto.OwnerRequest;
import com.example.springdatajpa.dto.OwnerResponse;
import com.example.springdatajpa.mapping.OwnerMapping;
import com.example.springdatajpa.repository.OwnerRepository;
import com.example.springdatajpa.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapping ownerMapping;

    @Override
    public List<OwnerResponse> getAllOwner() {
        return ownerRepository.findAll().stream().map(ownerMapping::mapToOwnerResponse).toList();
    }

    @Override
    public OwnerResponse createOwner(OwnerRequest request) {
        return ownerMapping.mapToOwnerResponse(ownerRepository.save(ownerMapping.mapRequestToOwner(request)));
    }

    @Override
    public OwnerResponse updateOwner(OwnerRequest request, Long id) {
        return ownerRepository.findById(id).map(owner->{
            owner.setName(request.name());
            owner.setCity(request.city());
            owner.setAddress(request.address());
            owner.setTelephone(request.telephone());
            return ownerMapping.mapToOwnerResponse(ownerRepository.save(owner));
                }).orElseThrow(()-> new RuntimeException("Owner Not Found"))
                ;
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }
}
