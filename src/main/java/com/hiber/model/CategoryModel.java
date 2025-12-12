package com.hiber.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "category")
public class CategoryModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "category",
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
//    json ignore
    private Set<ProductModel> products = new HashSet<>();

//    helper methods
    public void addProduct(ProductModel productModel){
        if(productModel != null){
            this.products.add(productModel);
            productModel.setCategory(this);
        }
    }

    public void removeProduct(ProductModel productModel){
        if(productModel != null){
            this.products.remove(productModel);
            productModel.setCategory(null);
        }
    }

}
