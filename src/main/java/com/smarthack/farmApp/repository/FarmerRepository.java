package com.smarthack.farmApp.repository;

import com.smarthack.farmApp.entity.Farmer;
import com.smarthack.farmApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FarmerRepository extends CrudRepository<Farmer, UUID>, JpaRepository<Farmer, UUID> {
    Farmer findByName(String name);
}
