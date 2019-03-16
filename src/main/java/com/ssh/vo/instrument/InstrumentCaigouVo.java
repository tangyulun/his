package com.ssh.vo.instrument;

import java.math.BigDecimal;
import java.util.Date;

import com.ssh.pojos.InstrumentCaigou;
import com.ssh.vo.instrument.SupplierVo;


public class InstrumentCaigouVo {
	private String instrumentCaigouId;
	private String instrumentCaigouAddress;
	private Date instrumentCaigouDhDate;
	private Date instrumentCaigouGhDate;
	private BigDecimal instrumentCaigouMoney;
	private String instrumentCaigouState;
	
	private SupplierVo supplier;

	public String getInstrumentCaigouId() {
		return instrumentCaigouId;
	}

	public void setInstrumentCaigouId(String instrumentCaigouId) {
		this.instrumentCaigouId = instrumentCaigouId;
	}

	public String getInstrumentCaigouAddress() {
		return instrumentCaigouAddress;
	}

	public void setInstrumentCaigouAddress(String instrumentCaigouAddress) {
		this.instrumentCaigouAddress = instrumentCaigouAddress;
	}

	public Date getInstrumentCaigouDhDate() {
		return instrumentCaigouDhDate;
	}

	public void setInstrumentCaigouDhDate(Date instrumentCaigouDhDate) {
		this.instrumentCaigouDhDate = instrumentCaigouDhDate;
	}

	public Date getInstrumentCaigouGhDate() {
		return instrumentCaigouGhDate;
	}

	public void setInstrumentCaigouGhDate(Date instrumentCaigouGhDate) {
		this.instrumentCaigouGhDate = instrumentCaigouGhDate;
	}

	public BigDecimal getInstrumentCaigouMoney() {
		return instrumentCaigouMoney;
	}

	public void setInstrumentCaigouMoney(BigDecimal instrumentCaigouMoney) {
		this.instrumentCaigouMoney = instrumentCaigouMoney;
	}

	public String getInstrumentCaigouState() {
		return instrumentCaigouState;
	}

	public void setInstrumentCaigouState(String instrumentCaigouState) {
		this.instrumentCaigouState = instrumentCaigouState;
	}

	public SupplierVo getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierVo supplier) {
		this.supplier = supplier;
	}

	public InstrumentCaigouVo(String instrumentCaigouId, String instrumentCaigouAddress, Date instrumentCaigouDhDate,
			Date instrumentCaigouGhDate, BigDecimal instrumentCaigouMoney, String instrumentCaigouState) {
		super();
		this.instrumentCaigouId = instrumentCaigouId;
		this.instrumentCaigouAddress = instrumentCaigouAddress;
		this.instrumentCaigouDhDate = instrumentCaigouDhDate;
		this.instrumentCaigouGhDate = instrumentCaigouGhDate;
		this.instrumentCaigouMoney = instrumentCaigouMoney;
		this.instrumentCaigouState = instrumentCaigouState;
	}

	public InstrumentCaigouVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstrumentCaigouVo(BigDecimal instrumentCaigouMoney) {
		super();
		this.instrumentCaigouMoney = instrumentCaigouMoney;
	}

	public InstrumentCaigouVo(String instrumentCaigouId) {
		super();
		this.instrumentCaigouId = instrumentCaigouId;
	}



	
}
