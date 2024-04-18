package com.qrcode.qrcodegenerator.service;

import com.qrcode.qrcodegenerator.constants.Constants;
import com.qrcode.qrcodegenerator.dto.ProductDTO;
import com.qrcode.qrcodegenerator.model.Product;
import com.qrcode.qrcodegenerator.repository.ProductRepository;
import com.qrcode.qrcodegenerator.service.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getProduct(){

        List<Product> result = productRepository.findAll();

        return result.stream().map(x -> new ProductDTO(x)).toList();
    }

    public ProductDTO save(ProductDTO dto){

        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setCode(dto.getCode());
        entity.setProductName(dto.getProductName());
        entity.setAmount(dto.getAmount());
        entity.setPrice(dto.getPrice());
        entity.setBatch(dto.getBatch());
        entity.setDescription(dto.getDescription());
        entity = productRepository.save(entity);

        return new ProductDTO(entity);
    }

    public ProductDTO findById(Long id) {

        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Constants.PRODUCT_MESSAGE));

        return new ProductDTO(product);
    }
}
