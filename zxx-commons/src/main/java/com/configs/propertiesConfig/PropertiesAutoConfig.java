package com.configs.propertiesConfig;

import com.configs.smsconfig.SmsPro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Twilight
 * @desc
 * @createTime 2019-03-11-23:23
 */
@Configuration
public class PropertiesAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(PropertiesAutoConfig.class);

    @Bean
    @ConditionalOnProperty(value = "common.ftp.enabled")
    public FTPInfo ftpInfo() {
        log.warn("-------------->>配置ftp");
        return new FTPInfo();
    }

    @Bean
    @ConditionalOnProperty(value = "common.rabbit.enabled")
    public RabbitMqProperties rabbitMqProperties() {
        log.warn("-------------->>配置rabbit队列交换机");
        return new RabbitMqProperties();
    }

    @Bean
    @ConditionalOnProperty(value = "common.sms.enabled")
    public SmsPro smsPro() {
        log.warn("-------------->>配置sms");
        return new SmsPro();
    }
}
