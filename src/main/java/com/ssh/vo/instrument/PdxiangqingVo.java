package com.ssh.vo.instrument;

import java.math.BigDecimal;

public class PdxiangqingVo {
	private int id;

	private String qxid;

	
	private String qxname;

	
	private BigDecimal shuliang;

	
	private String danwei;

	
	private String beizhu;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQxid() {
		return qxid;
	}


	public void setQxid(String qxid) {
		this.qxid = qxid;
	}


	public String getQxname() {
		return qxname;
	}


	public void setQxname(String qxname) {
		this.qxname = qxname;
	}


	public BigDecimal getShuliang() {
		return shuliang;
	}


	public void setShuliang(BigDecimal shuliang) {
		this.shuliang = shuliang;
	}


	public String getDanwei() {
		return danwei;
	}


	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}


	public String getBeizhu() {
		return beizhu;
	}


	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}


	public PdxiangqingVo(int id, String qxid, String qxname, BigDecimal shuliang, String danwei, String beizhu) {
		super();
		this.id = id;
		this.qxid = qxid;
		this.qxname = qxname;
		this.shuliang = shuliang;
		this.danwei = danwei;
		this.beizhu = beizhu;
	}


	public PdxiangqingVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "PdxiangqingVo [id=" + id + ", qxid=" + qxid + ", qxname=" + qxname + ", shuliang=" + shuliang
				+ ", danwei=" + danwei + ", beizhu=" + beizhu + "]";
	}
	
}
