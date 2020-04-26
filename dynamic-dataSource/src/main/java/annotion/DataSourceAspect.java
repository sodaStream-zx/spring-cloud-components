package annotion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-26-21:14
 */
@Aspect
public class DataSourceAspect {


    //切点
    @Pointcut(value = "@annotation(PickDataSource)")
    public void cutOff() {

    }

    @Before(value = "cutOff()")
    public void before(JoinPoint joinPoint) {
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        PickDataSource annotation = (PickDataSource) declaringType.getAnnotation(PickDataSource.class);
        String value = annotation.value();
        System.out.println("value" + value);

    }

    @After(value = "cutOff()")
    public void after(JoinPoint joinPoint) {
        Class declaringType = joinPoint.getSignature().getDeclaringType();
        PickDataSource annotation = (PickDataSource) declaringType.getAnnotation(PickDataSource.class);
        String value = annotation.value();
        System.out.println("value" + value);
    }
}
