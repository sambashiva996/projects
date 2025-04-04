package com.springboot.cache.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUCT")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", sequenceName = "product_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String model;
    private String brand;
}
