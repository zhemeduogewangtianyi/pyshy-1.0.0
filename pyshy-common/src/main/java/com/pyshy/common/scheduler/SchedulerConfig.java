package com.pyshy.common.scheduler;

import com.pyshy.common.redis.redisService.DemoInfoService;
import com.pyshy.entity.DemoInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Resource
    private DemoInfoService demoInfoService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    int count;
    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduler(){
                count++;
        System.out.println("这是个定时任务 : " + count);

        Object o = redisTemplate.opsForValue().get("WTY");
        if (o != null){
            System.out.println("缓存中已有数据>>>>>>>>");
            System.out.println("删除多余的缓存数据");
            demoInfoService.deleteFromCache("WTY");
            System.out.println("删除成功>>>>>>>>");
            if(o instanceof List){
                System.out.println("是");
                for(int i = 0 ; i < ((List) o).size() ; i++){
                    System.out.println(((List) o).get(i));
                }
                System.out.println("缓存中重新添加数据>>>>>>>>>>>>>>");
                List<DemoInfo> all = demoInfoService.findAll();
                redisTemplate.opsForValue().set("WTY",all);
                System.out.println("添加完毕>>>>>>>>>>>>>>");
            }else{
                System.out.println("不是");

            }
        }else{
            System.out.println("缓存中没有数据，正在添加请稍后>>>>>>>>>>>>>>");
            List<DemoInfo> all = demoInfoService.findAll();
            redisTemplate.opsForValue().set("WTY",all);
            System.out.println("添加完毕>>>>>>>>>>>>>>");
        }
    }

}
