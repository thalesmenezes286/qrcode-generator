package com.qrcode.qrcodegenerator.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String productName;
    private int amount;
    private Double price;
    private String batch;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Product(Long id, String code, String productName, int amount, Double price, String batch, String description) {
        this.id = id;
        this.code = code;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.batch = batch;
        this.description = description;
    }
}