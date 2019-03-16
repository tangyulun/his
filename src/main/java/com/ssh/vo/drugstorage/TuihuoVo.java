package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

public class TuihuoVo {
	private int id;
	private String ypid;
	private String ypname;
	private BigDecimal buhegenum;
	private BigDecimal dj;
	private BigDecimal je;
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
	public BigDecimal getBuhegenum() {
		return buhegenum;
	}
	public void setBuhegenum(BigDecimal buhegenum) {
		this.buhegenum = buhegenum;
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public TuihuoVo(int id, String ypid, String ypname, BigDecimal buhegenum, BigDecimal dj, BigDecimal je, String ph,
			String bz) {
		super();
		this.id = id;
		this.ypid = ypid;
		this.ypname = ypname;
		this.buhegenum = buhegenum;
		this.dj = dj;
		this.je = je;
		this.ph = ph;
		this.bz = bz;
	}
	public TuihuoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
