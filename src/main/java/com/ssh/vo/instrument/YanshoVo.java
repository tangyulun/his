package com.ssh.vo.instrument;

import java.util.Date;

public class YanshoVo {
	
	private String instrumentYsId;

	private Date instrumentYsDate;
	
	private String instrumentYsPzdh;

	private String instrumentYsState;
	
	private SupplierVo supplier;

	public SupplierVo getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierVo supplier) {
		this.supplier = supplier;
	}

	public String getInstrumentYsId() {
		return instrumentYsId;
	}

	public void setInstrumentYsId(String instrumentYsId) {
		this.instrumentYsId = instrumentYsId;
	}

	public Date getInstrumentYsDate() {
		return instrumentYsDate;
	}

	public void setInstrumentYsDate(Date instrumentYsDate) {
		this.instrumentYsDate = instrumentYsDate;
	}

	public String getInstrumentYsPzdh() {
		return instrumentYsPzdh;
	}

	public void setInstrumentYsPzdh(String instrumentYsPzdh) {
		this.instrumentYsPzdh = instrumentYsPzdh;
	}

	public String getInstrumentYsState() {
		return instrumentYsState;
	}

	public void setInstrumentYsState(String instrumentYsState) {
		this.instrumentYsState = instrumentYsState;
	}

	public YanshoVo(String instrumentYsId, Date instrumentYsDate, String instrumentYsPzdh, String instrumentYsState) {
		super();
		this.instrumentYsId = instrumentYsId;
		this.instrumentYsDate = instrumentYsDate;
		this.instrumentYsPzdh = instrumentYsPzdh;
		this.instrumentYsState = instrumentYsState;
	}

	public YanshoVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
