package com.alterra.unittest.controllers;

import com.alterra.unittest.entities.ProductEntity;
import com.alterra.unittest.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Create product and stores it inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book successfully stored inside the database")
    })
    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@Parameter(description = "Product details in order to create product object")  @RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productService.createProduct(productEntity));
    }

    @Operation(summary = "Retrieve all products that stored inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API hit success, if products exist will show list of products")
    })
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Retrieve single product that stored inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API hit success, if products exist will show product stored inside a list data structure")
    })
    @GetMapping("{id}")
    public ResponseEntity<Optional<ProductEntity>> getSingleProduct(@Parameter(description = "Id of product that we want to retrieve") @PathVariable Integer id) {
        return ResponseEntity.ok(productService.getSingleProduct(id));
    }

    @Operation(summary = "Update single product that stored inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API hit success, will returned the updated product")
    })
    @PutMapping("{id}")
    public ResponseEntity<ProductEntity> updateProduct(@Parameter(description = "Product details in order to create product object") @RequestBody ProductEntity productEntity, @Parameter(description = "Product id of the book that we want to update") @PathVariable  Integer id) {
        return ResponseEntity.ok(productService.updateProduct(productEntity, id));
    }

    @Operation(summary = "Delete single product that stored inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API hit success, product successfully deleted")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@Parameter(description = "Id of product that we want to delete") @PathVariable Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
}
