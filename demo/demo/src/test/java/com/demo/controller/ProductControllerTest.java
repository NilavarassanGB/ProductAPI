package com.demo.controller;

import com.demo.controller.ProductController;
import com.demo.product.Product;
import com.demo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddProduct() {

        Product mockProduct = new Product("TV","Samsung TV",25000.0,20);
        when(productService.save(any(Product.class))).thenReturn(mockProduct);
        ResponseEntity<String> response = productController.addProduct(mockProduct);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Product added successfully", response.getBody());
        verify(productService, times(1)).save(any(Product.class));
    }

    @Test
    void testGetProductWhenProductExists() {
        int productId = 1;
        Product mockProduct = new Product();
        when(productService.findById(productId)).thenReturn(mockProduct);
        ResponseEntity<String> response = productController.getProduct(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product Available " + mockProduct, response.getBody());
        verify(productService, times(1)).findById(productId);
    }

    @Test
    void testGetProductWhenProductDoesNotExist() {
        int productId = 1;
        when(productService.findById(productId)).thenReturn(null);
        ResponseEntity<String> response = productController.getProduct(productId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Product Not Found", response.getBody());
        verify(productService, times(1)).findById(productId);
    }

    @Test
    void testGetAllProduct() {
        List<Product> mockProductList = Arrays.asList(new Product(), new Product());
        when(productService.findAll()).thenReturn(mockProductList);
        ResponseEntity<List<Product>> response = productController.getAllProduct();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockProductList, response.getBody());
        verify(productService, times(1)).findAll();
    }

    @Test
    void testDeleteProductWhenProductExists() {
        int productId = 1;
        when(productService.delete(productId)).thenReturn(true);
        ResponseEntity<String> response = productController.deleteProduct(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product Deleted successfully", response.getBody());
        verify(productService, times(1)).delete(productId);
    }

    @Test
    void testDeleteProductWhenProductDoesNotExist() {
        int productId = 1;
        when(productService.delete(productId)).thenReturn(false);
        ResponseEntity<String> response = productController.deleteProduct(productId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Not Found", response.getBody());
        verify(productService, times(1)).delete(productId);
    }

    @Test
    void testDeleteAllProduct() {
        when(productService.deleteAll()).thenReturn(true);
        ResponseEntity<String> response = productController.deleteAllProduct();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Products Deleted successfully", response.getBody());
        verify(productService, times(1)).deleteAll();
    }


    @Test
    void testUpdateProductWhenProductExists() {
        Product mockProduct = new Product();
        when(productService.update(any(Product.class))).thenReturn(mockProduct);
        ResponseEntity<String> response = productController.updateProduct(new Product());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product updated successfully" + mockProduct, response.getBody());
        verify(productService, times(1)).update(any(Product.class));
    }

    @Test
    void testUpdateProductWhenProductDoesNotExist() {
        when(productService.update(any(Product.class))).thenReturn(null);
        ResponseEntity<String> response = productController.updateProduct(new Product());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Not found", response.getBody());
        verify(productService, times(1)).update(any(Product.class));
    }

    @Test
    void testAddDiscountWhenProductExists() {
        int productId = 1;
        double discountPercentage = 10.0;
        Product mockProduct = new Product();
        when(productService.discount(productId, discountPercentage)).thenReturn(mockProduct);
        ResponseEntity<String> response = productController.addDiscount(productId, discountPercentage);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Discount applied successfully " + mockProduct, response.getBody());
        verify(productService, times(1)).discount(productId, discountPercentage);
    }

    @Test
    void testAddDiscountWhenProductDoesNotExist() {
        int productId = 1;
        double discountPercentage = 10.0;
        when(productService.discount(productId, discountPercentage)).thenReturn(null);
        ResponseEntity<String> response = productController.addDiscount(productId, discountPercentage);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Not found", response.getBody());
        verify(productService, times(1)).discount(productId, discountPercentage);
    }

    @Test
    void testAddTaxWhenProductExists() {
        int productId = 1;
        double taxValue = 0.1;
        Product mockProduct = new Product();
        when(productService.tax(productId, taxValue)).thenReturn(mockProduct);
        ResponseEntity<String> response = productController.addTax(productId, taxValue);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Tax applied successfully" + mockProduct, response.getBody());
        verify(productService, times(1)).tax(productId, taxValue);
    }

    @Test
    void testAddTaxWhenProductDoesNotExist() {
        int productId = 1;
        double taxValue = 0.1;
        when(productService.tax(productId, taxValue)).thenReturn(null);
        ResponseEntity<String> response = productController.addTax(productId, taxValue);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Not found", response.getBody());
        verify(productService, times(1)).tax(productId, taxValue);
    }





}
