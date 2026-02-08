package com.hiber.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "mobileprogrammingstudent")
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class UserModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;

}
