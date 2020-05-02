package com.configs.propertiesConfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-06-22-上午 9:27
 */
@Configuration
@ConditionalOnMissingBean(name = "RabbitMqProperties")
public class RabbitHealthAutoConfig {
    @Bean
    public RabbitHealthIndicator rabbitHealthIndicator() {
        return new RabbitHealthIndicator();
    }
}

