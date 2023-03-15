package com.example.befooddelivery.service;

import com.example.befooddelivery.dto.FoodDetailDto;
import com.example.befooddelivery.dto.FoodItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFoodService {
    Page<FoodItemDto> findAllFood(String name,Pageable pageable);
    FoodDetailDto findFoodByIdFood(Long idFood);
    List<FoodItemDto> findFoodByCategory(Long idCategory);
//    void changeQuantityAfterPay( Long newQuantity, Long idFood);
}
