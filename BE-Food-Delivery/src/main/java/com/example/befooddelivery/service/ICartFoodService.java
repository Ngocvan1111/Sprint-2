package com.example.befooddelivery.service;

import com.example.befooddelivery.entity.CartFood;
import org.springframework.data.repository.query.Param;

public interface ICartFoodService {
    void createCartFood(Long idCart, Long idFood, int quantity);
    CartFood findCartFoodByIdFoodAndIdCart(Long idFood, Long idCart);
    void updateQuantityOfFoodIdCartFood(Long idFood,Long idCart,int quantityIncrease);
    void changeQuantityInCartFood(Long newQuantity, Long idFood, Long idCart);
    void deleteFoodInCart(Long idCart,Long idFood);

}
