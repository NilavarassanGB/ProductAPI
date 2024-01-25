package com.demo.dao;

import com.demo.product.Product;
import com.demo.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductRepositoryImplTest {
    private ProductRepositoryImpl productRepository;
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepositoryImpl();
        productService = new ProductServiceImpl();
    }

    @Test
    void testSave() {
        Product product = new Product();
        Product savedProduct = productRepository.save(product);
        assertNotNull(savedProduct);
        assertEquals(product, savedProduct);
        assertTrue(productRepository.findAll().contains(product));
    }

    @Test
    void testFindByIdWhenProductExists() {
        Product product = new Product();
        productRepository.save(product);
        Product foundProduct = productRepository.findById(product.getProductID());
        assertNotNull(foundProduct);
        assertEquals(product, foundProduct);
    }

    @Test
    void testFindByIdWhenProductDoesNotExist() {
        int nonExistingProductId = 999;
        Product foundProduct = productRepository.findById(nonExistingProductId);
        assertNull(foundProduct);
    }

    @Test
    void testFindAll() {
        Product product1 = new Product();
        Product product2 = new Product();
        productRepository.save(product1);
        productRepository.save(product2);
        List<Product> productList = productRepository.findAll();
        assertNotNull(productList);
        assertEquals(2, productList.size());
        assertTrue(productList.contains(product1));
        assertTrue(productList.contains(product2));
    }

    @Test
    void testUpdateProduct() {
        Product existingProduct = new Product();
        productService.save(existingProduct);
        Product updatedProduct = new Product();
        Product result = productService.update(updatedProduct);
        assertNotNull(result);
        assertEquals(updatedProduct, result);
        assertTrue(productService.findAll().contains(updatedProduct));
        assertFalse(productService.findAll().contains(existingProduct));
    }

    @Test
    void testUpdateNonExistingProduct() {
        Product nonExistingProduct = new Product();
        Product result = productService.update(nonExistingProduct);
        assertNull(result);
        assertFalse(productService.findAll().contains(nonExistingProduct));
    }

    @Test
    void testDeleteProduct() {
        Product productToDelete = new Product();
        productService.save(productToDelete); // Add product to the list
        boolean result = productService.delete(productToDelete.getProductID());
        assertTrue(result);
        assertFalse(productService.findAll().contains(productToDelete));
    }

    @Test
    void testDeleteNonExistingProduct() {
        boolean result = productService.delete(100);
        assertFalse(result);
    }

    @Test
    void testDeleteAllProducts() {
        productService.save(new Product());
        productService.save(new Product());
        boolean result = productService.deleteAll();
        assertTrue(result);
        assertTrue(productService.findAll().isEmpty());
    }



    @Test
    void testDiscountWhenProductDoesNotExist() {
        Product discountedProduct = productService.discount(1, 10.0);
        assertNull(discountedProduct);
    }



    @Test
    void testTaxWhenProductDoesNotExist() {
        Product taxedProduct = productService.tax(1, 10.0);
        assertNull(taxedProduct);
    }




}