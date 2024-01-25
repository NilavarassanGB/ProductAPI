package com.demo.product;

import org.springframework.stereotype.Component;

@Component
public class Product {
    static int ProductID=0;
    int Id;
    String name;
    String description;
    double price;
    int quantityAvailable;

    public Product(String name, String description, double price, int quantityAvailable) {
        this.Id = ++ProductID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public Product(int id, String name, String description, double price, int quantityAvailable) {
        Id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public Product() {

    }

    public int getProductID() {
        return Id;
    }

    public void setProductID(int productID) {
        Id = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductID=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }


}
