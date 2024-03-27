package com.example.springdatajpa.mapping;

import com.example.springdatajpa.dto.OwnerRequest;
import com.example.springdatajpa.dto.OwnerResponse;
import com.example.springdatajpa.model.Owner;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OwnerMapping {
OwnerResponse mapToOwnerResponse(Owner owner);
Owner mapRequestToOwner(OwnerRequest ownerRequest);
@AfterMapping
    default void setId(@MappingTarget Owner owner){
    if (owner.getId() == 0){
        owner.setId(0L);
    }
}
}
