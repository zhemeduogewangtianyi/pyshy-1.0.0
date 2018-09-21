package com.pyshy.lgmanager.service.login;


import com.pyshy.entity.userInfo.user.UserInfo;

public interface UserInfoService {

    //通过用户名查询用户信息
    public UserInfo findByUsername(String username);

}
