package com.example.demo.core;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.core</p>
 * <p>
 * <p>
 * @author lucifer
 * @version 1.0
 * @date 2018/7/19 14:25
 */
@Configuration
public class DataSourceConfig {

	@Primary
	@Bean(name = "masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.master")
	public DataSource masterDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "slaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.druid.slave")
	public DataSource slaveDataSource() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean(name = "masterJdbcTemplate")
	public JdbcTemplate masterJdbcTemplate(
			@Qualifier("masterDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "slaveJdbcTemplate")
	public JdbcTemplate slaveJdbcTemplate(
			@Qualifier("slaveDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
