package pri.zxx.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-03-17:08
 */
@Configuration
@EnableConfigurationProperties(value = DruidProperties.class)
public class DataSourceConfig {

    @Autowired
    private DruidProperties druidProperties;

    @Bean
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> stringDruidDataSourceMap = druidProperties.druidDataSource();
        dynamicDataSource.setDataSources(stringDruidDataSourceMap);
        return dynamicDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        // 配置数据源，此处配置为关键配置，如果没有将 dynamicDataSource作为数据源则不能实现切换
        sessionFactory.setDataSource(dynamicDataSource());
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/mappers/**/*.xml"));    // 扫描映射文件
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 配置事务管理, 使用事务时在方法头部添加@Transactional注解即可
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
