package com.example.befooddelivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "cart_food")
public class CartFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EmbeddedId
    private CartFoodKey id;
    @ManyToOne
    @MapsId("id_cart")
    @JoinColumn(name = "id_cart")
    private Cart cart;
    @ManyToOne
    @MapsId("id_food")
    @JoinColumn(name = "id_food")
    private Food food;
    private int quantity;

}
