package com.pyshy.common.utils;


import com.pyshy.entity.userInfo.user.UserInfo;

public class UserContextHelper {

    /**
     * 存放当前线程的用户ID
     * */
    private static ThreadLocal<UserInfo> USER_INFO = new ThreadLocal<>();

    /**
     * 获得当前用户账号
     * */
    public static String getUserName(){
        UserInfo user = USER_INFO.get();
        return user == null ? null : user.getUsername();
    }

    /**
     * 获得当前用户真实名称
     * */
    public static String getRealName(){
        UserInfo user = USER_INFO.get();
        return user == null ? null : user.getName();
    }

    /**
     * 获取用户所有信息
     * */
    public static UserInfo getUserAll(){
        UserInfo user = USER_INFO.get();
        return user;
    }

    /**
     * 设置用户信息
     * */
    public static void setUserInfo(UserInfo userInfo){
        USER_INFO.set(userInfo);
    }

    /**
     * 删除用户信息
     * */
    public static void remove(){
        USER_INFO.remove();
    }

}
