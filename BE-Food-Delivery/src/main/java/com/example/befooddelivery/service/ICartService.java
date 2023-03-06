package com.example.befooddelivery.service;

import com.example.befooddelivery.dto.CartDto;

import java.util.List;

public interface ICartService {
    List<CartDto> findAllFoodInCart(Long idCustomer);
}
