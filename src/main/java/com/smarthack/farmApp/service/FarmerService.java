package com.smarthack.farmApp.service;

import com.smarthack.farmApp.entity.Farmer;
import com.smarthack.farmApp.entity.Product;
import com.smarthack.farmApp.repository.FarmerRepository;
import com.smarthack.farmApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class FarmerService {
    @Autowired
    FarmerRepository farmerRepository;

    public FarmerService(){}

    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    public Collection<Product> getProducts(String name){
//        return StreamSupport.stream(farmerRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
        Farmer farmer = farmerRepository.findByName(name);
        return farmer.getProductList();

    }

    public Farmer addFarmer(Farmer farmer) {
            farmerRepository.save(farmer);
            return farmer;
    }
}
