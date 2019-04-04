package com.example.demo.dao;

import com.example.demo.model.SysDictType;

public interface SysDictTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    SysDictType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysDictType record);

    int updateByPrimaryKey(SysDictType record);
}