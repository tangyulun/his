package com.ssh.vo.operation;

import java.math.BigDecimal;

import com.ssh.vo.outpatient.FinacialVo;

public class ShoushuChuanzhiVo {
	private int id;
	
	private String ssid;
	
	private String ssName;
	
	private String ssleixing;
	
	private BigDecimal shuliang;
	
	private BigDecimal danjia;
	
	private String jieguo;
	
	private BigDecimal jine;
	
	
	private FinacialVo finacialVo;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSsid() {
		return ssid;
	}


	public void setSsid(String ssid) {
		this.ssid = ssid;
	}


	public String getSsName() {
		return ssName;
	}


	public void setSsName(String ssName) {
		this.ssName = ssName;
	}


	public String getSsleixing() {
		return ssleixing;
	}


	public void setSsleixing(String ssleixing) {
		this.ssleixing = ssleixing;
	}


	public BigDecimal getShuliang() {
		return shuliang;
	}


	public void setShuliang(BigDecimal shuliang) {
		this.shuliang = shuliang;
	}


	public BigDecimal getDanjia() {
		return danjia;
	}


	public void setDanjia(BigDecimal danjia) {
		this.danjia = danjia;
	}


	public String getJieguo() {
		return jieguo;
	}


	public void setJieguo(String jieguo) {
		this.jieguo = jieguo;
	}


	public BigDecimal getJine() {
		return jine;
	}


	public void setJine(BigDecimal jine) {
		this.jine = jine;
	}


	public FinacialVo getFinacialVo() {
		return finacialVo;
	}


	public void setFinacialVo(FinacialVo finacialVo) {
		this.finacialVo = finacialVo;
	}


	public ShoushuChuanzhiVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ShoushuChuanzhiVo(int id, String ssid, String ssName, String ssleixing, BigDecimal shuliang,
			BigDecimal danjia, String jieguo, BigDecimal jine) {
		super();
		this.id = id;
		this.ssid = ssid;
		this.ssName = ssName;
		this.ssleixing = ssleixing;
		this.shuliang = shuliang;
		this.danjia = danjia;
		this.jieguo = jieguo;
		this.jine = jine;
	}


	
}
