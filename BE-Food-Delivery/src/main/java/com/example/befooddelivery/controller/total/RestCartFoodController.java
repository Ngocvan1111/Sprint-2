package com.example.befooddelivery.controller.total;

import com.example.befooddelivery.entity.CartFood;
import com.example.befooddelivery.service.ICartFoodService;
import com.example.befooddelivery.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cart-food")
public class RestCartFoodController {
    @Autowired
    ICartFoodService cartFoodService;
    @Autowired
    ICartService cartService;
    @PatchMapping("update-quantity")
    public ResponseEntity<CartFood> changeQuantity(@RequestParam() Optional<Long> newQuantity,
                                                   @RequestParam() Optional<Long> idFood,
                                                   @RequestParam() Optional<Long> idCustomer){
            Long newQuantityValue =  newQuantity.orElse(-1l);
            Long idFoodValue =  idFood.orElse(-1l);
            Long idCustomerValue =  idCustomer.orElse(-1l);
            if(newQuantityValue != -1l && idCustomerValue != -1l && idFoodValue != -1l){
                Long idCart = cartService.findCartByCustomerId(idCustomerValue).getIdCart();
                cartFoodService.changeQuantityInCartFood(newQuantityValue,idFoodValue,idCart);
                cartService.updateQuantityOfFoodInCart(idCart);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
            }
    }
    @DeleteMapping("delete")
    public ResponseEntity<CartFood> deleteFood(@RequestParam() Optional<Long> idFood,
                                               @RequestParam() Optional<Long> idCustomer){
        Long idFoodValue =  idFood.orElse(-1l);
        Long idCustomerValue =  idCustomer.orElse(-1l);
        if( idCustomerValue != -1l && idFoodValue != -1l){
            Long idCart = cartService.findCartByCustomerId(idCustomerValue).getIdCart();
            cartFoodService.deleteFoodInCart(idCart,idFoodValue);
            cartService.updateQuantityOfFoodInCart(idCart);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
