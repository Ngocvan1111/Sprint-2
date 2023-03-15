package com.example.befooddelivery.dto;

public interface FoodItemDto {
    Long getIdFood();
    String getCode();
    String getDescription();
    String getName();

    Double getPrice();

    Double getComparePrice();

    String getUrl();
}
