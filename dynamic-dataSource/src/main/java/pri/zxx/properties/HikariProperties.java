package pri.zxx.properties;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-03-16:19
 */
@ConfigurationProperties(value = "dynamic.hikari")
public class HikariProperties {

    private Map<String, Map<String, Object>> diffProperties = new HashMap<>();
    private Integer minimumIdle;
    private Integer maximumPoolSize;
    private Boolean autoCommit;
    private Integer idleTimeout;
    private String poolName;
    private Integer maxLifetime;
    private String connectionTestQuery;

    public Map<String, Map<String, Object>> getDiffProperties() {
        return diffProperties;
    }

    public void setDiffProperties(Map<String, Map<String, Object>> diffProperties) {
        this.diffProperties = diffProperties;
    }

    public Integer getMinimumIdle() {
        return minimumIdle;
    }

    public void setMinimumIdle(Integer minimumIdle) {
        this.minimumIdle = minimumIdle;
    }

    public Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public Boolean getAutoCommit() {
        return autoCommit;
    }

    public void setAutoCommit(Boolean autoCommit) {
        this.autoCommit = autoCommit;
    }

    public Integer getIdleTimeout() {
        return idleTimeout;
    }

    public void setIdleTimeout(Integer idleTimeout) {
        this.idleTimeout = idleTimeout;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public Integer getMaxLifetime() {
        return maxLifetime;
    }

    public void setMaxLifetime(Integer maxLifetime) {
        this.maxLifetime = maxLifetime;
    }

    public String getConnectionTestQuery() {
        return connectionTestQuery;
    }

    public void setConnectionTestQuery(String connectionTestQuery) {
        this.connectionTestQuery = connectionTestQuery;
    }

    //组装数据源列表
    public Map<Object, Object> hikariDataSources() {
        Map<Object, Object> druids = new HashMap<>(this.diffProperties.size());
        this.diffProperties.forEach((dsName, stringObjectMap) -> druids.put(dsName, hikariDataSource(stringObjectMap)));
        return druids;
    }


    public HikariDataSource hikariDataSource(Map<String, Object> params) {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setJdbcUrl(String.valueOf(params.get("url")));
        datasource.setDriverClassName(String.valueOf(params.get("driverClassName")));
        datasource.setUsername(String.valueOf(params.get("username")));
        datasource.setPassword(String.valueOf(params.get("password")));
        datasource.setAutoCommit(this.autoCommit);
        datasource.setMinimumIdle(this.minimumIdle);
        datasource.setMaximumPoolSize(this.maximumPoolSize);
        datasource.setIdleTimeout(this.idleTimeout);
        datasource.setPoolName(this.poolName);
        datasource.setMaxLifetime(this.maxLifetime);
        datasource.setConnectionTestQuery(this.connectionTestQuery);
        return datasource;
    }
}
