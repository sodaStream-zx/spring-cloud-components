package pri.zxx.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-03-16:19
 */
@ConfigurationProperties(value = "dynamic")
public class DruidProperties {

    private Map<String, Map<String, Object>> datasource;
    private Integer initialSize;
    private Integer minIdle;
    private Integer maxActive;
    private Integer maxWait;
    private Integer timeBetweenEvictionRunsMillis;
    private Integer minEvictableIdleTimeMillis;
    private String validationQuery;
    private Boolean testWhileIdle;
    private Boolean testOnBorrow;
    private Boolean testOnReturn;
    private String filters;
    private Boolean poolPreparedStatements;
    private Integer maxPoolPreparedStatementPerConnectionSize;
    private String connectionProperties;

    public Map<String, Map<String, Object>> getDatasource() {
        return datasource;
    }

    public void setDatasource(Map<String, Map<String, Object>> datasource) {
        this.datasource = datasource;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(Integer timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public Integer getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Integer minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public Integer getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(Integer maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }


    //组装数据源列表
    public Map<Object, Object> druidDataSource() {
        Map<Object, Object> druids = new HashMap<>(this.datasource.size());
        this.datasource.forEach((dsName, stringObjectMap) -> {
            druids.put(dsName, druidDataSource(stringObjectMap));
        });
        return druids;
    }


    public DruidDataSource druidDataSource(Map<String, Object> params) {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(String.valueOf(params.get("url")));
        datasource.setDriverClassName(String.valueOf(params.get("driverClassName")));
        datasource.setUsername(String.valueOf(params.get("username")));
        datasource.setPassword(String.valueOf(params.get("password")));
        datasource.setInitialSize(this.initialSize);
        datasource.setMinIdle(this.minIdle);
        datasource.setMaxWait(this.maxWait);
        datasource.setMaxActive(this.maxActive);
        datasource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        datasource.setValidationQuery(this.validationQuery);
        datasource.setTestWhileIdle(this.testWhileIdle);
        datasource.setTestOnBorrow(this.testOnBorrow);
        datasource.setTestOnReturn(this.testOnReturn);
        datasource.setPoolPreparedStatements(this.poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);
        datasource.setConnectionProperties(this.connectionProperties);
        datasource.setAsyncInit(true);
        try {
            datasource.setFilters(this.filters);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return datasource;
    }
}
