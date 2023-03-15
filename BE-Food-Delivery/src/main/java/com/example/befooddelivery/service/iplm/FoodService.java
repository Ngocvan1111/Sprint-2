package com.example.befooddelivery.service.iplm;

import com.example.befooddelivery.dto.FoodDetailDto;
import com.example.befooddelivery.dto.FoodItemDto;
import com.example.befooddelivery.repository.IFoodRepository;
import com.example.befooddelivery.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService implements IFoodService {
    @Autowired
    IFoodRepository foodRepository;
    @Override
    public Page<FoodItemDto> findAllFood(String name, Pageable pageable) {
        return foodRepository.findAllFood(name,pageable);
    }

    @Override
    public FoodDetailDto findFoodByIdFood(Long idFood) {
        return foodRepository.findFoodByIdFood(idFood);
    }

    @Override
    public List<FoodItemDto> findFoodByCategory(Long idCategory) {
        return foodRepository.findFoodByCategory(idCategory);
    }

//    @Override
//    public void changeQuantityAfterPay(Long newQuantity, Long idFood) {
//        foodRepository.changeQuantityAfterPay(newQuantity, idFood);
//    }
}
