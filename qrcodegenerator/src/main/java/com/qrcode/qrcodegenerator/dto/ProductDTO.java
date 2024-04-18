package com.qrcode.qrcodegenerator.dto;

import com.qrcode.qrcodegenerator.model.Product;

public class ProductDTO {

    private Long id;
    private String code;
    private String productName;
    private int amount;
    private Double price;
    private String batch;
    private String description;

    public ProductDTO(Long id, String code, String productName, int amount, Double price, String batch, String description) {
        this.id = id;
        this.code = code;
        this.productName = productName;
        this.amount = amount;
        this.price = price;
        this.batch = batch;
        this.description = description;
    }

    public ProductDTO(Product entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.productName = entity.getProductName();
        this.amount = entity.getAmount();
        this.price = entity.getPrice();
        this.batch = entity.getBatch();
        this.description = entity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }

    public String getBatch() {
        return batch;
    }

    public String getDescription() {
        return description;
    }
}
