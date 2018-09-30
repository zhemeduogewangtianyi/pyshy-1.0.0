package com.pyshy.lgmanager.controller.banner;

import com.alibaba.fastjson.JSONObject;
import com.pyshy.common.baseEnum.CommonEnum;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.entity.banner.BannerAddParam;
import com.pyshy.entity.banner.BannerPO;
import com.pyshy.entity.banner.BannerParam;
import com.pyshy.entity.banner.BannerVO;
import com.pyshy.entity.picture.PictureVO;
import com.pyshy.service.banner.BannerService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(value = "/banner")
public class BannerControler {

    @Autowired
    private BannerService service;

    @RequestMapping(value = "/list")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/banner/banner_list");
        return mav;
    }

    @RequestMapping(value = "/pageQuery")
    @ResponseBody
    public ResponseResult pageQuery(BannerParam param,HttpServletResponse response){
        List<BannerVO> bannerVOS = service.pageQuery(param);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setRows(bannerVOS);
        responseResult.setTotal(service.queryCount(param));
        return responseResult;
    }

    @RequestMapping(value = "/detail")
    public ModelAndView detail(Long id){
        ModelAndView mav = new ModelAndView();
        BannerVO vo = service.bannerDetail(id);
        mav.setViewName("/picture/detail");
        mav.addObject("vo",vo);
        return mav;
    }

    @RequestMapping(value = "/openAdd")
    public ModelAndView openAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/banner/banner_add");
        return mav;
    }

    @RequestMapping(value = "/save")
    public ResponseResult upload(@RequestParam("file") MultipartFile file, @RequestParam("param") String param){

        JSONObject json = JSONObject.parseObject(param);
        BannerAddParam bannerAddParam = json.toJavaObject(BannerAddParam.class);

        ResponseResult result = service.addBanner(file,bannerAddParam);
        return result;
    }
}

