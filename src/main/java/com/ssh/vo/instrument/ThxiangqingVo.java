package com.ssh.vo.instrument;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;

public class ThxiangqingVo {

	private long qxReturngoosqxId;


	private String qxReturngoosqxBeizu;

	
	private BigDecimal qxReturngoosqxMoney;

	
	private BigDecimal qxReturngoosqxNumber;

	
	private BigDecimal qxReturngoosqxPrice;

	
	private String qxReturngoosqxXqname;


	public long getQxReturngoosqxId() {
		return qxReturngoosqxId;
	}


	public void setQxReturngoosqxId(long qxReturngoosqxId) {
		this.qxReturngoosqxId = qxReturngoosqxId;
	}


	public String getQxReturngoosqxBeizu() {
		return qxReturngoosqxBeizu;
	}


	public void setQxReturngoosqxBeizu(String qxReturngoosqxBeizu) {
		this.qxReturngoosqxBeizu = qxReturngoosqxBeizu;
	}


	public BigDecimal getQxReturngoosqxMoney() {
		return qxReturngoosqxMoney;
	}


	public void setQxReturngoosqxMoney(BigDecimal qxReturngoosqxMoney) {
		this.qxReturngoosqxMoney = qxReturngoosqxMoney;
	}


	public BigDecimal getQxReturngoosqxNumber() {
		return qxReturngoosqxNumber;
	}


	public void setQxReturngoosqxNumber(BigDecimal qxReturngoosqxNumber) {
		this.qxReturngoosqxNumber = qxReturngoosqxNumber;
	}


	public BigDecimal getQxReturngoosqxPrice() {
		return qxReturngoosqxPrice;
	}


	public void setQxReturngoosqxPrice(BigDecimal qxReturngoosqxPrice) {
		this.qxReturngoosqxPrice = qxReturngoosqxPrice;
	}


	public String getQxReturngoosqxXqname() {
		return qxReturngoosqxXqname;
	}


	public void setQxReturngoosqxXqname(String qxReturngoosqxXqname) {
		this.qxReturngoosqxXqname = qxReturngoosqxXqname;
	}


	public ThxiangqingVo(long qxReturngoosqxId, String qxReturngoosqxBeizu, BigDecimal qxReturngoosqxMoney,
			BigDecimal qxReturngoosqxNumber, BigDecimal qxReturngoosqxPrice, String qxReturngoosqxXqname) {
		super();
		this.qxReturngoosqxId = qxReturngoosqxId;
		this.qxReturngoosqxBeizu = qxReturngoosqxBeizu;
		this.qxReturngoosqxMoney = qxReturngoosqxMoney;
		this.qxReturngoosqxNumber = qxReturngoosqxNumber;
		this.qxReturngoosqxPrice = qxReturngoosqxPrice;
		this.qxReturngoosqxXqname = qxReturngoosqxXqname;
	}


	public ThxiangqingVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}
