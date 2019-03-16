package com.ssh.vo.instrument;

import java.math.BigDecimal;

public class YanshoxiangqingVo {
	private int CGid; 
	
	private String QXCGID;

	
	private String QXCGNAME;

	
	private BigDecimal SHULIANG;

	
	private String DANWEI;

	
	private BigDecimal DANJIA;

	
	private BigDecimal HEGESHU;
	
	private BigDecimal JINE;
	
	private String BEIZHU;
	
	private BigDecimal BHEGESHU;

	private InstrumentVo instrumentys;
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

	public BigDecimal getHEGESHU() {
		return HEGESHU;
	}

	public void setHEGESHU(BigDecimal hEGESHU) {
		HEGESHU = hEGESHU;
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

	public BigDecimal getBHEGESHU() {
		return BHEGESHU;
	}

	public void setBHEGESHU(BigDecimal bHEGESHU) {
		BHEGESHU = bHEGESHU;
	}

	public YanshoxiangqingVo(int cGid, String qXCGID, String qXCGNAME, BigDecimal sHULIANG, String dANWEI,
			BigDecimal dANJIA, BigDecimal hEGESHU, BigDecimal jINE, String bEIZHU, BigDecimal bHEGESHU) {
		super();
		CGid = cGid;
		QXCGID = qXCGID;
		QXCGNAME = qXCGNAME;
		SHULIANG = sHULIANG;
		DANWEI = dANWEI;
		DANJIA = dANJIA;
		HEGESHU = hEGESHU;
		JINE = jINE;
		BEIZHU = bEIZHU;
		BHEGESHU = bHEGESHU;
	}

	public YanshoxiangqingVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YanshoxiangqingVo(BigDecimal sHULIANG, BigDecimal jINE, String bEIZHU) {
		SHULIANG = sHULIANG;
		JINE = jINE;
		BEIZHU = bEIZHU;
	}

	public InstrumentVo getInstrumentys() {
		return instrumentys;
	}

	public void setInstrumentys(InstrumentVo instrumentys) {
		this.instrumentys = instrumentys;
	}


	
	

}
