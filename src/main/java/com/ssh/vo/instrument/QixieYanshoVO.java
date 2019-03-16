package com.ssh.vo.instrument;

import java.math.BigDecimal;

public class QixieYanshoVO {
	private int id;
	private String ypId;
	private String ypName;
	private String shuliang;
	private String danwei;
	private BigDecimal danjia;
	private String jine;
	private String beizhu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYpId() {
		return ypId;
	}
	public void setYpId(String ypId) {
		this.ypId = ypId;
	}
	public String getYpName() {
		return ypName;
	}
	public void setYpName(String ypName) {
		this.ypName = ypName;
	}
	public String getShuliang() {
		return shuliang;
	}
	public void setShuliang(String shuliang) {
		this.shuliang = shuliang;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public BigDecimal getDanjia() {
		return danjia;
	}
	public void setDanjia(BigDecimal danjia) {
		this.danjia = danjia;
	}
	public String getJine() {
		return jine;
	}
	public void setJine(String jine) {
		this.jine = jine;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public QixieYanshoVO(int id, String ypId, String ypName, String shuliang, String danwei, BigDecimal danjia,
			String jine, String beizhu) {
		super();
		this.id = id;
		this.ypId = ypId;
		this.ypName = ypName;
		this.shuliang = shuliang;
		this.danwei = danwei;
		this.danjia = danjia;
		this.jine = jine;
		this.beizhu = beizhu;
	}
	public QixieYanshoVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
