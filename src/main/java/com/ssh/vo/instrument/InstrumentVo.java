package com.ssh.vo.instrument;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ssh.vo.drugstorage.UnitVo;

public class InstrumentVo {

	private String instrumentId;

	private BigDecimal instruemntTop;

	private Date instrumentBaofeiDate;

	private BigDecimal instrumentButtom;

	private BigDecimal instrumentChicun;

	private String instrumentName;

	private Date instrumentQiyongDate;

	private String instrumentRemark;

	private BigDecimal instrumentShengNum;

	private BigDecimal instrumentWaijieNum;

	private BigDecimal instrumentZongNum;
	
	private InstrumentTypeVo instrumentType;

	private BigDecimal instrumentPrice;
	
	public BigDecimal getInstrumentPrice() {
		return instrumentPrice;
	}

	public void setInstrumentPrice(BigDecimal instrumentPrice) {
		this.instrumentPrice = instrumentPrice;
	}

	private UnitVo unit;
	
	public UnitVo getUnit() {
		return unit;
	}

	public void setUnit(UnitVo unit) {
		this.unit = unit;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}

	public BigDecimal getInstruemntTop() {
		return instruemntTop;
	}

	public void setInstruemntTop(BigDecimal instruemntTop) {
		this.instruemntTop = instruemntTop;
	}

	public Date getInstrumentBaofeiDate() {
		return instrumentBaofeiDate;
	}

	public void setInstrumentBaofeiDate(Date instrumentBaofeiDate) {
		this.instrumentBaofeiDate = instrumentBaofeiDate;
	}

	public BigDecimal getInstrumentButtom() {
		return instrumentButtom;
	}

	public void setInstrumentButtom(BigDecimal instrumentButtom) {
		this.instrumentButtom = instrumentButtom;
	}

	public BigDecimal getInstrumentChicun() {
		return instrumentChicun;
	}

	public void setInstrumentChicun(BigDecimal instrumentChicun) {
		this.instrumentChicun = instrumentChicun;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public Date getInstrumentQiyongDate() {
		return instrumentQiyongDate;
	}

	public void setInstrumentQiyongDate(Date instrumentQiyongDate) {
		this.instrumentQiyongDate = instrumentQiyongDate;
	}

	public String getInstrumentRemark() {
		return instrumentRemark;
	}

	public void setInstrumentRemark(String instrumentRemark) {
		this.instrumentRemark = instrumentRemark;
	}

	public BigDecimal getInstrumentShengNum() {
		return instrumentShengNum;
	}

	public void setInstrumentShengNum(BigDecimal instrumentShengNum) {
		this.instrumentShengNum = instrumentShengNum;
	}

	public BigDecimal getInstrumentWaijieNum() {
		return instrumentWaijieNum;
	}

	public void setInstrumentWaijieNum(BigDecimal instrumentWaijieNum) {
		this.instrumentWaijieNum = instrumentWaijieNum;
	}

	public BigDecimal getInstrumentZongNum() {
		return instrumentZongNum;
	}

	public void setInstrumentZongNum(BigDecimal instrumentZongNum) {
		this.instrumentZongNum = instrumentZongNum;
	}

	public InstrumentTypeVo getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentTypeVo instrumentType) {
		this.instrumentType = instrumentType;
	}

	public InstrumentVo(String instrumentId, BigDecimal instruemntTop, Date instrumentBaofeiDate,
			BigDecimal instrumentButtom, BigDecimal instrumentChicun, String instrumentName, Date instrumentQiyongDate,
			String instrumentRemark, BigDecimal instrumentShengNum, BigDecimal instrumentWaijieNum,
			BigDecimal instrumentZongNum ,BigDecimal instrumentPrice) {
		super();
		this.instrumentId = instrumentId;
		this.instruemntTop = instruemntTop;
		this.instrumentBaofeiDate = instrumentBaofeiDate;
		this.instrumentButtom = instrumentButtom;
		this.instrumentChicun = instrumentChicun;
		this.instrumentName = instrumentName;
		this.instrumentQiyongDate = instrumentQiyongDate;
		this.instrumentRemark = instrumentRemark;
		this.instrumentShengNum = instrumentShengNum;
		this.instrumentWaijieNum = instrumentWaijieNum;
		this.instrumentZongNum = instrumentZongNum;
		this.instrumentPrice = instrumentPrice;
	}

	public InstrumentVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstrumentVo(String instrumentId, String instrumentName) {
		super();
		this.instrumentId = instrumentId;
		this.instrumentName = instrumentName;
	}

	public InstrumentVo(String instrumentId) {
		super();
		this.instrumentId = instrumentId;
	}

	
}