package com.example.demo.controller.demo;

import com.example.demo.common.ResultInfo;
import com.example.demo.model.SysDictType;
import com.example.demo.service.demo.SysDictTypeService;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.controller.demo</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/4/4 14:35
 */
@RestController
@RequestMapping("/sysdicttype")
@Api("系统-字典类型controller")
public class SysDictTypeController {

	@Reference(version="1.0.0")
	private SysDictTypeService sysDictTypeService;

	/**
	 *
	 * @param name
	 * @param code
	 * @param sort
	 * @return
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	@ApiImplicitParams(value={
			@ApiImplicitParam(name="name",value="名称",required = true,dataType = "String"),
			@ApiImplicitParam(name="code",value="编码",required = true,dataType = "String"),
			@ApiImplicitParam(name="sort",value="名称",required = true,dataType = "Integer",example = "1")
	})
	@ApiOperation(value = "/insert", notes = "新增", httpMethod = "GET",response = SysDictType.class)
	public ResultInfo insert(
		String name,
	 	String code,
		Integer sort
	){
		ResultInfo resultInfo = new ResultInfo(-1);
		SysDictType sysDictType = new SysDictType();
		sysDictType.setName(name);
		sysDictType.setCode(code);
		sysDictType.setSort(sort);
		sysDictTypeService.insert(sysDictType);
		resultInfo.setCode(1);
		resultInfo.setMsg("保存成功");
		return resultInfo;
	}

	/**
	 *
	 * @param sysDictType
	 * @return
	 */
	@RequestMapping(value = "/insertVo", method = RequestMethod.GET)
	@ApiOperation(value = "/insertVo", notes = "新增vo", httpMethod = "GET",response = SysDictType.class)
	public ResultInfo insertVo(SysDictType sysDictType){
		ResultInfo resultInfo = new ResultInfo(-1);
		sysDictTypeService.insert(sysDictType);
		resultInfo.setCode(1);
		resultInfo.setMsg("保存成功");
		return resultInfo;
	}
}
