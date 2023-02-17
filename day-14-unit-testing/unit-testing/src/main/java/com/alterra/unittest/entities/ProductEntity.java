package com.alterra.unittest.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Schema(description = "Product Model")
public class ProductEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @Schema(description = "Product SKU name")
    private String name;
    @Schema(description = "Product SKU description")
    private String description;
    @Schema(description = "Product SKU available stock")
    private Integer stock;
    @Schema(description = "Product SKU price per unit")
    private BigDecimal price;
}
