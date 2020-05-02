package com.configs.redisconfigs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-03-24-21:51
 */
@Configuration
@ConditionalOnMissingBean(name = "RedisAutoConfig")
public class RedisHealthConfig {
    @Bean
    public RedisHealthIndicator redisHealthIndicator() {
        return new RedisHealthIndicator();
    }
}
