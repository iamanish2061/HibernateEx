package com.hiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
@Data
public class BrandModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;


//    one to many mapping
//    owner (mapped by products)
    Set<Products> products = new HashSet<>();


}
