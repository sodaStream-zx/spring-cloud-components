package com.configs.logAsp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxx
 * @desc
 * @createTime 2019-06-21-上午 9:51
 */
@Configuration
@ConditionalOnProperty(value = "common.conlog.enabled")
public class LogRecordAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(LogRecordAutoConfig.class);

    @Bean
    public LogRecordAspect logRecordAspect() {
        log.warn("-------------->>日志切面配置");
        return new LogRecordAspect();
    }
}
