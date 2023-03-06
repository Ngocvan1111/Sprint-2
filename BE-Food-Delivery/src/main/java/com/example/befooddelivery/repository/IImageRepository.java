package com.example.befooddelivery.repository;

import com.example.befooddelivery.dto.ImageDto;
import com.example.befooddelivery.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IImageRepository extends JpaRepository<Image, Long> {
    @Query (value = "select i.id_image as idImage, i.url as url from image i where i.food_id = :idFood", nativeQuery = true)
    List<ImageDto> findAllImageByFoodId(@Param("idFood") Long idFood);
}
