package com.demo.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    @Test
    void testProductCreationWithParameters() {
        String name = "TestProduct";
        String description = "This is a test product";
        double price = 50.0;
        int quantityAvailable = 10;
        Product product = new Product(name, description, price, quantityAvailable);
        assertEquals(name, product.getName());
        assertEquals(description, product.getDescription());
        assertEquals(price, product.getPrice());
        assertEquals(quantityAvailable, product.getQuantityAvailable());
        assertEquals(1, product.getProductID()); // Assuming initial ID is 1
    }

    @Test
    void testProductCreationWithDefaultConstructor() {
        Product product = new Product();
        assertNotNull(product);
        assertEquals(0, product.getProductID());
        assertNull(product.getName());
        assertNull(product.getDescription());
        assertEquals(0.0, product.getPrice());
        assertEquals(0, product.getQuantityAvailable());
    }

    @Test
    void testToStringMethod() {
        Product product = new Product(1, "TestProduct", "This is a test product", 50.0, 10);
        String toStringResult = product.toString();
        assertTrue(toStringResult.contains("ProductID=1"));
        assertTrue(toStringResult.contains("name='TestProduct'"));
        assertTrue(toStringResult.contains("description='This is a test product'"));
        assertTrue(toStringResult.contains("price=50.0"));
        assertTrue(toStringResult.contains("quantityAvailable=10"));
    }

}