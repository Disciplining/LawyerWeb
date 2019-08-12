package com.hyg.service;

import com.hyg.mapper.CarouselMapper;
import com.hyg.pojo.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carouselService")
public class CarouselServiceImpl extends CarouselService {

    @Autowired
    @Qualifier("deleteMapper")
    private CarouselMapper carouselMapper;

    @Override
    public List<Carousel> findTopCarousel()
    {
        return carouselMapper.findTopCarousel();
    }

}

