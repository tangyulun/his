package com.ssh.vo.dean;


import com.alibaba.fastjson.annotation.JSONField;

public class HospitalZongTongJiVO {
	/**
	 * 这三个用来统计扇形图
	 */
	private String name ; //统计名
	
	private Double value ; // 统计的值
	
	private String color ; //统计颜色

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public HospitalZongTongJiVO(String name, Double value, String color) {
		super();
		this.name = name;
		this.value = value;
		this.color = color;
	}

	
	
	
}
