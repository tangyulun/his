package com.ssh.vo.operation;

import java.math.BigDecimal;

import com.ssh.pojos.ShoushuMess;

public class ShouShuXqVo {
	private long shoushuMessXqId;
	
	private BigDecimal shoushuMessXqMoney;
	
	private String shoushuMessXqName;
	
	private BigDecimal shoushuMessXqNum;
	
	private BigDecimal shoushuMessXqPrice;
	
	private String shoushuMessXqResult;
	
	private String shoushuMessXqType;
	
	private ShouShuMessVo shoushuMessBean;

	public long getShoushuMessXqId() {
		return shoushuMessXqId;
	}

	public void setShoushuMessXqId(long shoushuMessXqId) {
		this.shoushuMessXqId = shoushuMessXqId;
	}

	public BigDecimal getShoushuMessXqMoney() {
		return shoushuMessXqMoney;
	}

	public void setShoushuMessXqMoney(BigDecimal shoushuMessXqMoney) {
		this.shoushuMessXqMoney = shoushuMessXqMoney;
	}

	public String getShoushuMessXqName() {
		return shoushuMessXqName;
	}

	public void setShoushuMessXqName(String shoushuMessXqName) {
		this.shoushuMessXqName = shoushuMessXqName;
	}

	public BigDecimal getShoushuMessXqNum() {
		return shoushuMessXqNum;
	}

	public void setShoushuMessXqNum(BigDecimal shoushuMessXqNum) {
		this.shoushuMessXqNum = shoushuMessXqNum;
	}

	public BigDecimal getShoushuMessXqPrice() {
		return shoushuMessXqPrice;
	}

	public void setShoushuMessXqPrice(BigDecimal shoushuMessXqPrice) {
		this.shoushuMessXqPrice = shoushuMessXqPrice;
	}

	public String getShoushuMessXqResult() {
		return shoushuMessXqResult;
	}

	public void setShoushuMessXqResult(String shoushuMessXqResult) {
		this.shoushuMessXqResult = shoushuMessXqResult;
	}

	public String getShoushuMessXqType() {
		return shoushuMessXqType;
	}

	public void setShoushuMessXqType(String shoushuMessXqType) {
		this.shoushuMessXqType = shoushuMessXqType;
	}

	public ShouShuMessVo getShoushuMessBean() {
		return shoushuMessBean;
	}

	public void setShoushuMessBean(ShouShuMessVo shoushuMessBean) {
		this.shoushuMessBean = shoushuMessBean;
	}

	public ShouShuXqVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShouShuXqVo(long shoushuMessXqId, BigDecimal shoushuMessXqMoney, String shoushuMessXqName,
			BigDecimal shoushuMessXqNum, BigDecimal shoushuMessXqPrice, String shoushuMessXqResult,
			String shoushuMessXqType, ShouShuMessVo shoushuMessBean) {
		super();
		this.shoushuMessXqId = shoushuMessXqId;
		this.shoushuMessXqMoney = shoushuMessXqMoney;
		this.shoushuMessXqName = shoushuMessXqName;
		this.shoushuMessXqNum = shoushuMessXqNum;
		this.shoushuMessXqPrice = shoushuMessXqPrice;
		this.shoushuMessXqResult = shoushuMessXqResult;
		this.shoushuMessXqType = shoushuMessXqType;
		this.shoushuMessBean = shoushuMessBean;
	}

	public ShouShuXqVo(long shoushuMessXqId, BigDecimal shoushuMessXqMoney, String shoushuMessXqName,
			BigDecimal shoushuMessXqNum, BigDecimal shoushuMessXqPrice, String shoushuMessXqResult,
			String shoushuMessXqType) {
		super();
		this.shoushuMessXqId = shoushuMessXqId;
		this.shoushuMessXqMoney = shoushuMessXqMoney;
		this.shoushuMessXqName = shoushuMessXqName;
		this.shoushuMessXqNum = shoushuMessXqNum;
		this.shoushuMessXqPrice = shoushuMessXqPrice;
		this.shoushuMessXqResult = shoushuMessXqResult;
		this.shoushuMessXqType = shoushuMessXqType;
	}

	
}
