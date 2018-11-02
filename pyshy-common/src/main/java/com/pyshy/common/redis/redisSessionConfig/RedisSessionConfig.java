package com.pyshy.common.redis.redisSessionConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * session共享
 * */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*60)
public class RedisSessionConfig {
}
