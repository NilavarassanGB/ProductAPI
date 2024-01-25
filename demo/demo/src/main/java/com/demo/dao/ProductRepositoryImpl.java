package com.demo.dao;

import com.demo.product.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private ArrayList<Product> productList = new ArrayList<>();


    @Override
    public Product save(Product product) {
        productList.add(product);
        return product;
    }

    @Override
    public Product findById(int id) {

        for(Product product : productList){
            if(product.getProductID()==id)
                return product;
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product update(Product prd) {
        for(Product product : productList){
            if(product.getProductID()==prd.getProductID()){
                productList.remove(product);
                productList.add(prd);
                return prd;
            }

        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Product prd = findById(id);
        return productList.remove(prd);
    }

    @Override
    public boolean deleteAll() {
        productList.clear();
        return true;
    }

    @Override
    public Product discount(int id, double discount) {
        for(Product product : productList){
            if(product.getProductID()==id){
                double price = product.getPrice(),newPrice;
                newPrice = price-(price/100*discount);
                product.setPrice(newPrice);
                //System.out.println(price+" "+newPrice);
                return product;
            }

        }
        return null;
    }

    @Override
    public Product tax(int id, double tax) {
        for(Product product : productList){
            if(product.getProductID()==id){
                double price = product.getPrice(),newPrice;
                newPrice = price+(price/100*tax);
                product.setPrice(newPrice);
                //System.out.println(price+" "+newPrice);
                return product;
            }

        }
        return null;
    }

    @Override
    public void displayProduct() {
        for(Product product : productList)
            System.out.println(product);
    }
}
