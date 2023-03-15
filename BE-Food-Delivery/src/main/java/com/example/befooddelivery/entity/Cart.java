package com.example.befooddelivery.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate createDate = LocalDate.now();
    private LocalDate updateDate = LocalDate.now();
    private boolean flagPayment = false;
//    @ManyToMany()
//    private List<Food> food;
    @OneToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "idCustomer")
    private Customer customer;
}
