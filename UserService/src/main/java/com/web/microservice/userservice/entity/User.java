package com.web.microservice.userservice.entity;

import com.web.microservice.userservice.model.Rating;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false, length = 20)
    private String name;

    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @Column(name = "about")
    private String about;


    @Transient
    private List<Rating> ratings =new ArrayList<>();

}
