package com.example.befooddelivery.controller;

import com.example.befooddelivery.dto.FoodItemDto;
import com.example.befooddelivery.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("food")
public class RestFoodController {
    @Autowired
    IFoodService foodService;


    @GetMapping("/list")
    public ResponseEntity<Page<FoodItemDto>> getAllFoods(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<FoodItemDto> listFoodDtos = foodService.findAllFood(pageable);
        if (listFoodDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listFoodDtos, HttpStatus.OK);
    }
}
