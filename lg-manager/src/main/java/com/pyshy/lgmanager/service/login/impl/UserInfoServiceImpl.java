package com.pyshy.lgmanager.service.login.impl;

import com.pyshy.entity.userInfo.user.UserInfo;
import com.pyshy.lgmanager.service.login.UserInfoService;
import com.pyshy.lgmanager.shiro.userInfoRepository.UserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }
}
