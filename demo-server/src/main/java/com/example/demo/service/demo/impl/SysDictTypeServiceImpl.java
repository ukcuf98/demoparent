package com.example.demo.service.demo.impl;

import com.example.demo.dao.SysDictTypeMapper;
import com.example.demo.model.SysDictType;
import com.example.demo.service.demo.SysDictTypeService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.service.demo.impl</p>
 * <p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2019/4/4 14:29
 */
@Service(version="1.0.0")
public class SysDictTypeServiceImpl implements SysDictTypeService {
	@Autowired
	private SysDictTypeMapper sysDictTypeMapper;

	@Override
	public int insert(SysDictType record) {
		return sysDictTypeMapper.insertSelective(record);
	}
}
