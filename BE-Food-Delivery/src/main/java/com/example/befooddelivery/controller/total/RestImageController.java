package com.example.befooddelivery.controller.total;

import com.example.befooddelivery.dto.ImageDto;
import com.example.befooddelivery.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/image")
public class RestImageController {
    @Autowired
    IImageService imageService;
    @GetMapping("/food/{id}")
    public ResponseEntity<List<ImageDto>>getAllImageByFoodId(@PathVariable("id") Long id){
        List<ImageDto> imageDtoList = imageService.findAllImageByFoodId(id);
        if(imageDtoList == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(imageDtoList, HttpStatus.OK);
        }
    }
}
