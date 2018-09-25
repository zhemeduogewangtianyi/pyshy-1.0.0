package com.pyshy.common.utils;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class PathModel {

    public static ModelAndView getPath(ModelAndView modelAndView,HttpServletRequest request){
        if(modelAndView==null){
            return null;
        }
        String schema=request.getScheme();
        String serverName=request.getServerName();
        String port=request.getServerPort()+"";
        String appName=request.getContextPath();
        String appPath= schema+"://"+serverName+":"+port+appName;
        modelAndView.addObject("appPath", appPath);
        modelAndView.addObject("appName", appName);
        modelAndView.addObject("request", request);
        modelAndView.addObject("serverMS", System.currentTimeMillis());
        return modelAndView;
    }

}
