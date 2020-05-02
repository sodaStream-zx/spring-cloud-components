package com.configs.redisconfigs;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/5 0005.
 */
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class JedisConfigProperties {
    private boolean enabled;

    private List<String> nodes = new ArrayList<>();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "JedisConfigProperties{" +
                "nodes=" + nodes +
                '}';
    }
}

