package com.ssh.vo.outpatient;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class ParentTypeVo {
	
	@JSONField(name="id")
	private long financialTypeParentId;

	@JSONField(name="text")
	private String financialTypeParentName;
	
	@JSONField(name="children")
	public List<FinancialTypeVo> financialTypeVo;

	public long getFinancialTypeParentId() {
		return financialTypeParentId;
	}

	public void setFinancialTypeParentId(long financialTypeParentId) {
		this.financialTypeParentId = financialTypeParentId;
	}

	public String getFinancialTypeParentName() {
		return financialTypeParentName;
	}

	public void setFinancialTypeParentName(String financialTypeParentName) {
		this.financialTypeParentName = financialTypeParentName;
	}

	public List<FinancialTypeVo> getFinancialTypeVo() {
		return financialTypeVo;
	}

	public void setFinancialTypeVo(List<FinancialTypeVo> financialTypeVo) {
		this.financialTypeVo = financialTypeVo;
	}

	public ParentTypeVo(long financialTypeParentId, String financialTypeParentName,
			List<FinancialTypeVo> financialTypeVo) {
		super();
		this.financialTypeParentId = financialTypeParentId;
		this.financialTypeParentName = financialTypeParentName;
		this.financialTypeVo = financialTypeVo;
	}

	public ParentTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ParentTypeVo [financialTypeParentId=" + financialTypeParentId + ", financialTypeParentName="
				+ financialTypeParentName + ", financialTypeVo=" + financialTypeVo + "]";
	}
	
	
	
}
