package com.example.befooddelivery.service;

import com.example.befooddelivery.dto.CartDto;
import com.example.befooddelivery.dto.CartPaymentDto;
import com.example.befooddelivery.entity.Cart;
import com.example.befooddelivery.entity.CartFood;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICartService {
    List<CartDto> findAllFoodInCart(Long idCustomer);
    void updateQuantityOfFoodInCart(Long idCart);
    void createCart(Cart cart);
    Cart findCartByCustomerId(Long idCustomer);
    CartPaymentDto getTotalPay( Long idCart);
    void removeCartAfterPayment(Long idCart);

}
