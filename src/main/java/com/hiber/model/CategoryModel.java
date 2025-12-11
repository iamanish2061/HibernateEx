package com.hiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
public class CategoryModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

//    one to many
//    owner products, mapped by products
    private Set<Products> products = new HashSet<>();

}
