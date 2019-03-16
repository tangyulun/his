package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

public class YanshouVo {
	private int id;
	private String ypId;
	private String ypName;
	private String drugdw;
	private BigDecimal dj;
	private BigDecimal je;
	private String ph;
	private BigDecimal hgnum;
	private BigDecimal nohgnum;
	private BigDecimal zongnum;
	private String bz;
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
	public String getDrugdw() {
		return drugdw;
	}
	public void setDrugdw(String drugdw) {
		this.drugdw = drugdw;
	}
	public BigDecimal getDj() {
		return dj;
	}
	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}
	public BigDecimal getJe() {
		return je;
	}
	public void setJe(BigDecimal je) {
		this.je = je;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public BigDecimal getHgnum() {
		return hgnum;
	}
	public void setHgnum(BigDecimal hgnum) {
		this.hgnum = hgnum;
	}
	public BigDecimal getNohgnum() {
		return nohgnum;
	}
	public void setNohgnum(BigDecimal nohgnum) {
		this.nohgnum = nohgnum;
	}
	public BigDecimal getZongnum() {
		return zongnum;
	}
	public void setZongnum(BigDecimal zongnum) {
		this.zongnum = zongnum;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public YanshouVo(int id, String ypId, String ypName, String drugdw, BigDecimal dj, BigDecimal je, String ph,
			BigDecimal hgnum, BigDecimal nohgnum, BigDecimal zongnum, String bz) {
		super();
		this.id = id;
		this.ypId = ypId;
		this.ypName = ypName;
		this.drugdw = drugdw;
		this.dj = dj;
		this.je = je;
		this.ph = ph;
		this.hgnum = hgnum;
		this.nohgnum = nohgnum;
		this.zongnum = zongnum;
		this.bz = bz;
	}
	public YanshouVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
