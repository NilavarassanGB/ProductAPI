package com.demo.main;

import com.demo.controller.ProductController;
import com.demo.product.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.PrintStream;

@SpringBootApplication
public class DemoApplication {




	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		/*Product pr = new Product("TV","Samsung TV",25000.0,20);
		Product pr1 = new Product("Monitor","Samsung Monitor",15000.0,5);
		Product pr2 = new Product("Laptop","HP LAPTOP",50000.0,8);
		Product pr3 = new Product("Printer","Canon Printer",8000.0,27);

		Product updatepr = new Product( 1,"TV123","Samsung TV123",27000.0,28);

		ProductController PC = new ProductController();
		PC.addProduct(pr);
		PC.addProduct(pr1);
		PC.addProduct(pr2);
		PC.addProduct(pr3);

		PC.addDiscount(2,50);
		PC.addTax(1,10);*/

	}

}
