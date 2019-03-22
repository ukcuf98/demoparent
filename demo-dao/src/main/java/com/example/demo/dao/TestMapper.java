package com.example.demo.dao;

import com.example.demo.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestMapper {

	@Select("select * from subway_info WHERE id = #{param}")
	TestModel queryById(@Param("param") String param);

	@Select("select * from subwaystation WHERE id = #{param}")
	TestModel queryById_slave(@Param("param") String param);
}
