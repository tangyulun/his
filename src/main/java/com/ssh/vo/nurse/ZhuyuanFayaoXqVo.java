package com.ssh.vo.nurse;

import java.math.BigDecimal;
import java.util.Date;

public class ZhuyuanFayaoXqVo {
	private int id;
	private String shoufeiid;
	private String shoufeiname;
	private BigDecimal number;
	private BigDecimal jilian;
	private BigDecimal money;
	private String state;
	private String pingzhengdaohao;
	private Date shoufeiDate;
	private String shoufeiTime;
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
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public BigDecimal getJilian() {
		return jilian;
	}
	public void setJilian(BigDecimal jilian) {
		this.jilian = jilian;
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
	public String getPingzhengdaohao() {
		return pingzhengdaohao;
	}
	public void setPingzhengdaohao(String pingzhengdaohao) {
		this.pingzhengdaohao = pingzhengdaohao;
	}
	
	public Date getShoufeiDate() {
		return shoufeiDate;
	}
	public void setShoufeiDate(Date shoufeiDate) {
		this.shoufeiDate = shoufeiDate;
	}
	public String getShoufeiTime() {
		return shoufeiTime;
	}
	public void setShoufeiTime(String shoufeiTime) {
		this.shoufeiTime = shoufeiTime;
	}
	public ZhuyuanFayaoXqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZhuyuanFayaoXqVo(int id, String shoufeiid, String shoufeiname, BigDecimal number, BigDecimal jilian,
			BigDecimal money, String state, String pingzhengdaohao) {
		super();
		this.id = id;
		this.shoufeiid = shoufeiid;
		this.shoufeiname = shoufeiname;
		this.number = number;
		this.jilian = jilian;
		this.money = money;
		this.state = state;
		this.pingzhengdaohao = pingzhengdaohao;
	}
	
	public ZhuyuanFayaoXqVo(int id, String shoufeiid, String shoufeiname, BigDecimal number, BigDecimal jilian,
			BigDecimal money, String state, String pingzhengdaohao, Date shoufeiDate, String shoufeiTime) {
		super();
		this.id = id;
		this.shoufeiid = shoufeiid;
		this.shoufeiname = shoufeiname;
		this.number = number;
		this.jilian = jilian;
		this.money = money;
		this.state = state;
		this.pingzhengdaohao = pingzhengdaohao;
		this.shoufeiDate = shoufeiDate;
		this.shoufeiTime = shoufeiTime;
	}
	@Override
	public String toString() {
		return "ZhuyuanFayaoXqVo [id=" + id + ", shoufeiid=" + shoufeiid + ", shoufeiname=" + shoufeiname + ", number="
				+ number + ", jilian=" + jilian + ", money=" + money + ", state=" + state + ", pingzhengdaohao="
				+ pingzhengdaohao + "]";
	}
	
	
	
}
