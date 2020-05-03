package pri.zxx.annotion;

import java.lang.annotation.*;

/**
 * @author Twilight
 * @desc 动态数据源注解
 * @createTime 2020-04-26-20:53
 */
@Inherited
@Target(value = {ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PickDataSource {
    String value();
}
