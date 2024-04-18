package com.qrcode.qrcodegenerator.repository;

import com.qrcode.qrcodegenerator.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
