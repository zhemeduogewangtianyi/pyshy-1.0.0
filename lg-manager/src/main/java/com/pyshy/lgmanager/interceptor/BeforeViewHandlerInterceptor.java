package com.pyshy.lgmanager.interceptor;

import com.pyshy.common.utils.PathModel;
import com.pyshy.common.utils.UserContextHelper;
import com.pyshy.entity.userInfo.user.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
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
        try{
            Session session = SecurityUtils.getSubject().getSession();
            String menu = (String)session.getAttribute("menu");

            Subject subject = SecurityUtils.getSubject();
            UserInfo userInfo = (UserInfo)subject.getPrincipal();
            if(userInfo != null){
                UserContextHelper.setUserInfo(userInfo);
            }
            if(subject != null){
                String uri = request.getRequestURI();
                if(uri.indexOf("list") != -1){
                    session.setAttribute("menu",uri);
                }
                if(uri.equals("/lgmanager/login")){
                    subject.logout();
                }
            }
        }catch (Exception ex){

        }
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //所谓返回ModelAndView 之后清理工作
        UserContextHelper.remove();
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
