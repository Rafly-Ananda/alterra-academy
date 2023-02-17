package com.alterra.swaggerapi.repositories;

import com.alterra.swaggerapi.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
