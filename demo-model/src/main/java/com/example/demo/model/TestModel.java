package com.example.demo.model;

import java.io.Serializable;

public class TestModel implements Serializable{

	private Integer userrole;
	private Integer usertitle;
	private Integer state;
	private Integer id;
	private String name;

	public Integer getUserrole() {
		return userrole;
	}

	public void setUserrole(Integer userrole) {
		this.userrole = userrole;
	}

	public Integer getUsertitle() {
		return usertitle;
	}

	public void setUsertitle(Integer usertitle) {
		this.usertitle = usertitle;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}