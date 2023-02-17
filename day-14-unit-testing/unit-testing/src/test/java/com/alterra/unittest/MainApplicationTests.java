package com.alterra.unittest;

import com.alterra.unittest.entities.ProductEntity;
import com.alterra.unittest.repositories.ProductRepository;
import com.alterra.unittest.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class MainApplicationTests {

	@Mock
	private ProductRepository productRepository;

	@InjectMocks
	private ProductService productService;

	private ProductEntity product;

	@BeforeEach
	public void setup() {
		product = ProductEntity.builder()
				.name("Apple Iphone 13")
				.description("13th generation of Apple Iphone")
				.stock(200)
				.price(BigDecimal.valueOf(18000000))
				.build();
	}

	@DisplayName("Unit test to save product")
	@Test
	public void testCreateProduct() {
		ProductEntity createdProduct = ProductEntity.builder()
				.id(1)
				.name("Apple Iphone 13")
				.description("13th generation of Apple Iphone")
				.stock(200)
				.price(BigDecimal.valueOf(18000000))
				.build();

		// Act
		when(productService.createProduct(product)).thenReturn(createdProduct);

		// Assert
		ProductEntity actual = productService.createProduct(product);
		Assertions.assertEquals(actual, createdProduct);

	}

	@DisplayName("Unit test to get all products")
	@Test
	public void testGetAllProducts() {
		// Arrange
		ProductEntity product1 = ProductEntity.builder()
				.id(1)
				.name("Apple Iphone 13")
				.description("13th generation of Apple Iphone")
				.stock(200)
				.price(BigDecimal.valueOf(18000000))
				.build();

		ProductEntity product2 = ProductEntity.builder()
				.id(2)
				.name("Apple Iphone 14")
				.description("14th generation of Apple Iphone")
				.stock(300)
				.price(BigDecimal.valueOf(19000000))
				.build();

		List<ProductEntity> expectedResult = List.of(product1, product2);

		// Act
		when(productService.getAllProducts()).thenReturn(expectedResult);

		// Assert
		List<ProductEntity> actual = productService.getAllProducts();
		Assertions.assertEquals(actual, expectedResult);
	}

	@DisplayName("Unit test to get single product")
	@Test
	public void testGetSingleProduct() {
		// Arrange
		ProductEntity expectedResult = ProductEntity.builder()
				.id(1)
				.name("Apple Iphone 13")
				.description("13th generation of Apple Iphone")
				.stock(200)
				.price(BigDecimal.valueOf(18000000))
				.build();

		// Act
		when(productService.getSingleProduct(1)).thenReturn(Optional.of(expectedResult));

		// Assert
		Optional<ProductEntity> actual = productService.getSingleProduct(1);
		Assertions.assertNotNull(actual);
	}

	@DisplayName("Unit test to update product")
	@Test
	public void testUpdateProduct() {
		// Arrange
		ProductEntity baseProduct =  ProductEntity.builder()
				.id(1)
				.name("Apple Iphone 13")
				.description("13th generation of Apple Iphone")
				.stock(200)
				.price(BigDecimal.valueOf(18000000))
				.build();

		ProductEntity updatedProduct =  ProductEntity.builder()
				.name("Apple Iphone 13")
				.description("13th generation of Apple Iphone")
				.stock(350)
				.price(BigDecimal.valueOf(19000000))
				.build();

		// Act
		when(productRepository.findById(1)).thenReturn(Optional.of(baseProduct));
		when(productRepository.save(updatedProduct)).thenReturn(updatedProduct);


		// Assert
		ProductEntity actual = productService.updateProduct(updatedProduct, 1);
		Assertions.assertNotEquals(actual, baseProduct);


	}

	@DisplayName("Unit test for delete product")
	@Test
	public void testDeleteProduct() {
		// Arrange
		ProductEntity product =  ProductEntity.builder()
				.id(1)
				.name("Apple Iphone 13")
				.description("13th generation of Apple Iphone")
				.stock(200)
				.price(BigDecimal.valueOf(18000000))
				.build();

		// Act
		when(productRepository.findById(1)).thenReturn(Optional.of(product));


		// Assert
		String  actual = productService.deleteProduct(1);
		Assertions.assertEquals(actual, "Product deleted");
	}

}
