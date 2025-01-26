package com.furkan.productservice.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.io.File;

@SuperBuilder
@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode(of = {}, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("deleted_at is null")
@SQLDelete(sql = "UPDATE products SET deleted_at = now() WHERE id = ?")

public class Product extends Base{

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "imageurl")
    private File imageUrl;

    @ManyToOne
    @JoinColumn
    private Category category;
}
