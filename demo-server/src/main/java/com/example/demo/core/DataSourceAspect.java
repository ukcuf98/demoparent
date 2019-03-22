package com.example.demo.core;

import com.example.demo.annotation.DataSource;
import com.example.demo.common.DataSourceInstances;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.mapping.Environment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * <p>Title: </p>
 * <p>
 * <p>Description:数据源切换切面</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/3/10 16:57
 */
//@Aspect
//@Component
public class DataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceAspect.class);
    @Pointcut("execution(* *..example.demo.service.demo.impl..*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void doBeforeInService(JoinPoint joinPoint){
        try {
            logger.debug("doBeforeInService");
            // 获取到当前执行的方法名
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            javax.sql.DataSource dataSource;
            if(method.isAnnotationPresent(DataSource.class)){ //如果用了@DataSource注解标注
                DataSource dataSourceAnn = method.getAnnotation(DataSource.class);
                String key = dataSourceAnn.value();
                dataSource = SpringContextUtil.getBean(key);//获取数据源
            }else{
                //如果没有标注则默认使用Master数据源
                dataSource = SpringContextUtil.getBean(DataSourceInstances.MASTER); //获取数据源
            }
            //---------------------修改mybatis的数据源-----------------------
            SqlSessionFactoryBean sqlSessionFactoryBean = SpringContextUtil.getBean(SqlSessionFactoryBean.class);
            Environment environment = sqlSessionFactoryBean.getObject().getConfiguration().getEnvironment();
            Field dataSourceField = environment.getClass().getDeclaredField("dataSource");
            //跳过检查
            dataSourceField.setAccessible(true);
            //修改mybatis的数据源
            dataSourceField.set(environment,dataSource);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
