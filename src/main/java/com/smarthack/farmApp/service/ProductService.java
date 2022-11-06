package com.smarthack.farmApp.service;

import com.smarthack.farmApp.entity.Product;
import com.smarthack.farmApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product getByName(String name) {
        return productRepository.findByName(name);
    }

    public Product updateByName(String name, Integer quantity) {
        Product product = productRepository.findByName(name);
        product.setQuantity(quantity);
        productRepository.save(product);
        return product;
    }

    public Product updatePriceByName(String name, Integer price) {
        Product product = productRepository.findByName(name);
        product.setQuantity(price);
        productRepository.save(product);
        return product;
    }

    public void deleteByName(String name) throws Exception {
        if(productRepository.existsByName(name)) {
            productRepository.deleteByName(name);
        } else {
            throw new Exception("id not found");
        }
    }
}
