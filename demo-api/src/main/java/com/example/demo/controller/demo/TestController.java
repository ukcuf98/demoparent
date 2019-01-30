package com.example.demo.controller.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.demo.TestService;
import com.example.demo.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.controller.demo</p>
 * <p>
 * <p>
 *
 * @author zwq
 * @version 1.0
 * @date 2019/1/22 14:00
 */
@RestController
@RequestMapping("/test")
@Api("测试controller")
public class TestController {

	@Reference(version="1.0.0")
//	@Reference
	private TestService testService;

	/**
	 * 测试接口
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ApiOperation(value = "/test", notes = "测试接口", httpMethod = "GET", tags = {"test"})
	public TestVo test(@RequestParam String name){
		TestVo testVo = new TestVo();
		String msg = testService.buildStr(name);
		testVo.setMsg(msg);
		return testVo;
	}
}
