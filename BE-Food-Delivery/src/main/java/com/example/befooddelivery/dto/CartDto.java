package com.example.befooddelivery.dto;

public interface CartDto {
    Long getIdFood();
    String getUrl();
    String getFoodName();
    Double getPrice();
    Integer getQuantity();

}
