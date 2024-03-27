package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.Owner;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
