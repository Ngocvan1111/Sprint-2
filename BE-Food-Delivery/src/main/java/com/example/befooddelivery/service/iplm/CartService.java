package com.example.befooddelivery.service.iplm;

import com.example.befooddelivery.dto.CartDto;
import com.example.befooddelivery.dto.CartPaymentDto;
import com.example.befooddelivery.entity.Cart;
import com.example.befooddelivery.entity.CartFood;
import com.example.befooddelivery.repository.ICartRepository;
import com.example.befooddelivery.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository cartRepository;
    @Override
    public List<CartDto> findAllFoodInCart(Long idCustomer) {
        return cartRepository.findAllFoodInCart(idCustomer);
    }

    @Override
    public void updateQuantityOfFoodInCart( Long idCart) {
        cartRepository.updateQuantityOfFoodInCart(idCart);

    }

    @Override
    public void createCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Cart findCartByCustomerId(Long idCustomer) {
        return cartRepository.findCartByCustomerId(idCustomer);
    }

    @Override
    public CartPaymentDto getTotalPay(Long idCart) {
        return cartRepository.getTotalPay(idCart);
    }

    @Override
    public void removeCartAfterPayment(Long idCart) {
         cartRepository.removeCartAfterPayment(idCart);
    }


}
