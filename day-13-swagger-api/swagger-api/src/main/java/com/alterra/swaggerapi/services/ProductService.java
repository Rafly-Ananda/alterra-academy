package com.alterra.swaggerapi.services;

import com.alterra.swaggerapi.dtos.ProductRequest;
import com.alterra.swaggerapi.dtos.ProductResponse;
import com.alterra.swaggerapi.entities.ProductEntity;
import com.alterra.swaggerapi.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    // Swagger API Documentation URL is at http://localhost:8080/swagger-ui/index.html#/

    private final ProductRepository productRepository;

    public ProductEntity createProduct(ProductRequest productRequest) {
        ProductEntity product = ProductEntity.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .stock(productRequest.getStock())
                .price(productRequest.getPrice())
                .build();

        return productRepository.save(product);
    }

    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();

    }

    public Optional<ProductResponse> getSingleProduct(Integer id) {
       Optional<ProductEntity> product = productRepository.findById(id);

            return product.map(this::mapToProductResponse);
    }

    public ProductEntity updateProduct(ProductRequest productRequest, Integer id) {
        ProductEntity product = productRepository.findById(id).orElseThrow();
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setStock(productRequest.getStock());
        product.setPrice(productRequest.getPrice());

        return productRepository.save(product);
    }

    public String deleteProduct(Integer id) {
        productRepository.deleteById(id);
        return "Product deleted";
    }

    private ProductResponse mapToProductResponse(ProductEntity productEntity) {
        return ProductResponse.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .description(productEntity.getDescription())
                .stock(productEntity.getStock())
                .price(productEntity.getPrice())
                .build();
    }

}
