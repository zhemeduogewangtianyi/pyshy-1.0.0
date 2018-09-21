package com.pyshy.lgmanager.controller.index;

import com.pyshy.common.utils.UserContextHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {

    @RequestMapping("/")
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("/index");

        Session session = SecurityUtils.getSubject().getSession();
        String uri = (String) session.getAttribute("menu");

        mav.addObject("menu", uri);
        mav.addObject("realname", UserContextHelper.getRealName());
        return mav;
    }
}


