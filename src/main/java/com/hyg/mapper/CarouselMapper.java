package com.hyg.mapper;


import com.hyg.pojo.Carousel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("carouselMapper")
public interface CarouselMapper {

    @Select("select * from t_carousel")
    public List<Carousel> findTopCarousel();
}
