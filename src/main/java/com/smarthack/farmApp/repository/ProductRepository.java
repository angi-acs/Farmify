package com.smarthack.farmApp.repository;

import com.smarthack.farmApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID>, JpaRepository<Product, UUID> {
        Product findByName(String name);
        boolean existsByName(String name);
        void deleteByName(String name);
}
