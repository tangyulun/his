package com.ssh.vo.drugstorage;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Drug;

public class DrugTypeVo {
	
	@JSONField(name="id")
	private long drugTypeId;

	@JSONField(name="text")
	private String drugTypeName;

	private List<Drug> drugs;

	public long getDrugTypeId() {
		return drugTypeId;
	}

	public void setDrugTypeId(long drugTypeId) {
		this.drugTypeId = drugTypeId;
	}

	public String getDrugTypeName() {
		return drugTypeName;
	}

	public void setDrugTypeName(String drugTypeName) {
		this.drugTypeName = drugTypeName;
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public DrugTypeVo(long drugTypeId, String drugTypeName) {
		super();
		this.drugTypeId = drugTypeId;
		this.drugTypeName = drugTypeName;
	}

	public DrugTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DrugTypeVo [drugTypeId=" + drugTypeId + ", drugTypeName=" + drugTypeName + ", drugs=" + drugs + "]";
	}
	
	
}
