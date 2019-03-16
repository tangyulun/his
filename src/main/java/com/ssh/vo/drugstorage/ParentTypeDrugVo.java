package com.ssh.vo.drugstorage;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Drug;

public class ParentTypeDrugVo {
	@JSONField(name="id")
	private long parentdrugId;
	
	@JSONField(name="text")
	private String parentdrugName;
	
	@JSONField(name="children")
	private List<DrugTypeVo> drugs;

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

	public List<DrugTypeVo> getDrugs() {
		return drugs;
	}

	public void setDrugs(List<DrugTypeVo> drugs) {
		this.drugs = drugs;
	}

	public ParentTypeDrugVo(long parentdrugId, String parentdrugName, List<DrugTypeVo> drugs) {
		super();
		this.parentdrugId = parentdrugId;
		this.parentdrugName = parentdrugName;
		this.drugs = drugs;
	}

	public ParentTypeDrugVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
