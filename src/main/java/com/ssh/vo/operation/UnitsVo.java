package com.ssh.vo.operation;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Drug;

public class UnitsVo {

	@JSONField(name="id")
	private long unitsId;

	@JSONField(name="text")
	private String unitsName;

	public long getUnitsId() {
		return unitsId;
	}

	public void setUnitsId(long unitsId) {
		this.unitsId = unitsId;
	}

	public String getUnitsName() {
		return unitsName;
	}

	public void setUnitsName(String unitsName) {
		this.unitsName = unitsName;
	}

	public UnitsVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnitsVo(long unitsId, String unitsName) {
		super();
		this.unitsId = unitsId;
		this.unitsName = unitsName;
	}
	
	
}
