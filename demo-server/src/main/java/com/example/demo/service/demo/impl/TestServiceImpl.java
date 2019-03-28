package com.example.demo.service.demo.impl;

import com.example.demo.DemoUtil;
import com.example.demo.annotation.DataSource;
import com.example.demo.cache.RedisCache;
import com.example.demo.common.DataSourceInstances;
import com.example.demo.dao.TestMapper;
import com.example.demo.model.TestModel;
import com.example.demo.service.demo.TestService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.service.demo.impl</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/1/22 14:20
 */
@Service(version="1.0.0")
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;

	@Override
	public String buildStr(String str) {
		return DemoUtil.testMethod(str);
	}

	@Override
	public TestModel queryById(String id) {
		try {
			return testMapper.queryById(id);
		}catch (Exception e){
			return null;
		}
	}

	@Override
	@DataSource(DataSourceInstances.SLAVE)
	public TestModel queryById_slave(String id) {
		return testMapper.queryById_slave(id);
	}

	@Override
	public String setCache(String key, String value) {
		return RedisCache.getInstance().putString(key,value);
	}

	@Override
	public String getCache(String key) {
		return RedisCache.getInstance().getString(key);
	}
}
