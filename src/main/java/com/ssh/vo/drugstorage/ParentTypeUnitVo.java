package com.ssh.vo.drugstorage;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Drug;
import com.ssh.pojos.Unit;

public class ParentTypeUnitVo {
	@JSONField(name="id")
	private long parentdrugId;
	
	@JSONField(name="text")
	private String parentdrugName;
	
	@JSONField(name="children")
	private List<UnitVo> unit;

	public long getParentdrugId() {
		return parentdrugId;
	}

	public void setParentdrugId(long parentdrugId) {
		this.parentdrugId = parentdrugId;
	}

	public String getParentdrugName() {
		return parentdrugName;
	}

	public void setParentdrugName(String parentdrugName) {
		this.parentdrugName = parentdrugName;
	}

	public List<UnitVo> getUnit() {
		return unit;
	}

	public void setUnit(List<UnitVo> unit) {
		this.unit = unit;
	}

	public ParentTypeUnitVo(long parentdrugId, String parentdrugName, List<UnitVo> unit) {
		super();
		this.parentdrugId = parentdrugId;
		this.parentdrugName = parentdrugName;
		this.unit = unit;
	}

	public ParentTypeUnitVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
