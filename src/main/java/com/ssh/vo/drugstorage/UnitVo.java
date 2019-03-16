package com.ssh.vo.drugstorage;

import java.util.List;

import javax.persistence.Column;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Drug;

public class UnitVo {

	@JSONField(name="id")
	private long unitsId;

	@JSONField(name="text")
	private String unitsName;
	
	private List<Drug> drugs;

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

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public UnitVo(long unitsId, String unitsName) {
		super();
		this.unitsId = unitsId;
		this.unitsName = unitsName;
	}

	public UnitVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UnitVo [unitsId=" + unitsId + ", unitsName=" + unitsName + ", drugs=" + drugs + "]";
	}
	
	
}
