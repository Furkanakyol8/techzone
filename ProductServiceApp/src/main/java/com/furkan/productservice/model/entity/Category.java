package com.furkan.productservice.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category extends Base{

    @Column(name = "name", unique=true, nullable=false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

}
