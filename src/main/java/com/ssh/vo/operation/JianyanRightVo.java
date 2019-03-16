package com.ssh.vo.operation;

public class JianyanRightVo {
	private String jianyanId;
	
	private String jianyanName;
	
	private String jianyanRemark;

	public String getJianyanId() {
		return jianyanId;
	}

	public void setJianyanId(String jianyanId) {
		this.jianyanId = jianyanId;
	}

	public String getJianyanName() {
		return jianyanName;
	}

	public void setJianyanName(String jianyanName) {
		this.jianyanName = jianyanName;
	}

	public String getJianyanRemark() {
		return jianyanRemark;
	}

	public void setJianyanRemark(String jianyanRemark) {
		this.jianyanRemark = jianyanRemark;
	}

	public JianyanRightVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JianyanRightVo(String jianyanId, String jianyanName, String jianyanRemark) {
		super();
		this.jianyanId = jianyanId;
		this.jianyanName = jianyanName;
		this.jianyanRemark = jianyanRemark;
	}
	
}