package com.hyg.service;


import com.hyg.mapper.CarouselMapper;
import com.hyg.pojo.Carousel;
import com.hyg.util.NetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carouselService")
public class CarouselService {

    @Autowired
    @Qualifier("carouselMapper")
    private CarouselMapper carouselMapper;

    public List<Carousel> findCarousel()
	{
		List<Carousel> list = carouselMapper.findCarousel();
		for (Carousel ca : list)
		{
			ca.setImgPath( NetUtil.getPcHost().append(ca.getImgPath()).toString() );
		}

        return  list;
    }
}
