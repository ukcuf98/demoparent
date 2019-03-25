package com.example.demo.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:springcontext获取bean</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2018/6/30 17:03
 */
@Component
public class SpringContextUtil
		implements ApplicationContextAware
{

	// Spring应用上下文环境
	private static ApplicationContext applicationContext;
	private static final Object lock = new Object();

	/*
	 * 实现了ApplicationContextAware 接口，必须实现该方法；
	 * 通过传递applicationContext参数初始化成员变量applicationContext
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		synchronized (lock) {
			if(null == SpringContextUtil.applicationContext){
				SpringContextUtil.applicationContext = applicationContext;
			}
		}
		SpringContextUtil.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) throws BeansException {
		return (T) applicationContext.getBean(clazz);
	}
}
