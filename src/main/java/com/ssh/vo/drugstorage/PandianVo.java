package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

public class PandianVo {
	private int id;
	private String ypid;
	private String ypName;
	private BigDecimal jcnum;
	private String jcdw;
	private BigDecimal dj;
	private BigDecimal kynum;
	private BigDecimal kyje;
	private String ph;
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
	public BigDecimal getJcnum() {
		return jcnum;
	}
	public void setJcnum(BigDecimal jcnum) {
		this.jcnum = jcnum;
	}
	public String getJcdw() {
		return jcdw;
	}
	public void setJcdw(String jcdw) {
		this.jcdw = jcdw;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	public BigDecimal getKynum() {
		return kynum;
	}
	public void setKynum(BigDecimal kynum) {
		this.kynum = kynum;
	}
	public BigDecimal getKyje() {
		return kyje;
	}
	public void setKyje(BigDecimal kyje) {
		this.kyje = kyje;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public PandianVo(int id, String ypid, String ypName, BigDecimal jcnum, String jcdw, BigDecimal dj, BigDecimal kynum,
			BigDecimal kyje, String ph) {
		super();
		this.id = id;
		this.ypid = ypid;
		this.ypName = ypName;
		this.jcnum = jcnum;
		this.jcdw = jcdw;
		this.dj = dj;
		this.kynum = kynum;
		this.kyje = kyje;
		this.ph = ph;
	}
	public PandianVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PandianVo [id=" + id + ", ypid=" + ypid + ", ypName=" + ypName + ", jcnum=" + jcnum + ", jcdw=" + jcdw
				+ ", dj=" + dj + ", kynum=" + kynum + ", kyje=" + kyje + ", ph=" + ph + "]";
	}
	
}
