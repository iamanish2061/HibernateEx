package com.hiber.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(
        name = "product_images",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"alt", "url"}
        )
)
public class ImageModel {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String alt;

    private String url;
    private boolean thumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductModel product;
}
