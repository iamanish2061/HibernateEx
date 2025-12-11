package com.hiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

//    many to one
//    owner of mapping
    private BrandModel brand;

//     many to one
//     owner of mapping
    private CategoryModel category;

//    one to many mapping
//    owner is ImageModel
    private Set<ImageModel> images= new HashSet<>();

//    many to many
//    separate table
    private Set<TagModel> tags = new HashSet<>();


}
