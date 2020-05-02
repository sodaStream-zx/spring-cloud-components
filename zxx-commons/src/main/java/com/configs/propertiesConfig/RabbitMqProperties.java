package com.configs.propertiesConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-03-11-下午 4:41
 */
@ConfigurationProperties(value = "common.rabbit")
public class RabbitMqProperties {
    private boolean enabled;
    private Map<String, String> queue = new HashMap<>();
    private Map<String, String> exchange = new HashMap<>();

    @Override
    public String toString() {
        return "RabbitMqProperties{" +
                "queue=" + queue +
                ", exchange=" + exchange +
                '}';
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Map<String, String> getExchange() {
        return exchange;
    }

    public void setExchange(Map<String, String> exchange) {
        this.exchange = exchange;
    }

    public Map<String, String> getQueue() {
        return queue;
    }

    public void setQueue(Map<String, String> queue) {
        this.queue = queue;
    }
}
