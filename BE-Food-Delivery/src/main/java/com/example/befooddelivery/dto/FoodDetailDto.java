package com.example.befooddelivery.dto;

public interface FoodDetailDto {
    Long getIdFood();
    String getCode();
    String getDescription();
    String getName();
    Double getPrice();
    Double getComparePrice();
    Long getQuantity();
    String getOrigin();
    Long getIdCategory();
}
