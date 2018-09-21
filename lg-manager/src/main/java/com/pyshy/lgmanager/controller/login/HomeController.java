package com.pyshy.lgmanager.controller.login;

import com.pyshy.entity.userInfo.user.UserInfo;
import com.pyshy.lgmanager.service.login.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/lgmanager")
public class HomeController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/index");

        return mav;
    }

    @RequestMapping(value = "/login",method = {RequestMethod.POST, RequestMethod.GET})
    public String login(HttpServletRequest request, Model map, String username){
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");

        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "账号不存在";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "密码不正确";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "验证码错误";
            } else {
//                msg = "else >> "+exception;
                msg = "账号或密码不正确";
                System.out.println("else -- >" + exception);
            }
        }
        map.addAttribute("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.

        Map<String,UserInfo> userMap = new HashMap<String,UserInfo>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("superadmin");
        userInfo.setPassword("123123");
        userInfo.setName("超级管理员");
            //使用Map模拟数据库获取User表信息
            userMap.put("admin", userInfo);

        String cipherText_md5= new SimpleHash("MD5",userInfo.getPassword(), ByteSource.Util.bytes(userInfo.getUsername()+"8d78869f470951332959580424d4bf4f"),2).toHex();
            System.out.println(cipherText_md5);


        return "/login/login";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "lgmanager/login/login";
    }

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @ResponseBody
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    @ResponseBody
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    @ResponseBody
    public String userDel(){
        return "userInfoDel";
    }


}
