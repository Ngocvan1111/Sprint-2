package com.example.befooddelivery.repository;

import com.example.befooddelivery.dto.FoodDetailDto;
import com.example.befooddelivery.dto.FoodItemDto;
import com.example.befooddelivery.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IFoodRepository extends JpaRepository<Food, Long> {
    @Query (value = "select f.id_food as idFood,f.code as code, f.description as description, f.name as name, f.price as price, f.compare_price as comparePrice, i.url as url from sprint_2.food f\n" +
            "    join image as i on  f.id_food = i.food_id join category c on c.id_category = f.category_id where f.name like concat('%',:name, '%') or c.name like concat('%',:name, '%')  group by i.food_id order by f.created_date desc ", nativeQuery = true,
            countQuery = "select f.id_food as idFood,f.code as code, f.description as description, f.name as name, f.price as price, f.compare_price as comparePrice, i.url as url from sprint_2.food f\n" +
                    "    join image as i on  f.id_food = i.food_id join category c on c.id_category = f.category_id where f.name like concat('%',:name, '%') or c.name like concat('%',:name, '%')  group by i.food_id order by f.created_date desc ")
    Page<FoodItemDto> findAllFood(@Param("name") String name ,Pageable pageable);
    @Query (value = "select f.id_food as idFood,f.code as code, f.description as description, f.name as name, f.price as price, f.compare_price as comparePrice, f.quantity as quantity,o.name as origin, f.category_id as idCategory  from sprint_2.food f join image as i on  f.id_food = i.food_id join origin as o on f.origin_id = o.id_origin where f.id_food = :idFood group by i.food_id",nativeQuery = true)
    FoodDetailDto findFoodByIdFood(@Param("idFood") Long idFood);
    @Query (value = "select f.id_food as idFood,f.code as code, f.description as description, f.name as name, f.price as price, f.compare_price as comparePrice, i.url as url from sprint_2.food f join image as i on  f.id_food = i.food_id where f.category_id = :idCategory group by i.food_id",nativeQuery = true)
    List<FoodItemDto>  findFoodByCategory(@Param("idCategory") Long idCategory);
//    @Transactional
//    @Modifying
//    @Query( value = "update food as f set f.quantity = :newQuantity where f.id_food =: idFood",nativeQuery = true)
//    void changeQuantityAfterPay(@Param("newQuantity") Long newQuantity, @Param("idFood") Long idFood);
}
