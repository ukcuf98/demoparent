package com.example.demo.common;

import io.swagger.annotations.Api;

import java.io.Serializable;

/**
 * <p>Title: </p>
 * <p>
 * <p>Description:com.example.demo.common</p>
 * <p>
 * <p>
 * @author zwq
 * @version 1.0
 * @date 2019/4/4 14:47
 */
public class ResultInfo implements Serializable {
	private Integer code;
	private String msg;
	private Object data;

	public ResultInfo(Integer code){
		this.code=code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
