package com.pyshy.lgmanager.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.pyshy.common.baseEnum.BizEnum;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.common.utils.UserContextHelper;
import com.pyshy.entity.userInfo.user.UserInfo;
import com.pyshy.entity.userInfo.user.UserInfoVO;
import com.pyshy.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/list");
        return mav;
    }

    @RequestMapping(value = "/pageQuery")
    @ResponseBody
    public ResponseResult pageQuery() {
        UserInfo userInfo = UserContextHelper.getUserAll();
        ResponseResult result = new ResponseResult();
        if (userInfo == null) {
            result.setCode(Integer.parseInt(BizEnum.NOT_LOGIN.getCode()));
            result.setMessage(BizEnum.NOT_LOGIN.getMessage());
            return result;
        }
        List<UserInfo> userInfos = userService.pageQuery();
        List<UserInfoVO> vos = new ArrayList<>();
        for (UserInfo u : userInfos) {
            UserInfoVO user = new UserInfoVO();
            BeanUtils.copyProperties(u, user);
            vos.add(user);
        }


        result.setRows(vos);
        result.setTotal(userService.queryCount());
        return result;
    }

    @RequestMapping(value = "/detail")
    public ModelAndView detail(Long uid) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/user_detail");
        UserInfo userInfo = userService.getUserInfoById(uid);
        mav.addObject("userInfo", userInfo);
        return mav;
    }

    @RequestMapping(value = "/openUpdate")
    public ModelAndView openUpdate(Long uid) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/update_password");
        mav.addObject("uid", uid);
        return mav;
    }

    @RequestMapping(value = "/updatePassword")
    @ResponseBody
    public ResponseResult updatePassword(Long uid, String password, String newPassword, String repeatPassword) {
        ResponseResult result = userService.updatePassword(uid, password, newPassword, repeatPassword);
        return result;
    }

    @RequestMapping(value = "/testHttpGet")
    @ResponseBody
    public void testHttpGet() {
        String key = "d351310d-f72b-46a7-a728-23f7c7a5c8d9";
        TreeMap<String, String> map = new TreeMap<String, String>();
//        String getUrl = "http://apis.yundangnet.com/api/v1/thc";
        String getUrl = "http://apis.yundangnet.com/api/v1/CustomsClearing";
        map.put("companyid", "3230");
//        map.put("companyid", "3230");
//        map.put("blno", "APLU077590666");
//        map.put("ctnrno", "SEGU5030368");
//        map.put("terminalcd", "XMNHTMT");
//        map.put("portcd", "CNXMN");
        map.put("declarationno","371120150115518667");
//        System.out.println(httpGets(getUrl, map, key));
        testHttpPost();
    }

    @RequestMapping(value = "/testHttpPost")
    @ResponseBody
    public void testHttpPost() {
        String postUrl = "http://apis.yundangnet.com/api/v1/cargotracking";
        String key = "d351310d-f72b-46a7-a728-23f7c7a5c8d9";
        TreeMap<String, Object> map = new TreeMap<String, Object>();
        JSONObject json = new JSONObject();
        json.put("carriercd", "CMA");
        json.put("blno", "OEA0137176");
        json.put("ctnrno", "");
        json.put("type", "");
        Set<Map.Entry<String, Object>> set = json.entrySet();
        for (Map.Entry<String, Object> entry : set) {
            System.out.println("\"" + entry.getKey() + "\"" + ":" + "\"" + entry.getValue() + "\"");
        }
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        jsonList.add(json);
        map.put("cargotrack", jsonList);
        TreeMap<String, String> urlMap = new TreeMap<String, String>();
        urlMap.put("companyid", "3230");

//        System.out.println(httpPosts(postUrl, urlMap, map, key));
    }

    @RequestMapping(value = "/testHttpSend/{params}")
    @ResponseBody
    public String testHttpSend(@PathVariable String params) {
            return isOk(params,true);
    }

    private static String isOk(String params,boolean isOk){
        String http = "https://"; //万维网协议头
        String method = "";//我要访问的请求路径

        int count ;

        if(!isOk){
            method = "/v1/doLogin";
            count = 0;
        }else{//获取公钥
            method = "/v1/security";
            count = 1;
        }
        String url = http + params + method;
        return get(url,params,count);
    }


    /**
     * params 请求全路径
     * path Controller带过来的网址（拼接前的参数）
     * count 控制按钮，避免递归无限循环
     * */
    private static String get(String params,String path,int count) {
        /*
         * https://www.jumoreyun.com/v1/doLogin?t=1533785042473&mobileNo=17568044787&password=1b6d649f3a1a06be7ac3fe2c1b7824caf14734d89fe3e8634375ea78d5590776bf23be76e3a9d6a875427f5ff11afcf14e2c8773ad3604a91e86e6fe7d41e557859d217ecef68847c5b9ef92067c8110db9de72f37a9eac641890f2421d2fb1f09dd5724ed6f767c1a8e844929f9163953b56ba655c927a9268a034825b89bd3&rememberMe=true&bizcode=1004
         * */
        try {
            String pass = "7e6e8e871a0710cc09a4f18a5f15b84f762893f4b5c8fe77a491646a7a5f8f72b9939bda691625f05cef587d2006e46b2dddbf2e3c7ca4a807fcc602aa62a17b3761fa06297db3cbd795a1eeb05442ac1c44c1d6bac1d9a9ca5f58c46ca02d60d8d4f3bc1d09b8f606d9b717556f90b1c4cac8002d864a4f25a8fa9c6375839c";
            String t = System.currentTimeMillis()+"";
//            RSAPrivateKey privateKey = 123;

            String p = "123123";
            String param = params+"?t="+t+"&mobileNo=17568044787&password="+pass+"&rememberMe=true&bizcode=1004";
            String param1 = params+"?t="+t;
            String str = "";
            if(count == 0){
                str = param;
            }else{
                str = param1;
            }
            URL url = new URL(str);
            //
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Cookie","Hm_lvt_b88e33945f05dd89378617d927b5a6c7=1531376797,1532074376,1532936553; shiroJID=cb10b54d-bbd7-49a7-863c-379d76ee4c2c");
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(true);

            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int len = 0;
                byte[] data = new byte[1024];
                while ((len = is.read(data)) != -1) {
                    baos.write(data, 0, len);
                    baos.flush();
                    baos.close();
                }
                System.out.println(baos.toString("utf-8"));

                if(count == 1)
                    isOk(path, false);
                String row = baos.toString("utf-8");
                return row;
            }else{
                throw new RuntimeException("链接失败！");
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }


//    private static String URLSend(String u,String method){
//        String protocol = "";
//        String host = "";
//        int poty = 0;
//        String path = "";
//        String file = "";
//        String ref = "";
//        String query = "";
//        try{
//            URL baidu =new URL(u);
//            URL url =new URL(baidu,method);//？表示参数，#表示锚点
//            protocol = url.getProtocol();//获取协议
//            host = url.getHost();//获取主机
//            poty = url.getPort();//如果没有指定端口号，根据协议不同使用默认端口。此时getPort()方法的返回值为 -1
//            path = url.getPath();//获取文件路径
//            file = url.getFile();//文件名，包括文件路径+参数
//            ref = url.getRef();//相对路径，就是锚点，即#号后面的内容
//            query = url.getQuery();//查询字符串，即参数
//        }catch(Exception ex){
//            return "ERROR";
//        }
//
//        return "SUCCESS -> PROTOCOL=" + protocol + " HOST=" + host + " POTY=" + poty + " PATH=" + path + " FILE=" + file + " REF=" + ref + " QUERY=" + query;
//    }

}
