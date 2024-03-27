package com.example.springdatajpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private float price;
    private String imageUrl;

}
