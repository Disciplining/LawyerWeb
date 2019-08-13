package com.hyg.controller;

import com.hyg.pojo.Carousel;
import com.hyg.pojo.Menu;
import com.hyg.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 轮播图控制器
**/
@Controller
public class CarouselController {

    @Autowired
    @Qualifier("carouselService")
    public CarouselService carouselService;
    @Value("${cbs.projectPath}")
    public String projectPath;
    @ResponseBody
    @RequestMapping("/carousel")
    public List<Carousel> findCarousel(){
    	List<Carousel> list = carouselService.findCarousel();
    	for(Carousel ca:list){
    		ca.setImgPath(projectPath.concat(ca.getImgPath()));
		}
        return list;
    }

}
