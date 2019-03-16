package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INSTRUMENT_YANSHOU_XQ database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_YANSHOU_XQ")
@NamedQuery(name="InstrumentYanshouXq.findAll", query="SELECT i FROM InstrumentYanshouXq i")
public class InstrumentYanshouXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_YANSHOU_XQ_ID")
	private long instrumentYanshouXqId;

	@Column(name="INSTRUMENT_ID")
	private String instrumentId;

	@Column(name="INSTRUMENT_YANSHOU_XQ_BHGE_NUM")
	private BigDecimal instrumentYanshouXqBhgeNum;

	@Column(name="INSTRUMENT_YANSHOU_XQ_HEGE_NUM")
	private BigDecimal instrumentYanshouXqHegeNum;

	@Column(name="INSTRUMENT_YANSHOU_XQ_MONEY")
	private BigDecimal instrumentYanshouXqMoney;

	@Column(name="INSTRUMENT_YANSHOU_XQ_PH")
	private String instrumentYanshouXqPh;

	@Column(name="INSTRUMENT_YANSHOU_XQ_REMARK")
	private String instrumentYanshouXqRemark;

	@Column(name="INSTRUMENT_YANSHOU_XQ_ZONG_NUM")
	private BigDecimal instrumentYanshouXqZongNum;

	@Column(name="INSTRUMENT_YS_ID")
	private String instrumentYsId;

	public InstrumentYanshouXq() {
	}

	public long getInstrumentYanshouXqId() {
		return this.instrumentYanshouXqId;
	}

	public void setInstrumentYanshouXqId(long instrumentYanshouXqId) {
		this.instrumentYanshouXqId = instrumentYanshouXqId;
	}

	public String getInstrumentId() {
		return this.instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public BigDecimal getInstrumentYanshouXqBhgeNum() {
		return this.instrumentYanshouXqBhgeNum;
	}

	public void setInstrumentYanshouXqBhgeNum(BigDecimal instrumentYanshouXqBhgeNum) {
		this.instrumentYanshouXqBhgeNum = instrumentYanshouXqBhgeNum;
	}

	public BigDecimal getInstrumentYanshouXqHegeNum() {
		return this.instrumentYanshouXqHegeNum;
	}

	public void setInstrumentYanshouXqHegeNum(BigDecimal instrumentYanshouXqHegeNum) {
		this.instrumentYanshouXqHegeNum = instrumentYanshouXqHegeNum;
	}

	public BigDecimal getInstrumentYanshouXqMoney() {
		return this.instrumentYanshouXqMoney;
	}

	public void setInstrumentYanshouXqMoney(BigDecimal instrumentYanshouXqMoney) {
		this.instrumentYanshouXqMoney = instrumentYanshouXqMoney;
	}

	public String getInstrumentYanshouXqPh() {
		return this.instrumentYanshouXqPh;
	}

	public void setInstrumentYanshouXqPh(String instrumentYanshouXqPh) {
		this.instrumentYanshouXqPh = instrumentYanshouXqPh;
	}

	public String getInstrumentYanshouXqRemark() {
		return this.instrumentYanshouXqRemark;
	}

	public void setInstrumentYanshouXqRemark(String instrumentYanshouXqRemark) {
		this.instrumentYanshouXqRemark = instrumentYanshouXqRemark;
	}

	public BigDecimal getInstrumentYanshouXqZongNum() {
		return this.instrumentYanshouXqZongNum;
	}

	public void setInstrumentYanshouXqZongNum(BigDecimal instrumentYanshouXqZongNum) {
		this.instrumentYanshouXqZongNum = instrumentYanshouXqZongNum;
	}

	public String getInstrumentYsId() {
		return this.instrumentYsId;
	}

	public void setInstrumentYsId(String instrumentYsId) {
		this.instrumentYsId = instrumentYsId;
	}

}