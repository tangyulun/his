package com.ssh.vo.dean;

import java.util.List;

public class ZheXianTuVO {
/**
 * name : '北京',
				        		value:[-9,1,12,20,26,30,32,29,22,12,0,-6],
				        		color:'#1f7e92',
				        		line_width:3
 */
	
	private String name ;
	
	public ZheXianTuVO() {
	super();
	// TODO Auto-generated constructor stub
}

	private List<Double> value;
	
	private Integer line_width;
	
	private String color;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Double> getValue() {
		return value;
	}

	public void setValue(List<Double> value) {
		this.value = value;
	}

	public Integer getLine_width() {
		return line_width;
	}

	public void setLine_width(Integer line_width) {
		this.line_width = line_width;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ZheXianTuVO(String name, List<Double> value, Integer line_width, String color) {
		super();
		this.name = name;
		this.value = value;
		this.line_width = line_width;
		this.color = color;
	}
	
	
}
