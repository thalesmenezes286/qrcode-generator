package com.qrcode.qrcodegenerator.controller;

import com.google.zxing.WriterException;
import com.qrcode.qrcodegenerator.dto.ProductDTO;
import com.qrcode.qrcodegenerator.model.Product;
import com.qrcode.qrcodegenerator.service.ProductService;
import com.qrcode.qrcodegenerator.utils.QRCodeGenerator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.net.URI;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProdutc() throws IOException, WriterException {

        List<ProductDTO> result = productService.getProduct();

        if (!result.isEmpty()){
            for (ProductDTO dto : result){
                QRCodeGenerator.generateQRCode(dto);
            }
        }

        return ResponseEntity.ok(productService.getProduct());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {

        dto = productService.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {

        ProductDTO dto = productService.findById(id);

        return ResponseEntity.ok(dto);
    }
}