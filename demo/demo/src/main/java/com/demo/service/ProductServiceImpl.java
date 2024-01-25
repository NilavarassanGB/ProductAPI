package com.demo.service;

import com.demo.dao.ProductRepository;
import com.demo.dao.ProductRepositoryImpl;
import com.demo.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    //dependency injection is not working in the IDE I have in local. It is supposed to do in this way
   /*@Autowired
   ProductRepository productRepository;*/

   ProductRepository productRepository = new ProductRepositoryImpl();


    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean deleteAll() {
        return productRepository.deleteAll();
    }

    @Override
    public Product discount(int id, double discount) {
        return productRepository.discount(id,discount);
    }

    @Override
    public Product tax(int id, double tax) {
        return productRepository.tax(id,tax);
    }

    @Override
    public void displayProduct() {
        productRepository.displayProduct();
    }
}
