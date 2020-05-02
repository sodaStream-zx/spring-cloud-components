package com.configs.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zxx
 * @desc
 * @createTime 2019-08-05-上午 9:49
 */
@EnableConfigurationProperties(value = MongoDbPro.class)
@Configuration
@ConditionalOnProperty(value = "common.mongo.enabled")
public class MongoDbAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(MongoDbAutoConfig.class);
    @Autowired
    private MongoDbPro mongoDbPro;

    @Bean
    public MongoClient mongoClient() {
        log.warn("-------------->>配置mongodb {}", mongoDbPro.toString());
        return new MongoClient(new MongoClientURI(mongoDbPro.getUri()));
    }
}
