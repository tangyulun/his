package com.ssh.vo.nurse;

import java.math.BigDecimal;

public class ZhuyuanFaYaoVo {
	private int id;
	private String shoufeiid;
	private String shoufeiname;
	private BigDecimal shulian;
	private BigDecimal danjia;
	private BigDecimal money;
	private String state;
	private String pihao;
	private String beizhu;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShoufeiid() {
		return shoufeiid;
	}
	public void setShoufeiid(String shoufeiid) {
		this.shoufeiid = shoufeiid;
	}
	public String getShoufeiname() {
		return shoufeiname;
	}
	public void setShoufeiname(String shoufeiname) {
		this.shoufeiname = shoufeiname;
	}
	public BigDecimal getShulian() {
		return shulian;
	}
	public void setShulian(BigDecimal shulian) {
		this.shulian = shulian;
	}
	public BigDecimal getDanjia() {
		return danjia;
	}
	public void setDanjia(BigDecimal danjia) {
		this.danjia = danjia;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPihao() {
		return pihao;
	}
	public void setPihao(String pihao) {
		this.pihao = pihao;
	}
	public String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	public ZhuyuanFaYaoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZhuyuanFaYaoVo(int id, String shoufeiid, String shoufeiname, BigDecimal shulian, BigDecimal danjia,
			BigDecimal money, String state, String pihao, String beizhu) {
		super();
		this.id = id;
		this.shoufeiid = shoufeiid;
		this.shoufeiname = shoufeiname;
		this.shulian = shulian;
		this.danjia = danjia;
		this.money = money;
		this.state = state;
		this.pihao = pihao;
		this.beizhu = beizhu;
	}
	
	
}
