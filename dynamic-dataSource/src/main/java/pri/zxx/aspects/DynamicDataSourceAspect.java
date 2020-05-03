package pri.zxx.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pri.zxx.annotion.PickDataSource;
import pri.zxx.config.DynamicDataSourceContextHolder;


/**
 * 动态数据源切换处理器
 *
 * @author Louis
 * @date Oct 31, 2018
 */
@Aspect
@Order(-1)  // 该切面应当先于 @Transactional 执行
@Component
public class DynamicDataSourceAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //切面
    @Pointcut(value = "@annotation(pri.zxx.annotion.PickDataSource)||@within(pri.zxx.annotion.PickDataSource)")
    public void cutOff() {
    }

    @Around(value = "cutOff()")
    public Object round(ProceedingJoinPoint pjp) {
        String name = pjp.getSignature().getName();
        PickDataSource pickDataSource;
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        pickDataSource = methodSignature.getMethod().getAnnotation(PickDataSource.class);
        if (pickDataSource == null) {
            pickDataSource = (PickDataSource) pjp.getSignature().getDeclaringType().getAnnotation(PickDataSource.class);
        }

        if (pickDataSource == null || !DynamicDataSourceContextHolder.containDataSourceKey(pickDataSource.value())) {
            log.warn("数据源[{}] 不存在,使用默认数据源 " + (pickDataSource != null ? pickDataSource.value() : null));
        } else {
            // 切换数据源
            DynamicDataSourceContextHolder.setDataSourceKey(pickDataSource.value());
            log.warn("切换数据源为[{}],方法:[{}]", DynamicDataSourceContextHolder.getDataSourceKey(), name);
        }
        Object proceed = null;
        try {
            proceed = pjp.proceed();
        } catch (Throwable throwable) {
            log.error("datasource wrong,{}", throwable);
        } finally {
            // 将数据源置为默认数据源
            DynamicDataSourceContextHolder.clearDataSourceKey();
            log.warn("重置数据源为： [{}]", DynamicDataSourceContextHolder.getDataSourceKey());
        }
        return proceed;
    }

}