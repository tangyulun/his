package com.ssh.vo.instrument;

import com.alibaba.fastjson.annotation.JSONField;

public class InstrumentTypeVo {
	@JSONField(name="id")
	private long instrumentTypeId;

	@JSONField(name="text")
	private String instrumentTypeName;

	public long getInstrumentTypeId() {
		return instrumentTypeId;
	}


	public void setInstrumentTypeId(long instrumentTypeId) {
		this.instrumentTypeId = instrumentTypeId;
	}


	public String getInstrumentTypeName() {
		return instrumentTypeName;
	}


	public void setInstrumentTypeName(String instrumentTypeName) {
		this.instrumentTypeName = instrumentTypeName;
	}


	public InstrumentTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InstrumentTypeVo(long instrumentTypeId, String instrumentTypeName) {
		super();
		this.instrumentTypeId = instrumentTypeId;
		this.instrumentTypeName = instrumentTypeName;
	}


	public InstrumentTypeVo(long instrumentTypeId) {
		super();
		this.instrumentTypeId = instrumentTypeId;
	}
	
}
