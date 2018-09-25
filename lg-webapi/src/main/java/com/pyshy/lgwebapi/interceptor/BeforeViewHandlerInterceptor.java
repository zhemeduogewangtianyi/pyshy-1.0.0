package com.pyshy.lgwebapi.interceptor;

import com.pyshy.common.utils.PathModel;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class BeforeViewHandlerInterceptor extends HandlerInterceptorAdapter {


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView = PathModel.getPath(modelAndView,request);
        if(modelAndView==null){
            return;
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }

    protected boolean isIncludeRequest(final HttpServletRequest request)
    {
        return request.getAttribute("javax.servlet.include.request_uri") != null;
    }

    protected boolean isSupportedView(final ModelAndView modelAndView)
    {
        return modelAndView.getViewName() != null && !isRedirectView(modelAndView);
    }

    protected boolean isRedirectView(final ModelAndView modelAndView)
    {
        final String viewName = modelAndView.getViewName();
        return viewName != null && viewName.startsWith("redirect:");
    }
}
