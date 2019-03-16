package com.ssh.vo.instrument;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;

public class YyanshoxiangqingVo {

	
	private long instrumentYanshouXqId;


	private String instrumentId;

	
	private BigDecimal instrumentYanshouXqBhgeNum;

	
	private BigDecimal instrumentYanshouXqHegeNum;

	
	private BigDecimal instrumentYanshouXqMoney;


	private String instrumentYanshouXqPh;


	private String instrumentYanshouXqRemark;

	
	private BigDecimal instrumentYanshouXqZongNum;

	
	private String instrumentYsId;


	public long getInstrumentYanshouXqId() {
		return instrumentYanshouXqId;
	}


	public void setInstrumentYanshouXqId(long instrumentYanshouXqId) {
		this.instrumentYanshouXqId = instrumentYanshouXqId;
	}


	public String getInstrumentId() {
		return instrumentId;
	}


	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}


	public BigDecimal getInstrumentYanshouXqBhgeNum() {
		return instrumentYanshouXqBhgeNum;
	}


	public void setInstrumentYanshouXqBhgeNum(BigDecimal instrumentYanshouXqBhgeNum) {
		this.instrumentYanshouXqBhgeNum = instrumentYanshouXqBhgeNum;
	}


	public BigDecimal getInstrumentYanshouXqHegeNum() {
		return instrumentYanshouXqHegeNum;
	}


	public void setInstrumentYanshouXqHegeNum(BigDecimal instrumentYanshouXqHegeNum) {
		this.instrumentYanshouXqHegeNum = instrumentYanshouXqHegeNum;
	}


	public BigDecimal getInstrumentYanshouXqMoney() {
		return instrumentYanshouXqMoney;
	}


	public void setInstrumentYanshouXqMoney(BigDecimal instrumentYanshouXqMoney) {
		this.instrumentYanshouXqMoney = instrumentYanshouXqMoney;
	}


	public String getInstrumentYanshouXqPh() {
		return instrumentYanshouXqPh;
	}


	public void setInstrumentYanshouXqPh(String instrumentYanshouXqPh) {
		this.instrumentYanshouXqPh = instrumentYanshouXqPh;
	}


	public String getInstrumentYanshouXqRemark() {
		return instrumentYanshouXqRemark;
	}


	public void setInstrumentYanshouXqRemark(String instrumentYanshouXqRemark) {
		this.instrumentYanshouXqRemark = instrumentYanshouXqRemark;
	}


	public BigDecimal getInstrumentYanshouXqZongNum() {
		return instrumentYanshouXqZongNum;
	}


	public void setInstrumentYanshouXqZongNum(BigDecimal instrumentYanshouXqZongNum) {
		this.instrumentYanshouXqZongNum = instrumentYanshouXqZongNum;
	}


	public String getInstrumentYsId() {
		return instrumentYsId;
	}


	public void setInstrumentYsId(String instrumentYsId) {
		this.instrumentYsId = instrumentYsId;
	}


	public YyanshoxiangqingVo(long instrumentYanshouXqId, String instrumentId, BigDecimal instrumentYanshouXqBhgeNum,
			BigDecimal instrumentYanshouXqHegeNum, BigDecimal instrumentYanshouXqMoney, String instrumentYanshouXqPh,
			String instrumentYanshouXqRemark, BigDecimal instrumentYanshouXqZongNum, String instrumentYsId) {
		super();
		this.instrumentYanshouXqId = instrumentYanshouXqId;
		this.instrumentId = instrumentId;
		this.instrumentYanshouXqBhgeNum = instrumentYanshouXqBhgeNum;
		this.instrumentYanshouXqHegeNum = instrumentYanshouXqHegeNum;
		this.instrumentYanshouXqMoney = instrumentYanshouXqMoney;
		this.instrumentYanshouXqPh = instrumentYanshouXqPh;
		this.instrumentYanshouXqRemark = instrumentYanshouXqRemark;
		this.instrumentYanshouXqZongNum = instrumentYanshouXqZongNum;
		this.instrumentYsId = instrumentYsId;
	}


	public YyanshoxiangqingVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
