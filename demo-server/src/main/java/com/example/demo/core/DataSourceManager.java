package com.example.demo.core;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:数据源切换</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/6/30 12:11
 */
public class DataSourceManager {
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDataSourceType(String dataSourceType)
	{
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType()
	{
		return contextHolder.get();
	}

	public static void clearDataSourceType()
	{
		contextHolder.remove();
	}
}
