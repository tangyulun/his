package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

public class RukuXqVo {
	private int id;
	private String ypid;
	private String ypName;
	private BigDecimal num;
	private String ph;
	private String bz;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYpid() {
		return ypid;
	}
	public void setYpid(String ypid) {
		this.ypid = ypid;
	}
	public String getYpName() {
		return ypName;
	}
	public void setYpName(String ypName) {
		this.ypName = ypName;
	}
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	
	public RukuXqVo(int id, String ypid, String ypName, BigDecimal num, String ph, String bz) {
		super();
		this.id = id;
		this.ypid = ypid;
		this.ypName = ypName;
		this.num = num;
		this.ph = ph;
		this.bz = bz;
	}
	public RukuXqVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RukuXqVo [id=" + id + ", ypid=" + ypid + ", ypName=" + ypName + ", num=" + num + ", ph=" + ph + ", bz="
				+ bz + "]";
	}
	
}
