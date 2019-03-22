package com.example.demo.core;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.core</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2018/6/30 12:10
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey()
	{
		return DataSourceManager.getDataSourceType();
	}
}
