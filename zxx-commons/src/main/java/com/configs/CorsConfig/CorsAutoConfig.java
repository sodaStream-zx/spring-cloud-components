package com.configs.CorsConfig;

/**
 * @author zxx
 * @desc
 * @createTime 2019-03-11-下午 3:42
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 */
@Configuration
@EnableConfigurationProperties(value = CorsProperties.class)
@ConditionalOnProperty(value = "common.cors.enabled")
public class CorsAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(CorsAutoConfig.class);
    @Autowired
    private CorsProperties corsProperties;

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin(corsProperties.getOrigin());
        corsConfiguration.addAllowedHeader(corsProperties.getHeader());
        corsConfiguration.addAllowedMethod(corsProperties.getMethod());
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        log.warn("-------------->>跨域自动配置 {} ", corsProperties.toString());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperties.getPath(), buildConfig());
        return new CorsFilter(source);
    }
}
