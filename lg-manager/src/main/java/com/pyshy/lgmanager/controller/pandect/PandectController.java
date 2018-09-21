package com.pyshy.lgmanager.controller.pandect;

import com.pyshy.entity.picture.PictureParam;
import com.pyshy.entity.test.TestParam;
import com.pyshy.service.picture.PictureService;

import com.pyshy.service.test.TestService;
import com.pyshy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/pandect")
public class PandectController {

    @Autowired
    private UserService userService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/list")
    public ModelAndView list(){

        ModelAndView mav = new ModelAndView();
        mav.setViewName("/pandect/list");
        Integer userCount = userService.queryCount();
        Integer pictureCount = pictureService.queryCount(new PictureParam());
        Integer testCount = testService.queryCount(new TestParam());

        mav.addObject("user","用户管理");
        mav.addObject("userCount",userCount);

        mav.addObject("picture","图片管理");
        mav.addObject("pictureCount",pictureCount);

        mav.addObject("test","测试管理");
        mav.addObject("testCount",testCount);

        return mav;
    }

}
