package com.pyshy.common.scheduler;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Scheduled(cron = "0/50 * * * * ?")
    public void scheduler(){
        System.out.println("定时任务执行");
    }

}
