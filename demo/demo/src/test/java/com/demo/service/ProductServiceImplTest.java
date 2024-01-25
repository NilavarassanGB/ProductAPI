package com.demo.service;

import com.demo.dao.ProductRepository;
import com.demo.product.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveProduct() {
        Product mockProduct = new Product();
        when(productRepository.save(mockProduct)).thenReturn(mockProduct);
        Product savedProduct = productService.save(mockProduct);
        assertEquals(mockProduct, savedProduct);
        verify(productRepository, times(1)).save(mockProduct);
    }

    @Test
    void testFindProductById() {
        int productId = 1;
        Product mockProduct = new Product();
        when(productRepository.findById(productId)).thenReturn(mockProduct);
        Product foundProduct = productService.findById(productId);
        assertEquals(mockProduct, foundProduct);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testFindAllProducts() {
        List<Product> mockProductList = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(mockProductList);
        List<Product> foundProducts = productService.findAll();
        assertEquals(mockProductList, foundProducts);
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testUpdate() {
        Product mockProduct = new Product(); // Create a mock product
        when(productRepository.update(any(Product.class))).thenReturn(mockProduct);
        Product result = productService.update(mockProduct);
        assertEquals(mockProduct, result);
        verify(productRepository, times(1)).update(mockProduct);
    }

    @Test
    void testDelete() {
        int productId = 1;
        when(productRepository.delete(productId)).thenReturn(true);
        boolean result = productService.delete(productId);
        assertTrue(result);
        verify(productRepository, times(1)).delete(productId);
    }

    @Test
    void testDeleteAll() {
        when(productRepository.deleteAll()).thenReturn(true);
        boolean result = productService.deleteAll();
        assertTrue(result);
        verify(productRepository, times(1)).deleteAll();
    }

    @Test
    void testDiscount() {
        int productId = 1;
        double discount = 0.1;
        Product mockProduct = new Product();
        when(productRepository.discount(productId, discount)).thenReturn(mockProduct);
        Product result = productService.discount(productId, discount);
        assertEquals(mockProduct, result);
        verify(productRepository, times(1)).discount(productId, discount);
    }

    @Test
    void testTax() {
        int productId = 1;
        double tax = 0.05;
        Product mockProduct = new Product();
        when(productRepository.tax(productId, tax)).thenReturn(mockProduct);
        Product result = productService.tax(productId, tax);
        assertEquals(mockProduct, result);
        verify(productRepository, times(1)).tax(productId, tax);
    }

    @Test
    void testDisplayProduct() {
        productService.displayProduct();
        verify(productRepository, times(1)).displayProduct();
    }


}