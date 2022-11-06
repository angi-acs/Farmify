package com.smarthack.farmApp.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
public class Farmer {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private Integer telephone;

    @OneToMany(mappedBy = "farmer", orphanRemoval = true, fetch = FetchType.LAZY)
    private Collection<Product> productList;

    public Farmer() {

    }

    public Farmer(UUID id, String name, String email, Integer telephone, Collection<Product> productList) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.productList = productList;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Collection<Product> getProductList() {
        return productList;
    }

    public void setProductList(Collection<Product> productList) {
        this.productList = productList;
    }
}
