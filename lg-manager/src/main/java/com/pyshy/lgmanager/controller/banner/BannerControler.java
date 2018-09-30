package com.pyshy.lgmanager.controller.banner;

import com.alibaba.fastjson.JSONObject;
import com.pyshy.common.baseEnum.BizEnum;
import com.pyshy.common.baseEnum.CommonEnum;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.entity.banner.BannerAddParam;
import com.pyshy.entity.banner.BannerParam;
import com.pyshy.entity.banner.BannerVO;
import com.pyshy.service.banner.BannerService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        mav.setViewName("/banner/banner_detail");
        vo.setPicture(null);
        mav.addObject("vo",vo);
        return mav;
    }

    @RequestMapping(value = "queryImage")
    @ResponseBody
    public byte[] queryImage(Long id){
        BannerVO vo = service.bannerDetail(id);
        return Base64.encodeBase64(vo.getPicture());
    }

    @RequestMapping(value = "/openAdd")
    public ModelAndView openAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/banner/banner_add");
        return mav;
    }

    @RequestMapping(value = "/openUpdate")
    public ModelAndView openUpdate(Long id){
        ModelAndView mav = new ModelAndView();
        BannerVO vo = service.bannerDetail(id);
        mav.setViewName("/banner/banner_add");
        mav.addObject("vo",vo);
        return mav;
    }

    @RequestMapping(value = "/save")
    @ResponseBody
    public ResponseResult upload(@RequestParam("file") MultipartFile file, @RequestParam("param") String param){

        JSONObject json = JSONObject.parseObject(param);
        BannerAddParam bannerAddParam = json.toJavaObject(BannerAddParam.class);

        ResponseResult result = service.addBanner(file,bannerAddParam);
        return result;
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public ResponseResult deleteBanner(Long id){
        service.bannerDelete(id);
        ResponseResult responseResult = new ResponseResult();
        responseResult.setMessage(BizEnum.SUCCESS.getMessage());
        responseResult.setCode(CommonEnum.INT_200.getCode());
        return responseResult;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public ResponseResult updateBanner(@RequestParam("param") String param,HttpServletRequest request){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        JSONObject json = JSONObject.parseObject(param);
        BannerAddParam bannerAddParam = json.toJavaObject(BannerAddParam.class);
        ResponseResult responseResult = service.updateBanner(file, bannerAddParam);
        return responseResult;
    }
}

