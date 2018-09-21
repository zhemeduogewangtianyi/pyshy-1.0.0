package com.pyshy.service.user;

import com.pyshy.entity.userInfo.user.UserInfo;
import com.pyshy.common.responseResult.ResponseResult;

import java.util.List;

public interface UserService {


    public List<UserInfo> pageQuery();

    public Integer queryCount();

    public UserInfo getUserInfoById(Long id);

    public ResponseResult updatePassword(Long uid, String password, String newPassword, String repeatPassword);

}
