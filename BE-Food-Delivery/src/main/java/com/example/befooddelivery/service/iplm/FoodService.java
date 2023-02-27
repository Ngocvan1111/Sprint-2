package com.example.befooddelivery.service.iplm;

import com.example.befooddelivery.dto.FoodItemDto;
import com.example.befooddelivery.repository.IFoodRepository;
import com.example.befooddelivery.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FoodService implements IFoodService {
    @Autowired
    IFoodRepository foodRepository;
    @Override
    public Page<FoodItemDto> findAllFood(Pageable pageable) {
        return foodRepository.findAllFood(pageable);
    }
}
