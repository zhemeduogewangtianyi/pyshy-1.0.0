package com.pyshy.service.user.impl;

import com.pyshy.common.baseEnum.BizEnum;
import com.pyshy.common.baseEnum.CommonEnum;
import com.pyshy.entity.userInfo.user.UserInfo;
import com.pyshy.common.utils.UserContextHelper;
import com.pyshy.dao.user.UserMapper;
import com.pyshy.common.responseResult.ResponseResult;
import com.pyshy.service.user.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public List<UserInfo> pageQuery() {
        List<UserInfo> userInfoVOS = userMapper.pageQuery();
        return userInfoVOS;
    }

    @Override
    public Integer queryCount() {
        return userMapper.queryCount();
    }

    @Override
    public UserInfo getUserInfoById(Long id) {
        UserInfo userById = userMapper.getUserById(id);
        return userById;
    }

    @Override
    public ResponseResult updatePassword(Long uid, String password, String newPassword, String repeatPassword) {
        return checkeUpdatePassword(uid,password,newPassword,repeatPassword);
    }

    private ResponseResult checkeUpdatePassword(Long uid, String password, String newPassword, String repeatPassword){
        ResponseResult result = new ResponseResult();

        if(uid == null){
            result.setCode(Integer.parseInt(BizEnum.USER_NOT_ID.getCode()));
            result.setMessage(BizEnum.USER_NOT_ID.getMessage());
            return result;
        }
        if(StringUtils.isEmpty(password)){
            result.setCode(Integer.parseInt(BizEnum.USER_PASSWORD_NOT_NULL.getCode()));
            result.setMessage(BizEnum.USER_PASSWORD_NOT_NULL.getMessage());
            return result;
        }
        if(password.length() < CommonEnum.INT_6.getCode()){
            result.setCode(Integer.parseInt(BizEnum.PASSWORD_LENGT_THAN_6.getCode()));
            result.setMessage(BizEnum.PASSWORD_LENGT_THAN_6.getMessage());
            return result;
        }
        UserInfo userInfo = getUserInfoById(uid);
        String cipherText_md5= new SimpleHash("MD5",password, ByteSource.Util.bytes(userInfo.getUsername()+"8d78869f470951332959580424d4bf4f"),2).toHex();
        if(!cipherText_md5.equals(userInfo.getPassword())){
            result.setCode(Integer.parseInt(BizEnum.OLD_PASSWORD_ERROR.getCode()));
            result.setMessage(BizEnum.OLD_PASSWORD_ERROR.getMessage());
            return result;
        }
        String update_md5 = new SimpleHash("MD5",newPassword, ByteSource.Util.bytes(userInfo.getUsername()+"8d78869f470951332959580424d4bf4f"),2).toHex();
        UserInfo user = new UserInfo();
        user.setUid(uid);
        user.setPassword(update_md5);
        user.setSalt(CommonEnum.STRING_SALT.getRow());
        user.setUsername(userInfo.getUsername());
        user.setName(userInfo.getName());
        user.setState(CommonEnum.INT_0.getCode());
        user.setUpdateName(UserContextHelper.getRealName());
        user.setUpdateTime(new Date());
        if(user.getUsername().equals(CommonEnum.STRING_USERNAME.getRow())){
            result.setCode(Integer.parseInt(BizEnum.ADMIN_NOT_UPDATE.getCode()));
            result.setMessage(BizEnum.ADMIN_NOT_UPDATE.getMessage());
            return result;
        }
        if(StringUtils.isEmpty(newPassword)){
            result.setCode(Integer.parseInt(BizEnum.USER_NEW_PASSWORD_NOT_NULL.getCode()));
            result.setMessage(BizEnum.USER_NEW_PASSWORD_NOT_NULL.getMessage());
            return result;
        }
        if(StringUtils.isEmpty(repeatPassword)){
            result.setCode(Integer.parseInt(BizEnum.REPEAT_PASSWOR_NOT_NULL.getCode()));
            result.setMessage(BizEnum.REPEAT_PASSWOR_NOT_NULL.getMessage());
            return result;
        }
        if(repeatPassword.length() < CommonEnum.INT_6.getCode() || newPassword.length() < CommonEnum.INT_6.getCode()){
            result.setCode(Integer.parseInt(BizEnum.PASSWORD_LENGT_THAN_6.getCode()));
            result.setMessage(BizEnum.PASSWORD_LENGT_THAN_6.getMessage());
            return result;
        }
        if(!newPassword.equals(repeatPassword)){
            result.setCode(Integer.parseInt(BizEnum.REPEAT_PASSWORD_DIFFERENCE.getCode()));
            result.setMessage(BizEnum.REPEAT_PASSWORD_DIFFERENCE.getMessage());
            return result;
        }
        if(password.equals(newPassword)){
            result.setCode(Integer.parseInt(BizEnum.NEW_OLD_PASSWORD_NOT_EQUALS.getCode()));
            result.setMessage(BizEnum.NEW_OLD_PASSWORD_NOT_EQUALS.getMessage());
            return result;
        }


        userMapper.update(user);
        result.setCode(Integer.parseInt(BizEnum.SUCCESS.getCode()));
        result.setMessage(BizEnum.SUCCESS.getMessage());
        return result;
    }
}
