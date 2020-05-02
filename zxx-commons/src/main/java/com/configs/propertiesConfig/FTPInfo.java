package com.configs.propertiesConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Administrator
 * @desc
 * @createTime 2019-03-11-下午 4:27
 */
@ConfigurationProperties(value = "common.ftp")
public class FTPInfo {
    private boolean enabled;
    /**
     * FTP  IP地址
     */
    private String ip;
    /**
     * FTP  端口地址
     */
    private int port;
    /**
     * FTP  用户名
     */
    private String username;
    /**
     * FTP  登录密码
     */
    private String password;
    private String basePath;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public String toString() {
        return "FTPInfo{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
