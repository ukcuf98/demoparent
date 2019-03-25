package com.example.demo;

import com.example.demo.common.DataSourceInstances;
import com.example.demo.core.SpringContextUtil;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("com.example.demo.dao")
public class ServerApplication {
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {

		applicationContext = SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		//获取数据源
		DataSource dataSource = SpringContextUtil.getBean(DataSourceInstances.MASTER);
		sessionFactory.setDataSource(dataSource);
		return sessionFactory;
	}
}

