package com.hiber.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@NamedEntityGraph(
        name = "productWithImages",
        attributeNodes = @NamedAttributeNode("images")
)
@NamedEntityGraph(
        name = "productsWithBrand",
        attributeNodes = {
                @NamedAttributeNode("brand"),
                @NamedAttributeNode("images")
        }
)
@NamedEntityGraph(
        name = "productsWithCategory",
        attributeNodes = {
                @NamedAttributeNode("category"),
                @NamedAttributeNode("images")
        }
)
@NamedEntityGraph(
        name = "productWithTags",
        attributeNodes = {
                @NamedAttributeNode("tags"),
                @NamedAttributeNode("images")
        }
)
@NamedEntityGraph(
        name = "productDetails",
        attributeNodes = {
                @NamedAttributeNode("brand"),
                @NamedAttributeNode("category"),
                @NamedAttributeNode("tags"),
                @NamedAttributeNode("images")
        }
)

@Builder
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
            cascade = CascadeType.MERGE
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
