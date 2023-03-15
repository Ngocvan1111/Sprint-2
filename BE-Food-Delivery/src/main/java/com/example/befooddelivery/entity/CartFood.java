package com.example.befooddelivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart_food")
public class CartFood {

    @EmbeddedId
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean flagDelete = false;
}
