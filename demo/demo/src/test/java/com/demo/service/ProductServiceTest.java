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
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Product mockProduct = new Product();
        when(productRepository.save(any(Product.class))).thenReturn(mockProduct);
        Product result = productService.save(mockProduct);
        assertNotNull(result);
        assertEquals(mockProduct, result);
        verify(productRepository, times(1)).save(any(Product.class));
    }

    @Test
    void testFindById() {
        int productId = 1;
        Product mockProduct = new Product();
        when(productRepository.findById(productId)).thenReturn(mockProduct);
        Product result = productService.findById(productId);
        assertNotNull(result);
        assertEquals(mockProduct, result);
        verify(productRepository, times(1)).findById(productId);
    }

    @Test
    void testFindAll() {
        List<Product> mockProductList = Arrays.asList(new Product(), new Product());
        when(productRepository.findAll()).thenReturn(mockProductList);
        List<Product> result = productService.findAll();
        assertNotNull(result);
        assertEquals(mockProductList, result);
        verify(productRepository, times(1)).findAll();
    }




}