package com.configs.CorsConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zxx
 * @desc
 * @createTime 2019-03-11-下午 4:05
 */
@ConfigurationProperties(value = "common.cors")
public class CorsProperties {
    private boolean enabled;
    private String origin;
    private String header;
    private String method;
    private String path;

    public CorsProperties() {
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "CorsProperties{" +
                "origin='" + origin + '\'' +
                ", header='" + header + '\'' +
                ", method='" + method + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
