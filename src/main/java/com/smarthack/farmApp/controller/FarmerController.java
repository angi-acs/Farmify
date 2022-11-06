package com.smarthack.farmApp.controller;

import com.smarthack.farmApp.entity.Farmer;
import com.smarthack.farmApp.entity.Product;
import com.smarthack.farmApp.service.FarmerService;
import com.smarthack.farmApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/farmer")
public class FarmerController {
    @Autowired
    FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }

    @GetMapping(path = "/list/{name}")
    public ResponseEntity<Collection<Product>> getProducts(@PathVariable("name") String name) {
        return new ResponseEntity<>(farmerService.getProducts(name), HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Farmer farmer) {
        try{
            farmerService.addFarmer(farmer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
