package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:数据源注解，切换数据源使用</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2018/6/30 16:55
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
	String value();
}
