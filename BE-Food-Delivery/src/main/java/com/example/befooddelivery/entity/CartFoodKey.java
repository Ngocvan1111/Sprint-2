package com.example.befooddelivery.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CartFoodKey implements Serializable {
    @Column(name = "id_cart")
    Long idCard;
    @Column(name = "id_food")
    Long idFood;
}
