package com.example.demo.service.demo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.DemoUtil;
import com.example.demo.service.demo.TestService;

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
@Service(version="${registry.version}")
//@Service(version="1.0.0")
//@Service
public class TestServiceImpl implements TestService {

	@Override
	public String buildStr(String str) {
		return DemoUtil.testMethod(str);
	}
}
