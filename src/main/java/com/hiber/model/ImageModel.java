package com.hiber.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_images")
public class ImageModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String alt;

    private String url;

//    many to one
//    owner self
    private Products product;
}
