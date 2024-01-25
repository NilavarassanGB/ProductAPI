package com.demo.controller;

import com.demo.dao.ProductRepository;
import com.demo.product.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/RestApi", produces = "application/json")
public class ProductController {

    //dependency injection is not working in the IDE I have in local. It is supposed to do in this way
    /*@Autowired
    public ProductService productService;*/

    ProductService productService = new ProductServiceImpl();

    @PostMapping (value = "/addProduct", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addProduct(@RequestBody Product prd){
        System.out.println("add Method called "+prd);
        Product product = productService.save(prd);
        System.out.println(product);
        //productService.displayProduct();
        return  new ResponseEntity<String>("Product added successfully", HttpStatus.CREATED);
    }

    @GetMapping(value = "/getProduct/{Id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProduct(@PathVariable("Id") Integer prdId){
        System.out.println("Get method called");
        Product prd= productService.findById(prdId);
        //System.out.println(prd);
        //productService.displayProduct();
        if(prd==null)
            return new ResponseEntity<String>("Product Not Found",HttpStatus.NOT_FOUND);
        else
        return new ResponseEntity<String>("Product Available "+ prd,HttpStatus.OK);
    }

    @GetMapping(value = "/getProducts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProduct(){
        System.out.println("GetAll method called");
        List <Product> prdList = (List<Product>) productService.findAll();
        //prdList.forEach(p->System.out.println(p));
        //productService.displayProduct();
        return new ResponseEntity<List<Product>>(prdList,HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{Id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("Id") int Id){
        System.out.println("Delete method called");
        Boolean flag = productService.delete(Id);
        //productService.displayProduct();
        if(flag==false)
            return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<String>("Product Deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteAllProducts")
    public ResponseEntity<String> deleteAllProduct(){
        System.out.println("DeleteAll method called");
        Boolean flag = productService.deleteAll();
        //productService.displayProduct();
        return new ResponseEntity<String>("Products Deleted successfully",HttpStatus.OK);
    }

    @PutMapping(value = "/updateDetails", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProduct(@RequestBody Product prd)  {
        System.out.println("Update method called");
        Product product = productService.update(prd);
        //productService.displayProduct();
        if(product == null)
            return  new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
        else
            return  new ResponseEntity<String>("Product updated successfully"+ product, HttpStatus.OK);
    }

    @GetMapping(value = "/addDiscount", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addDiscount(
            @RequestParam("id") int id,
            @RequestParam("percentage") double percentage) {
        System.out.println("Discount method called");
        Product prd = productService.discount(id,percentage);
        System.out.println(prd);
        if(prd == null)
            return  new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<String>("Discount applied successfully "+ prd, HttpStatus.OK);
    }

    @GetMapping(value = "/addTax", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addTax(
            @RequestParam("id") int id,
            @RequestParam("tax") double tax) {
        System.out.println("Tax method called");
        Product prd = productService.tax(id,tax);
        System.out.println(prd);
        if(prd == null)
            return  new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<String>("Tax applied successfully"+ prd, HttpStatus.OK);
    }










}
