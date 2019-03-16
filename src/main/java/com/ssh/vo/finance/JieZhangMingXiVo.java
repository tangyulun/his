package com.ssh.vo.finance;

import java.math.BigDecimal;

public class JieZhangMingXiVo {
	private int id;
	private String caigouid;
	private String caigouzt;
	private BigDecimal caigoumoney;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCaigouid() {
		return caigouid;
	}
	public void setCaigouid(String caigouid) {
		this.caigouid = caigouid;
	}
	public String getCaigouzt() {
		return caigouzt;
	}
	public void setCaigouzt(String caigouzt) {
		this.caigouzt = caigouzt;
	}
	public BigDecimal getCaigoumoney() {
		return caigoumoney;
	}
	public void setCaigoumoney(BigDecimal caigoumoney) {
		this.caigoumoney = caigoumoney;
	}
	public JieZhangMingXiVo(int id, String caigouid, String caigouzt, BigDecimal caigoumoney) {
		super();
		this.id = id;
		this.caigouid = caigouid;
		this.caigouzt = caigouzt;
		this.caigoumoney = caigoumoney;
	}
	public JieZhangMingXiVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JieZhangMingXiVo [id=" + id + ", caigouid=" + caigouid + ", caigouzt=" + caigouzt + ", caigoumoney="
				+ caigoumoney + "]";
	}
	
}
