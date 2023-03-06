package com.example.befooddelivery.service.iplm;

import com.example.befooddelivery.dto.CartDto;
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
}
