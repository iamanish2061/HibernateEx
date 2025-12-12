package com.hiber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "brand")
public class BrandModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


//    json ignore
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "brand"
    )
    Set<ProductModel> products = new HashSet<>();


//    helper methods
    public void addProduct(ProductModel productModel){
        if(productModel != null){
            this.products.add(productModel);
            productModel.setBrand(this);
        }
    }

    public void removeProduct(ProductModel productModel){
        if(productModel != null){
            this.products.remove(productModel);
            productModel.setBrand(null);
        }
    }

}
