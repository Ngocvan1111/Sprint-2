package com.example.befooddelivery.controller.total;

import com.example.befooddelivery.dto.FoodDetailDto;
import com.example.befooddelivery.dto.FoodItemDto;
import com.example.befooddelivery.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/public")
public class RestFoodController {
    @Autowired
    IFoodService foodService;


    @GetMapping("/list")
    public ResponseEntity<Page<FoodItemDto>> getAllFoods(@RequestParam() Optional<String> name, @PageableDefault(page = 0, size = 12) Pageable pageable) {
        String nameValue = name.orElse("");
        Page<FoodItemDto> listFoodDtos = foodService.findAllFood(nameValue,pageable);
        if (listFoodDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listFoodDtos, HttpStatus.OK);
    }
    @GetMapping("food/{idFood}")
    public ResponseEntity<FoodDetailDto> getFoodByIdFood(@PathVariable("idFood") Long idFood){
        FoodDetailDto foodItemDto = foodService.findFoodByIdFood(idFood);
        if (foodItemDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodItemDto, HttpStatus.OK);
    }
    @GetMapping("list/food/category/{idCategory}")
    public ResponseEntity<List<FoodItemDto>> getFoodByCategory(@PathVariable("idCategory") Long idCategory){
        List<FoodItemDto> foodItemDto = foodService.findFoodByCategory(idCategory);
        if (foodItemDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(foodItemDto, HttpStatus.OK);
    }
}
