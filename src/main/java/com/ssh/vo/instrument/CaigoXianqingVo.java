package com.ssh.vo.instrument;

import java.math.BigDecimal;



public class CaigoXianqingVo {
	
	private long instrumentCaigouXqId;


	private BigDecimal instrumentCaigouXqMoney;


	private BigDecimal instrumentCaigouXqNum;


	private String instrumentCaigouXqPh;


	private BigDecimal instrumentCaigouXqPrice;

	
	private String instrumentCaigouXqRemark;

	private InstrumentVo instrument;

	private InstrumentCaigouVo instrumentcg;

	public long getInstrumentCaigouXqId() {
		
		return instrumentCaigouXqId;
	}

	public void setInstrumentCaigouXqId(long instrumentCaigouXqId) {
		this.instrumentCaigouXqId = instrumentCaigouXqId;
	}

	public BigDecimal getInstrumentCaigouXqMoney() {
		return instrumentCaigouXqMoney;
	}

	public void setInstrumentCaigouXqMoney(BigDecimal instrumentCaigouXqMoney) {
		this.instrumentCaigouXqMoney = instrumentCaigouXqMoney;
	}

	public BigDecimal getInstrumentCaigouXqNum() {
		return instrumentCaigouXqNum;
	}

	public void setInstrumentCaigouXqNum(BigDecimal instrumentCaigouXqNum) {
		this.instrumentCaigouXqNum = instrumentCaigouXqNum;
	}

	public String getInstrumentCaigouXqPh() {
		return instrumentCaigouXqPh;
	}

	public void setInstrumentCaigouXqPh(String instrumentCaigouXqPh) {
		this.instrumentCaigouXqPh = instrumentCaigouXqPh;
	}

	public BigDecimal getInstrumentCaigouXqPrice() {
		return instrumentCaigouXqPrice;
	}

	public void setInstrumentCaigouXqPrice(BigDecimal instrumentCaigouXqPrice) {
		this.instrumentCaigouXqPrice = instrumentCaigouXqPrice;
	}

	public String getInstrumentCaigouXqRemark() {
		return instrumentCaigouXqRemark;
	}

	public void setInstrumentCaigouXqRemark(String instrumentCaigouXqRemark) {
		this.instrumentCaigouXqRemark = instrumentCaigouXqRemark;
	}

	public InstrumentVo getInstrument() {
		return instrument;
	}

	public void setInstrument(InstrumentVo instrument) {
		this.instrument = instrument;
	}

	public InstrumentCaigouVo getInstrumentcg() {
		return instrumentcg;
	}

	public void setInstrumentcg(InstrumentCaigouVo instrumentcg) {
		this.instrumentcg = instrumentcg;
	}

	public CaigoXianqingVo(long instrumentCaigouXqId, BigDecimal instrumentCaigouXqMoney,
			BigDecimal instrumentCaigouXqNum, String instrumentCaigouXqPh, BigDecimal instrumentCaigouXqPrice,
			String instrumentCaigouXqRemark, InstrumentVo instrument, InstrumentCaigouVo instrumentcg) {
		super();
		this.instrumentCaigouXqId = instrumentCaigouXqId;
		this.instrumentCaigouXqMoney = instrumentCaigouXqMoney;
		this.instrumentCaigouXqNum = instrumentCaigouXqNum;
		this.instrumentCaigouXqPh = instrumentCaigouXqPh;
		this.instrumentCaigouXqPrice = instrumentCaigouXqPrice;
		this.instrumentCaigouXqRemark = instrumentCaigouXqRemark;
		this.instrument = instrument;
		this.instrumentcg = instrumentcg;
	}

	public CaigoXianqingVo(long instrumentCaigouXqId, BigDecimal instrumentCaigouXqMoney,
			BigDecimal instrumentCaigouXqNum, String instrumentCaigouXqPh, BigDecimal instrumentCaigouXqPrice,
			String instrumentCaigouXqRemark) {
		super();
		this.instrumentCaigouXqId = instrumentCaigouXqId;
		this.instrumentCaigouXqMoney = instrumentCaigouXqMoney;
		this.instrumentCaigouXqNum = instrumentCaigouXqNum;
		this.instrumentCaigouXqPh = instrumentCaigouXqPh;
		this.instrumentCaigouXqPrice = instrumentCaigouXqPrice;
		this.instrumentCaigouXqRemark = instrumentCaigouXqRemark;
	}

	public CaigoXianqingVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CaigoXianqingVo(InstrumentCaigouVo instrumentcg) {
		super();
		this.instrumentcg = instrumentcg;
	}

	
}
