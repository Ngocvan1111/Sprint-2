package com.example.befooddelivery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrigin;
    private String name;
    @OneToMany(mappedBy = "origin")
    Set<Food> foodSet;
}
