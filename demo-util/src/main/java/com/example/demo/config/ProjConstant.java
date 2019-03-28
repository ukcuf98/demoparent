package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.config</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/3/26 10:40
 */
@Component("projConstant")
public class ProjConstant {

	@Value("${proj-constant-redisopen}")
	private Integer redisOpen;
	@Value("${proj-constant-redis-clustertype}")
	private Integer clustertype;
	@Value("${proj-constant-redisconfig}")
	private String redisconfig;
	@Value("${proj-constant-redisclustername}")
	private String redisclustername;

	public Integer getRedisOpen() {
		return redisOpen;
	}

	public void setRedisOpen(Integer redisOpen) {
		this.redisOpen = redisOpen;
	}

	public Integer getClustertype() {
		return clustertype;
	}

	public void setClustertype(Integer clustertype) {
		this.clustertype = clustertype;
	}

	public String getRedisconfig() {
		return redisconfig;
	}

	public void setRedisconfig(String redisconfig) {
		this.redisconfig = redisconfig;
	}

	public String getRedisclustername() {
		return redisclustername;
	}

	public void setRedisclustername(String redisclustername) {
		this.redisclustername = redisclustername;
	}
}
