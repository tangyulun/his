package com.ssh.vo.instrument;

import java.math.BigDecimal;



public class CgXIangqingVo {
	private int CGid; 
	
	private String QXCGID;

	
	private String QXCGNAME;

	
	private BigDecimal SHULIANG;

	
	private String DANWEI;

	
	private BigDecimal DANJIA;

	
	private BigDecimal JINE;
	
	@Override
	public String toString() {
		return "CgXIangqingVo [CGid=" + CGid + ", QXCGID=" + QXCGID + ", QXCGNAME=" + QXCGNAME + ", SHULIANG="
				+ SHULIANG + ", DANWEI=" + DANWEI + ", DANJIA=" + DANJIA + ", JINE=" + JINE + ", BEIZHU=" + BEIZHU
				+ "]";
	}

	public CgXIangqingVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CgXIangqingVo(int cGid, String qXCGID, String qXCGNAME, BigDecimal sHULIANG, String dANWEI,
			BigDecimal dANJIA, BigDecimal jINE, String bEIZHU) {
		super();
		CGid = cGid;
		QXCGID = qXCGID;
		QXCGNAME = qXCGNAME;
		SHULIANG = sHULIANG;
		DANWEI = dANWEI;
		DANJIA = dANJIA;
		JINE = jINE;
		BEIZHU = bEIZHU;
	}

	public int getCGid() {
		return CGid;
	}

	public void setCGid(int cGid) {
		CGid = cGid;
	}

	public String getQXCGID() {
		return QXCGID;
	}

	public void setQXCGID(String qXCGID) {
		QXCGID = qXCGID;
	}

	public String getQXCGNAME() {
		return QXCGNAME;
	}

	public void setQXCGNAME(String qXCGNAME) {
		QXCGNAME = qXCGNAME;
	}

	public BigDecimal getSHULIANG() {
		return SHULIANG;
	}

	public void setSHULIANG(BigDecimal sHULIANG) {
		SHULIANG = sHULIANG;
	}

	public String getDANWEI() {
		return DANWEI;
	}

	public void setDANWEI(String dANWEI) {
		DANWEI = dANWEI;
	}

	public BigDecimal getDANJIA() {
		return DANJIA;
	}

	public void setDANJIA(BigDecimal dANJIA) {
		DANJIA = dANJIA;
	}

	public BigDecimal getJINE() {
		return JINE;
	}

	public void setJINE(BigDecimal jINE) {
		JINE = jINE;
	}

	public String getBEIZHU() {
		return BEIZHU;
	}

	public void setBEIZHU(String bEIZHU) {
		BEIZHU = bEIZHU;
	}

	private String BEIZHU;

	
	
}