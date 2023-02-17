package com.alterra.unittest.services;

import com.alterra.unittest.entities.ProductEntity;
import com.alterra.unittest.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductEntity createProduct(ProductEntity productEntity) {
        ProductEntity product = ProductEntity.builder()
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .stock(productEntity.getStock())
                .price(productEntity.getPrice())
                .build();

        return productRepository.save(product);
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();

    }

    public Optional<ProductEntity> getSingleProduct(Integer id) {
            return productRepository.findById(id);
    }

    public ProductEntity updateProduct(ProductEntity productEntity, Integer id) {
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setName(productEntity.getName());
        product.setDescription(productEntity.getDescription());
        product.setStock(productEntity.getStock());
        product.setPrice(productEntity.getPrice());
        return productRepository.save(product);
    }

    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }

}
