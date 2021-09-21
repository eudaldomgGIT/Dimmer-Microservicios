package com.microservice.demo.product;

import com.microservice.demo.product.Service.ProductService;
import com.microservice.demo.product.Service.ProductServiceImp;
import com.microservice.demo.product.entity.Category;
import com.microservice.demo.product.entity.Product;
import com.microservice.demo.product.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {
    @Mock
    private ProductRepository productRepository;
    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        this.productService  = new ProductServiceImp(productRepository);
        Product computer = Product.builder()
                .id(1L)
                .name("computer")
                .category(Category.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(this.productRepository.findById(1L))
                .thenReturn(Optional.of(computer));
        Mockito.when(this.productRepository.save(computer)).thenReturn(computer);
    }
    @Test
    public void whenValidGetId_ThenReturnProduct(){
        Product found = this.productService.getProduct(1L);
        Assertions.assertThat(found.getName()).isEqualTo("computer");
    }
    @Test
    public void whenValidUpdateStock_ThenReturnNewStock(){
        Product newStock = this.productService.updateStock(1L, Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }
}
