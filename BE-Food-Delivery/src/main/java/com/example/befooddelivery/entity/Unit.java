package com.example.befooddelivery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnit;
    private String name;
    @OneToMany(mappedBy = "unit")
    private List<Food> foodItemList;
}