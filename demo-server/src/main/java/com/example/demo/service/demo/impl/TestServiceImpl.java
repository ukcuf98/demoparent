package com.example.demo.service.demo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.DemoUtil;
import com.example.demo.annotation.DataSource;
import com.example.demo.common.DataSourceInstances;
import com.example.demo.dao.TestMapper;
import com.example.demo.model.TestModel;
import com.example.demo.service.demo.TestService;
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
//@Service(version="${registry.version}")
@Service(version="1.0.0", interfaceName = "com.example.demo.service.demo.TestService")
//@Service
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
}
