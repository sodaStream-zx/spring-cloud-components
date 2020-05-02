package com.configs.redisconfigs;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-07-10-上午 10:04
 */
@ConfigurationProperties(prefix = "spring.redis.alone")
public class JedisPoolConfig {
    private Integer database;
    private String host;
    private Integer port;
    private Boolean ssl;
    private String password;
    private Long connTimeout;
    private Integer maxActive;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxWait;
    private Integer readTimeout;
    private Boolean enabled;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "JedisPoolConfig{" +
                "database=" + database +
                ", host='" + host + '\'' +
                ", port=" + port +
                ", ssl=" + ssl +
                ", password='" + password + '\'' +
                ", connTimeout=" + connTimeout +
                ", maxActive=" + maxActive +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                ", maxWait=" + maxWait +
                ", readTimeout=" + readTimeout +
                '}';
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getSsl() {
        return ssl;
    }

    public void setSsl(Boolean ssl) {
        this.ssl = ssl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getConnTimeout() {
        return connTimeout;
    }

    public void setConnTimeout(Long connTimeout) {
        this.connTimeout = connTimeout;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }
}
