package com.ssh.vo.dean;

import java.math.BigDecimal;

/**
 * 收费项目和药品数据存储
 * @author asus
 * 
 */
public class ShouFeiOrDrugVO {
	private String shoufeiType;
	
	private String xiangmuId;
	
	private String xiangmuName;
	
	private BigDecimal xiangmuNum ;
	
	private BigDecimal xiangmuChengBen;
	
	private BigDecimal xiamgMuPrice;
	
	private BigDecimal xiangmuMoney;
	
	private String times;
	
	private  String xiangmuDanwei;
	
	

	public String getXiangmuDanwei() {
		return xiangmuDanwei;
	}

	public void setXiangmuDanwei(String xiangmuDanwei) {
		this.xiangmuDanwei = xiangmuDanwei;
	}

	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getShoufeiType() {
		return shoufeiType;
	}

	public void setShoufeiType(String shoufeiType) {
		this.shoufeiType = shoufeiType;
	}

	public String getXiangmuId() {
		return xiangmuId;
	}

	public void setXiangmuId(String xiangmuId) {
		this.xiangmuId = xiangmuId;
	}

	public String getXiangmuName() {
		return xiangmuName;
	}

	public void setXiangmuName(String xiangmuName) {
		this.xiangmuName = xiangmuName;
	}

	public BigDecimal getXiangmuNum() {
		return xiangmuNum;
	}

	public void setXiangmuNum(BigDecimal xiangmuNum) {
		this.xiangmuNum = xiangmuNum;
	}

	public BigDecimal getXiangmuChengBen() {
		return xiangmuChengBen;
	}

	public void setXiangmuChengBen(BigDecimal xiangmuChengBen) {
		this.xiangmuChengBen = xiangmuChengBen;
	}

	public BigDecimal getXiamgMuPrice() {
		return xiamgMuPrice;
	}

	public void setXiamgMuPrice(BigDecimal xiamgMuPrice) {
		this.xiamgMuPrice = xiamgMuPrice;
	}

	public BigDecimal getXiangmuMoney() {
		return xiangmuMoney;
	}

	public void setXiangmuMoney(BigDecimal xiangmuMoney) {
		this.xiangmuMoney = xiangmuMoney;
	}

	public ShouFeiOrDrugVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShouFeiOrDrugVO(String shoufeiType, String xiangmuId, String xiangmuName, BigDecimal xiangmuNum,
			BigDecimal xiangmuChengBen, BigDecimal xiamgMuPrice, BigDecimal xiangmuMoney) {
		super();
		this.shoufeiType = shoufeiType;
		this.xiangmuId = xiangmuId;
		this.xiangmuName = xiangmuName;
		this.xiangmuNum = xiangmuNum;
		this.xiangmuChengBen = xiangmuChengBen;
		this.xiamgMuPrice = xiamgMuPrice;
		this.xiangmuMoney = xiangmuMoney;
	}
	
	
}
