package com.example.befooddelivery.entity;

import lombok.*;

import javax.persistence.*;

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
    @OneToOne()
    @JoinColumn(name = "food_item_id",referencedColumnName = "idFood")
    private FoodItem foodItem;
    @OneToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "idCustomer")
    private Customer customer;
}
