package com.lzy.aspect;

import com.lzy.annotation.DataSource;
import com.lzy.config.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @program: tk-druid-aop
 * @description: 数据源切面类
 * @author: 作者
 * @create: 2022-01-07 16:11
 */
@Aspect
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(com.lzy.annotation.DataSource)")
    public void pointCut(){
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取切入类或方法上注解的数据源的value值即key值
        String dbsKey = getDbsAnnotation(joinPoint).value();
        //切换数据源
        DynamicDataSourceContextHolder.setContextKey(dbsKey);
        try{
            return joinPoint.proceed();
        }finally {
            DynamicDataSourceContextHolder.removeContextKey();
        }

    }

    //根据类或方法获取数据源注解
    private DataSource getDbsAnnotation(ProceedingJoinPoint joinPoint){
        /**
         * JoinPoint连接点，用于获取目标类/目标方法的相关信息
         * 核心方法：
         * Object getTarget()：获取IoC容器内的目标对象
         * Signature getSignature() ：获取目标对象中要执行的目标方法
         * Object[] getArgs()：获取目标方法的参数
         */

        //从Ioc容器去中获取被代理的对象-----在类上的注解
        Class<?> targetClass = joinPoint.getTarget().getClass();
        //获取被代理的对象中的数据源注解对象，（参数给数据源类型的注解）因为获取的就是数据源上的注解来动态切换
        DataSource dbsAnnotation1 = targetClass.getAnnotation(DataSource.class);

        //获取目标对象中要执行的目标方法对象-----在方法上的注解
        MethodSignature  methodSignature = (MethodSignature)joinPoint.getSignature();
        //获取这个目标方法对象的数据源类型注解
        DataSource dbsAnnotation2= methodSignature.getMethod().getAnnotation(DataSource.class);

        //先判断类上是否有该注解，再判断方法上是否有注解
        if(Optional.ofNullable(dbsAnnotation1).isPresent()){
            return dbsAnnotation1;
        }else{
            return dbsAnnotation2;
        }

    }
}
