package com.hyg.service;


import com.hyg.mapper.CarouselMapper;
import com.hyg.pojo.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carouselService")
public class CarouselService {

    @Autowired
    @Qualifier("carouselMapper")
    private CarouselMapper carouselMapper;

    public List<Carousel> findCarousel(){
        return  carouselMapper.findCarousel();
    }
}
