package com.configs.esconfigs;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiaochanggui
 * @date 16:15
 */
@Configuration
@EnableConfigurationProperties(value = ElasticSearchProperties.class)
@ConditionalOnProperty(value = "common.es.enabled")
public class EsAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(EsAutoConfig.class);
    @Autowired
    private ElasticSearchProperties elasticSearchProperties;

    public JestHttpClient jestHttpClient(JestClientFactory jestClientFactory) {
        JestHttpClient client = (JestHttpClient) jestClientFactory.getObject();
        return client;
    }

    @Bean
    public JestClientFactory jestClientFactory() {
        log.warn("-------------->>es连接配置");
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig.Builder(elasticSearchProperties.getHosts())
                .defaultMaxTotalConnectionPerRoute(2000).maxTotalConnection(5000)
                .connTimeout(3000).readTimeout(5 * 600000).multiThreaded(true).build());
        return factory;
    }
}
