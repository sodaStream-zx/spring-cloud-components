package pri.zxx.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-26-20:45
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDataSourceKey();
    }

    /**
     * 设置数据源
     *
     * @param dataSources
     */
    public void setDataSources(Map<Object, Object> dataSources) {
        super.setTargetDataSources(dataSources);
        // 将数据源的 key 放到数据源上下文的 key 集合中，用于切换时判断数据源是否有效
        DynamicDataSourceContextHolder.addDataSourceKeys(dataSources.keySet());
    }
}
