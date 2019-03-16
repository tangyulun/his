package com.ssh.vo.staff;


import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class GrantFunctionsVO {
	@JSONField(name="id")
	private long functionsId;

	@JSONField(name="text")
	private String functionsName;

	@JSONField(name="checked")
	private boolean isFrag;

	@JSONField(name="children")
	private List<GrantFunctionsVO2> listg;
	
	public List<GrantFunctionsVO2> getListg() {
		return listg;
	}

	public void setListg(List<GrantFunctionsVO2> listg) {
		this.listg = listg;
	}

	public long getFunctionsId() {
		return functionsId;
	}

	public String getFunctionsName() {
		return functionsName;
	}

	public boolean isFrag() {
		return isFrag;
	}

	public void setFunctionsId(long functionsId) {
		this.functionsId = functionsId;
	}

	public void setFunctionsName(String functionsName) {
		this.functionsName = functionsName;
	}

	public void setFrag(boolean isFrag) {
		this.isFrag = isFrag;
	}

	

	public GrantFunctionsVO(long functionsId, String functionsName) {
		super();
		this.functionsId = functionsId;
		this.functionsName = functionsName;
	}

	public GrantFunctionsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
