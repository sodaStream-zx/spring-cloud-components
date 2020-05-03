package pri.zxx.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-03-17:17
 */
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>() {
        /**
         * 将 master 数据源的 key作为默认数据源的 key
         */
        @Override
        protected String initialValue() {
            return "master";
        }
    };


    /**
     * 数据源的 key集合，用于切换时判断数据源是否存在
     */
    public static List<Object> dataSourceKeys = new ArrayList<>();

    /**
     * 获取数据源
     *
     * @return
     */
    public static String getDataSourceKey() {
        return contextHolder.get();
    }

    /**
     * 切换数据源
     *
     * @param key
     */
    public static void setDataSourceKey(String key) {
        contextHolder.set(key);
    }

    /**
     * 重置数据源
     */
    public static void clearDataSourceKey() {
        contextHolder.remove();
    }

    /**
     * 判断是否包含数据源
     *
     * @param key 数据源key
     * @return
     */
    public static boolean containDataSourceKey(String key) {
        return dataSourceKeys.contains(key);
    }

    /**
     * 添加数据源keys
     *
     * @param keys
     */
    public static void addDataSourceKeys(Collection<?> keys) {
        dataSourceKeys.addAll(keys);
    }
}
