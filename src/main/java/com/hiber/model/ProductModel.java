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
@Table(
        name = "products",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"name", "brand_id"}
        )
)
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    json ignore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    private BrandModel brand;

//    json ignore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryModel category;

//    json ignore
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "product"
    )
    private Set<ImageModel> images= new HashSet<>();

//json ignore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}
    )
    @JoinTable(
            name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"),
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {"product_id", "tag_id"}
            )
    )
    private Set<TagModel> tags = new HashSet<>();



//    helper method for images
    public void addImage(ImageModel image){
        if(image != null){
            this.images.add(image);
            image.setProduct(this);
        }
    }

    public void removeImage(ImageModel image){
        if(image != null){
            this.images.remove(image);
            image.setProduct(null);
        }
    }

}
