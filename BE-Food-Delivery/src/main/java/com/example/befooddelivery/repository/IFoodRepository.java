package com.example.befooddelivery.repository;

import com.example.befooddelivery.dto.FoodItemDto;
import com.example.befooddelivery.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFoodRepository extends JpaRepository<Food, Long> {
    @Query (value = "select f.id_food as idFood, f.name as name, f.price as price, f.compare_price as comparePrice, i.url as url from sprint_2.food f join image as i on  f.id_food = i.food_id group by i.food_id order by f.created_date desc ", nativeQuery = true,
            countQuery = "select f.id_food as idFood, f.name as name, f.price as price, f.compare_price as comparePrice, i.url as url from sprint_2.food f join image as i on  f.id_food = i.food_id group by i.food_id order by f.created_date desc ")
    Page<FoodItemDto> findAllFood(Pageable pageable);
}
