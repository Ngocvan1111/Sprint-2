package com.example.befooddelivery.service.iplm;

import com.example.befooddelivery.entity.CartFood;
import com.example.befooddelivery.repository.ICartFoodRepository;
import com.example.befooddelivery.service.ICartFoodService;
import com.example.befooddelivery.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartFoodService implements ICartFoodService {
    @Autowired
    ICartFoodRepository cartFoodRepository;


    @Override
    public void createCartFood(Long idCart, Long idFood, int quantity) {
        cartFoodRepository.createCartFood(idCart, idFood, quantity);

    }

    @Override
    public CartFood findCartFoodByIdFoodAndIdCart(Long idFood, Long idCart) {
        return cartFoodRepository.findCartFoodByIdFoodAndIdCart(idFood, idCart);
    }

    @Override
    public void updateQuantityOfFoodIdCartFood(Long idFood, Long idCart, int quantityIncrease) {
         cartFoodRepository.updateQuantityOfFoodIdCartFood(idFood,idCart,quantityIncrease);
    }

    @Override
    public void changeQuantityInCartFood(Long newQuantity, Long idFood, Long idCart) {
        cartFoodRepository.changeQuantityInCartFood(newQuantity,idFood,idCart);
    }

    @Override
    public void deleteFoodInCart(Long idCart, Long idFood) {
        cartFoodRepository.deleteFoodInCart(idCart, idFood);
    }
}
