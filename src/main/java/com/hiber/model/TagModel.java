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
        name = "tags"
)
public class TagModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    //    json ignore
    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private Set<ProductModel> products = new HashSet<>();

}
