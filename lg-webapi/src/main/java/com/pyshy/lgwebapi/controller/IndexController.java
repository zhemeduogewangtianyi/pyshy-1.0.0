package com.pyshy.lgwebapi.controller;

import com.pyshy.entity.banner.BannerParam;
import com.pyshy.entity.banner.BannerVO;
import com.pyshy.service.banner.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }

    @RequestMapping("/queryBanner")
    @ResponseBody
    public List<BannerVO> getBanner(BannerParam param){
        List<BannerVO> bannerVOS = bannerService.pageQuery(param);
       return bannerVOS;
    }

}
