package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INSTRUMENT_CAIGOU_XQ database table.
 * 
 */
@Entity
@Table(name="INSTRUMENT_CAIGOU_XQ")
@NamedQuery(name="InstrumentCaigouXq.findAll", query="SELECT i FROM InstrumentCaigouXq i")
public class InstrumentCaigouXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="INSTRUMENT_CAIGOU_XQ_ID")
	private long instrumentCaigouXqId;

	@Column(name="INSTRUMENT_CAIGOU_XQ_MONEY")
	private BigDecimal instrumentCaigouXqMoney;

	@Column(name="INSTRUMENT_CAIGOU_XQ_NUM")
	private BigDecimal instrumentCaigouXqNum;

	@Column(name="INSTRUMENT_CAIGOU_XQ_PH")
	private String instrumentCaigouXqPh;

	@Column(name="INSTRUMENT_CAIGOU_XQ_PRICE")
	private BigDecimal instrumentCaigouXqPrice;

	@Column(name="INSTRUMENT_CAIGOU_XQ_REMARK")
	private String instrumentCaigouXqRemark;

	//bi-directional many-to-one association to Instrument
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_ID")
	private Instrument instrument;

	//bi-directional many-to-one association to InstrumentCaigou
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_CAIGOU_ID")
	private InstrumentCaigou instrumentCaigou;

	public InstrumentCaigouXq() {
	}

	public long getInstrumentCaigouXqId() {
		return this.instrumentCaigouXqId;
	}

	public void setInstrumentCaigouXqId(long instrumentCaigouXqId) {
		this.instrumentCaigouXqId = instrumentCaigouXqId;
	}

	public BigDecimal getInstrumentCaigouXqMoney() {
		return this.instrumentCaigouXqMoney;
	}

	public void setInstrumentCaigouXqMoney(BigDecimal instrumentCaigouXqMoney) {
		this.instrumentCaigouXqMoney = instrumentCaigouXqMoney;
	}

	public BigDecimal getInstrumentCaigouXqNum() {
		return this.instrumentCaigouXqNum;
	}

	public void setInstrumentCaigouXqNum(BigDecimal instrumentCaigouXqNum) {
		this.instrumentCaigouXqNum = instrumentCaigouXqNum;
	}

	public String getInstrumentCaigouXqPh() {
		return this.instrumentCaigouXqPh;
	}

	public void setInstrumentCaigouXqPh(String instrumentCaigouXqPh) {
		this.instrumentCaigouXqPh = instrumentCaigouXqPh;
	}

	public BigDecimal getInstrumentCaigouXqPrice() {
		return this.instrumentCaigouXqPrice;
	}

	public void setInstrumentCaigouXqPrice(BigDecimal instrumentCaigouXqPrice) {
		this.instrumentCaigouXqPrice = instrumentCaigouXqPrice;
	}

	public String getInstrumentCaigouXqRemark() {
		return this.instrumentCaigouXqRemark;
	}

	public void setInstrumentCaigouXqRemark(String instrumentCaigouXqRemark) {
		this.instrumentCaigouXqRemark = instrumentCaigouXqRemark;
	}

	public Instrument getInstrument() {
		return this.instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public InstrumentCaigou getInstrumentCaigou() {
		return this.instrumentCaigou;
	}

	public void setInstrumentCaigou(InstrumentCaigou instrumentCaigou) {
		this.instrumentCaigou = instrumentCaigou;
	}

}