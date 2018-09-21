package com.pyshy.lgmanager.shiro.userInfoRepository;

import com.pyshy.entity.userInfo.user.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long> {

    public UserInfo findByUsername(String username);

}
