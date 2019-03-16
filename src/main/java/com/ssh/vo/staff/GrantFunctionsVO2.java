package com.ssh.vo.staff;

import com.alibaba.fastjson.annotation.JSONField;

public class GrantFunctionsVO2 {
	@JSONField(name="id")
	private long functionsId;

	@JSONField(name="text")
	private String functionsName;

	@JSONField(name="checked")
	private boolean isFrag;
	
	public boolean isFrag() {
		return isFrag;
	}

	public void setFrag(boolean isFrag) {
		this.isFrag = isFrag;
	}

	public long getFunctionsId() {
		return functionsId;
	}

	public void setFunctionsId(long functionsId) {
		this.functionsId = functionsId;
	}

	public String getFunctionsName() {
		return functionsName;
	}

	public void setFunctionsName(String functionsName) {
		this.functionsName = functionsName;
	}

	public GrantFunctionsVO2(long functionsId, String functionsName) {
		super();
		this.functionsId = functionsId;
		this.functionsName = functionsName;
	}

	public GrantFunctionsVO2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
