package com.example.befooddelivery.service;

import com.example.befooddelivery.dto.ImageDto;

import java.util.List;

public interface IImageService {
    List<ImageDto> findAllImageByFoodId(Long idFood);
}
