package com.alterra.swaggerapi.controllers;

import com.alterra.swaggerapi.dtos.ProductRequest;
import com.alterra.swaggerapi.dtos.ProductResponse;
import com.alterra.swaggerapi.entities.ProductEntity;
import com.alterra.swaggerapi.services.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
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

    // Swagger API Documentation URL is at http://localhost:8080/swagger-ui/index.html#/

    private final ProductService productService;

    @Operation(summary = "Create product and stores it inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Book successfully stored inside the database")
    })
    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@Parameter(description = "Product details in order to create product object")  @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @Operation(summary = "Retrieve all products that stored inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API hit success, if products exist will show list of products")
    })
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @Operation(summary = "Retrieve single product that stored inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API hit success, if products exist will show product stored inside a list data structure")
    })
    @GetMapping("{id}")
    public ResponseEntity<Optional<ProductResponse>> getSingleProduct(@Parameter(description = "Id of product that we want to retrieve") @PathVariable Integer id) {
        return ResponseEntity.ok(productService.getSingleProduct(id));
    }

    @Operation(summary = "Update single product that stored inside the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "API hit success, will returned the updated product")
    })
    @PutMapping("{id}")
    public ResponseEntity<ProductEntity> updateProduct(@Parameter(description = "Product details in order to create product object") @RequestBody ProductRequest productRequest, @Parameter(description = "Product id of the book that we want to update") @PathVariable  Integer id) {
        return ResponseEntity.ok(productService.updateProduct(productRequest, id));
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
