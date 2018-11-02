package com.pyshy.common.redis.redisService;

import com.pyshy.entity.DemoInfo;

import java.util.List;

public interface DemoInfoService {

    public DemoInfo findById(long id);

    public List<DemoInfo> findByCache();

    public void deleteFromCache(long id);

    public void deleteFromCache(String key);

    public List<DemoInfo> findAll();

    void test();

}
