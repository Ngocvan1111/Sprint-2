package com.example.befooddelivery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;
    private int quantity;
    private String status;
//    @ManyToMany()
//    private List<Food> food;
    @OneToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "idCustomer")
    private Customer customer;
}
