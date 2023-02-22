package com.example.befooddelivery.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrders;
    private LocalDate orderDate = LocalDate.now();
    private Boolean status;
    private int amount;
    @OneToMany(mappedBy = "order")
    private Set<FoodItem> foodItemSet;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "idCustomer")
    private Customer customer;
}
