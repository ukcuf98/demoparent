package com.example.demo.service.demo;

import com.example.demo.model.TestModel;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.service.demo</p>
 * <p>
 * <p>
 *
 * @author zwq
 * @version 1.0
 * @date 2019/1/22 14:18
 */
public interface TestService {

	/**
	 * 生产字符串
	 * @param str
	 * @return
	 */
	String buildStr(String str);

	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	TestModel queryById(String id);

	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	TestModel queryById_slave(String id);
}
