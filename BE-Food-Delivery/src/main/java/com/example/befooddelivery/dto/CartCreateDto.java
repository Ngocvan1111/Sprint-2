package com.example.befooddelivery.dto;

import com.example.befooddelivery.entity.Customer;

import java.time.LocalDate;

public class CartCreateDto {
    private Long idCart;
    private int quantity;
    private String status;
    private Long idFood;
    private Customer customer;

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getIdFood() {
        return idFood;
    }

    public void setIdFood(Long idFood) {
        this.idFood = idFood;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
