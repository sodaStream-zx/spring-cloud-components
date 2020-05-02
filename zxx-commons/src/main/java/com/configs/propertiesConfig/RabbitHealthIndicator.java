package com.configs.propertiesConfig;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-06-22-上午 9:24
 */
public class RabbitHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().build();
    }
}
