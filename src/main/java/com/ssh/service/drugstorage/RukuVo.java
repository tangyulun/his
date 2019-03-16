package com.ssh.service.drugstorage;

import java.math.BigDecimal;
import java.util.Date;

public class RukuVo {
	private int id;
	private String ypid;
	private String ypname;
	private BigDecimal num;
	private String dw;
	private Date scrq;
	private Date cgrq;
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
	public String getYpname() {
		return ypname;
	}
	public void setYpname(String ypname) {
		this.ypname = ypname;
	}
	public BigDecimal getNum() {
		return num;
	}
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	public String getDw() {
		return dw;
	}
	public void setDw(String dw) {
		this.dw = dw;
	}
	public Date getScrq() {
		return scrq;
	}
	public void setScrq(Date scrq) {
		this.scrq = scrq;
	}
	public Date getCgrq() {
		return cgrq;
	}
	public void setCgrq(Date cgrq) {
		this.cgrq = cgrq;
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
	public RukuVo(int id, String ypid, String ypname, BigDecimal num, String dw, Date scrq, Date cgrq, String ph,
			String bz) {
		super();
		this.id = id;
		this.ypid = ypid;
		this.ypname = ypname;
		this.num = num;
		this.dw = dw;
		this.scrq = scrq;
		this.cgrq = cgrq;
		this.ph = ph;
		this.bz = bz;
	}
	public RukuVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RukuVo [id=" + id + ", ypid=" + ypid + ", ypname=" + ypname + ", num=" + num + ", dw=" + dw + ", scrq="
				+ scrq + ", cgrq=" + cgrq + ", ph=" + ph + ", bz=" + bz + "]";
	}
	
	
}
