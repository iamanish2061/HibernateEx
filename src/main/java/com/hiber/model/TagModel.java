package com.hiber.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tags")
public class TagModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

//    many to many relation
//    separate table
    private Set<Products> products = new HashSet<>();

}
