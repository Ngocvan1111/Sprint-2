package com.example.befooddelivery.controller.total;

import com.example.befooddelivery.dto.CartDto;
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
}
