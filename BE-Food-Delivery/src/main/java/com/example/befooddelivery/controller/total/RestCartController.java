package com.example.befooddelivery.controller.total;

import com.example.befooddelivery.dto.CartCreateDto;
import com.example.befooddelivery.dto.CartDto;
import com.example.befooddelivery.dto.CartPaymentDto;
import com.example.befooddelivery.entity.Cart;
import com.example.befooddelivery.entity.CartFood;
import com.example.befooddelivery.service.ICartFoodService;
import com.example.befooddelivery.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/cart")
public class RestCartController {
    @Autowired
    ICartService cartService;
    @Autowired
    ICartFoodService cartFoodService;

    @GetMapping("/list/{idCustomer}")
    public ResponseEntity<List<CartDto>> getAllFoodInCart(@PathVariable("idCustomer") Long idCustomer){
        List<CartDto> cartDtoList = cartService.findAllFoodInCart(idCustomer);
        if(cartDtoList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(cartDtoList, HttpStatus.OK);
        }
    }
    @PostMapping("update/quantity")
    public ResponseEntity<CartFood>updatequantity(@RequestBody CartCreateDto cartCreateDto){
        Long idCustomer = cartCreateDto.getCustomer().getIdCustomer();
        Long idFood = cartCreateDto.getIdFood();
        int quantityIncrease = cartCreateDto.getQuantity();
        Cart cartCheck = cartService.findCartByCustomerId(idCustomer);

        if(cartCheck == null){
            try {
                Cart cart = new Cart();
                cart.setQuantity(cartCreateDto.getQuantity());
                cart.setStatus(cartCreateDto.getStatus());
                cart.setCustomer(cartCreateDto.getCustomer());


                cartService.createCart(cart);
                Thread.sleep(3000L);
                Cart cart1 = cartService.findCartByCustomerId(idCustomer);
                Long idCart = cart1.getIdCart();
                cartFoodService.createCartFood(idCart, idFood, quantityIncrease);
                return new ResponseEntity<>(HttpStatus.OK);
            }catch (IllegalArgumentException | InterruptedException e){
                System.out.println((e.getMessage()));
                return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
            }

        }
        else {
            Long idCart = cartCheck.getIdCart();
            CartFood cartFoodCheck = cartFoodService.findCartFoodByIdFoodAndIdCart(idFood, idCart);
            if(cartFoodCheck != null){
                    cartFoodService.updateQuantityOfFoodIdCartFood(idFood, idCart,quantityIncrease);
                    synchronized (this){
                        cartService.updateQuantityOfFoodInCart(idCart);
                    }
                    return new ResponseEntity<>(HttpStatus.OK);
            }
            else {
                cartFoodService.createCartFood(idCart, idFood, quantityIncrease);

                    cartService.updateQuantityOfFoodInCart(idCart);

                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
    }
    @GetMapping("get/cart/{idCustomer}")
    public ResponseEntity<Cart> getCartByCustomerId(@PathVariable("idCustomer") Long idCustomer){
        Cart cart = cartService.findCartByCustomerId(idCustomer);
        if(cart == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(cart,HttpStatus.OK);
        }
    }
    @GetMapping("/get/total-pay/{idCart}")
    public  ResponseEntity<CartPaymentDto> getTotalPay(@PathVariable("idCart") Long idCart){
        Long idCustomer = cartService.findCartByCustomerId(idCart).getIdCart();
        CartPaymentDto cartPaymentDto = cartService.getTotalPay(idCustomer);

        if(cartPaymentDto == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(cartPaymentDto,HttpStatus.OK);
        }
    }
    @PatchMapping("update-cart-after-pay/{idCustomer}")
    public ResponseEntity<Cart> updateCartAfterPay(@PathVariable("idCustomer") Long idCustomer){
        Long idCart = cartService.findCartByCustomerId(idCustomer).getIdCart();
        cartService.removeCartAfterPayment(idCart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
