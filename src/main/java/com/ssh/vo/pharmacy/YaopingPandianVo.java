package com.ssh.vo.pharmacy;

import java.math.BigDecimal;

public class YaopingPandianVo {
	private int id;
	private String ypid;
	private String ypname;
	private BigDecimal jcnum;
	private String jcdw;
	private BigDecimal dj;
	private BigDecimal kyje;
	private BigDecimal yknum;
	private String ph;
	private BigDecimal kcnum;
	
	public BigDecimal getKcnum() {
		return kcnum;
	}
	public void setKcnum(BigDecimal kcnum) {
		this.kcnum = kcnum;
	}
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
	public BigDecimal getKyje() {
		return kyje;
	}
	public void setKyje(BigDecimal kyje) {
		this.kyje = kyje;
	}
	public BigDecimal getYknum() {
		return yknum;
	}
	public void setYknum(BigDecimal yknum) {
		this.yknum = yknum;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public YaopingPandianVo(int id, String ypid, String ypname, BigDecimal jcnum, String jcdw, BigDecimal dj,
			BigDecimal kyje, BigDecimal yknum, String ph) {
		super();
		this.id = id;
		this.ypid = ypid;
		this.ypname = ypname;
		this.jcnum = jcnum;
		this.jcdw = jcdw;
		this.dj = dj;
		this.kyje = kyje;
		this.yknum = yknum;
		this.ph = ph;
	}
	public YaopingPandianVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public YaopingPandianVo(int id, String ypid, String ypname, BigDecimal jcnum, String jcdw, BigDecimal dj,
			BigDecimal kyje, BigDecimal yknum, String ph, BigDecimal kcnum) {
		super();
		this.id = id;
		this.ypid = ypid;
		this.ypname = ypname;
		this.jcnum = jcnum;
		this.jcdw = jcdw;
		this.dj = dj;
		this.kyje = kyje;
		this.yknum = yknum;
		this.ph = ph;
		this.kcnum = kcnum;
	}
	
}
