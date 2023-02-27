package com.example.befooddelivery.service;

import com.example.befooddelivery.dto.FoodItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IFoodService {
    Page<FoodItemDto> findAllFood(Pageable pageable);
}
