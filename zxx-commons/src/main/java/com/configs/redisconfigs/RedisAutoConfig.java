package com.configs.redisconfigs;


import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * @author zxx
 * @desc redis自动装配
 * @createTime 2019-03-11-下午 4:05
 */
@EnableConfigurationProperties(value = {JedisConfigProperties.class, JedisPoolConfig.class})
@EnableCaching(proxyTargetClass = true)
@ConditionalOnProperty(value = "spring.redis.enabled")
@Configuration
public class RedisAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(RedisAutoConfig.class);
    @Autowired
    JedisPoolConfig jedisPoolConfig;
    @Autowired
    private JedisConfigProperties properties;

    @Bean
    @ConditionalOnProperty(value = "spring.redis.cluster.enabled")
    public RedisConnectionFactory connectionFactory() {
        log.warn("-------------->>连接redis集群 {}", properties.getNodes());
        return new JedisConnectionFactory(new RedisClusterConfiguration(properties.getNodes()));
    }

    @Bean
    @ConditionalOnProperty(value = "spring.redis.alone.enabled")
    public RedisConnectionFactory factory() {
        log.warn("-------------->>连接单点redis host : {} port {} password {}", jedisPoolConfig.getHost(), jedisPoolConfig.getPort(), jedisPoolConfig.getPassword());
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxActive(jedisPoolConfig.getMaxActive());
        poolConfig.setMaxIdle(jedisPoolConfig.getMaxIdle());
        poolConfig.setMaxWait(jedisPoolConfig.getMaxWait());
        poolConfig.setMinIdle(jedisPoolConfig.getMaxIdle());
        poolConfig.setDatabase(jedisPoolConfig.getDatabase());
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder()
                .connectTimeout(Duration.ofMillis(jedisPoolConfig.getConnTimeout()))
                .readTimeout(Duration.ofMillis(jedisPoolConfig.getReadTimeout()))
                .build();
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setDatabase(jedisPoolConfig.getDatabase());
        redisStandaloneConfiguration.setPort(jedisPoolConfig.getPort());
        redisStandaloneConfiguration.setPassword(RedisPassword.of(jedisPoolConfig.getPassword()));
        redisStandaloneConfiguration.setHostName(jedisPoolConfig.getHost());
        return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        log.warn("-------------->>配置redisTemplate ");
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        template.setValueSerializer(new FastJsonRedisSerializer(Object.class));
        template.setKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        template.setHashKeySerializer(new StringRedisSerializer(StandardCharsets.UTF_8));
        template.setHashValueSerializer(new FastJsonRedisSerializer(Object.class));
        template.afterPropertiesSet();
        return template;
    }

}
