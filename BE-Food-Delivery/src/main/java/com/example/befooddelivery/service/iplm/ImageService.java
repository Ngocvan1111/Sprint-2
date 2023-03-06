package com.example.befooddelivery.service.iplm;

import com.example.befooddelivery.dto.ImageDto;
import com.example.befooddelivery.repository.IImageRepository;
import com.example.befooddelivery.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService {
    @Autowired
    IImageRepository imageRepository;

    @Override
    public List<ImageDto> findAllImageByFoodId(Long idFood) {
        return imageRepository.findAllImageByFoodId(idFood);
    }
}
