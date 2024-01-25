package com.demo.service;


import com.demo.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    public Product save(Product product);
    public Product findById(int id);
    public List<Product> findAll();
    public Product update(Product product);
    public boolean delete(int id);
    public boolean deleteAll();
    public Product discount(int id, double discount);
    public Product tax(int id, double tax);
    public void displayProduct();
}
