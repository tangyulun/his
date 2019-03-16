package com.ssh.vo.instrument;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;

public class InstrumentYanshoxiangqiangVo {
	
	private long instrumentYanshouXqId;


	private BigDecimal instrumentYanshouXqMoney;

	private String instrumentYanshouXqRemark;

	
	private BigDecimal instrumentYanshouXqZongNum;

	private InstrumentVo instrument;
	
	private InstrumentCaigouVo instrumentCaigou;

	public long getInstrumentYanshouXqId() {
		return instrumentYanshouXqId;
	}

	public void setInstrumentYanshouXqId(long instrumentYanshouXqId) {
		this.instrumentYanshouXqId = instrumentYanshouXqId;
	}

	public BigDecimal getInstrumentYanshouXqMoney() {
		return instrumentYanshouXqMoney;
	}

	public void setInstrumentYanshouXqMoney(BigDecimal instrumentYanshouXqMoney) {
		this.instrumentYanshouXqMoney = instrumentYanshouXqMoney;
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

	public InstrumentVo getInstrument() {
		return instrument;
	}

	public void setInstrument(InstrumentVo instrument) {
		this.instrument = instrument;
	}

	public InstrumentCaigouVo getInstrumentCaigou() {
		return instrumentCaigou;
	}

	public void setInstrumentCaigou(InstrumentCaigouVo instrumentCaigou) {
		this.instrumentCaigou = instrumentCaigou;
	}

	public InstrumentYanshoxiangqiangVo(long instrumentYanshouXqId, BigDecimal instrumentYanshouXqMoney,
			String instrumentYanshouXqRemark, BigDecimal instrumentYanshouXqZongNum, InstrumentVo instrument,
			InstrumentCaigouVo instrumentCaigou) {
		super();
		this.instrumentYanshouXqId = instrumentYanshouXqId;
		this.instrumentYanshouXqMoney = instrumentYanshouXqMoney;
		this.instrumentYanshouXqRemark = instrumentYanshouXqRemark;
		this.instrumentYanshouXqZongNum = instrumentYanshouXqZongNum;
		this.instrument = instrument;
		this.instrumentCaigou = instrumentCaigou;
	}

	public InstrumentYanshoxiangqiangVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstrumentYanshoxiangqiangVo(long instrumentYanshouXqId, BigDecimal instrumentYanshouXqMoney,
			String instrumentYanshouXqRemark, BigDecimal instrumentYanshouXqZongNum) {
		super();
		this.instrumentYanshouXqId = instrumentYanshouXqId;
		this.instrumentYanshouXqMoney = instrumentYanshouXqMoney;
		this.instrumentYanshouXqRemark = instrumentYanshouXqRemark;
		this.instrumentYanshouXqZongNum = instrumentYanshouXqZongNum;
	}

	
	
}
