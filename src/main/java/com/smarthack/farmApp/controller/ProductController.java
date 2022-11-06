package com.smarthack.farmApp.controller;

import com.smarthack.farmApp.entity.Product;
import com.smarthack.farmApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello (){
        return new ResponseEntity<>("helllloo", HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try{
            productService.addProduct(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Product> getByName(@PathVariable String name) {
        return  new ResponseEntity<>(productService.getByName(name), HttpStatus.OK);
    }

    @PutMapping(path = "/{name}/{newQuantity}")
    public ResponseEntity<?> update(@PathVariable String name, @PathVariable Integer newQuantity) {
        return new ResponseEntity<>(productService.updateByName(name, newQuantity), HttpStatus.OK);
    }

    @PutMapping(path = "/price/{name}/{newPrice}")
    public ResponseEntity<?> updatePrice(@PathVariable String name, @PathVariable Integer newPrice) {
        return new ResponseEntity<>(productService.updatePriceByName(name, newPrice), HttpStatus.OK);
    }

    @RequestMapping(path = "/{name}/delete", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteByName(@PathVariable("name") String name) {
        try {
            productService.deleteByName(name);
            return new ResponseEntity<>("Product deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
