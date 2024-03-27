package com.example.springdatajpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "owner_tbl")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String address;
    private String city;
    private String telephone;
    @ManyToMany
    public Set<Product> product;

}
