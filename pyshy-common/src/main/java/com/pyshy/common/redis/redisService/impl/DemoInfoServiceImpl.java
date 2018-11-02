package com.pyshy.common.redis.redisService.impl;

import com.pyshy.entity.DemoInfo;
import com.pyshy.common.redis.DemoInfoRepository;
import com.pyshy.common.redis.redisService.DemoInfoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DemoInfoServiceImpl implements DemoInfoService {

    @Resource
    private DemoInfoRepository demoInfoRepository;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    @Cacheable(value="demoInfo") //缓存,这里没有指定key.
    @Override
    public DemoInfo findById(long id) {
        System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id="+id);
        Optional<DemoInfo> demoInfo = demoInfoRepository.findById(id);
        DemoInfo demo = demoInfo.get();

        return demo;
    }

    @Override
    public List<DemoInfo> findByCache() {
        Object o = redisTemplate.opsForValue().get("xiaozhoushishadiao");
        List<DemoInfo> demoInfos = new ArrayList<>();
        if(o instanceof List){
            for(int i = 0 ; i < ((List) o).size() ; i++){
                demoInfos.add(((List<DemoInfo>) o).get(i));
            }
            if(demoInfos != null)
                return demoInfos;
        }
            return findAll();
    }

    @Override
    public void deleteFromCache(long id) {
        System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
    }

    @Override
    @CacheEvict(value="xiaozhoushishadiao")
    public void deleteFromCache(String key) {

        Boolean xiaozhoushishadiao = redisTemplate.delete(key);
        System.out.println(xiaozhoushishadiao);
        System.out.println(".从缓存中删除.");
    }

    @Override
    public List<DemoInfo> findAll() {
        Iterable<DemoInfo> all = demoInfoRepository.findAll();
        List<DemoInfo> list = new ArrayList<>();
        for(DemoInfo d : all){
            if(d != null){
                list.add(d);
            }
        }
        return list;
    }

    @CacheEvict(value="demoInfo")
    @Override
    public void test() {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("mykey4", "random1="+Math.random());
        System.out.println(valueOperations.get("mykey4"));
    }
}