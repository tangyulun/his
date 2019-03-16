package com.ssh.vo.outpatient;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class FinancialTypeVo {
	
	@JSONField(name="id")
	private String financialTypeId;

	@JSONField(name="text")
	private String financialTypeName;

	private List<FinacialVo> financialVos;
	
	public String getFinancialTypeId() {
		return financialTypeId;
	}

	public void setFinancialTypeId(String financialTypeId) {
		this.financialTypeId = financialTypeId;
	}

	public String getFinancialTypeName() {
		return financialTypeName;
	}

	public void setFinancialTypeName(String financialTypeName) {
		this.financialTypeName = financialTypeName;
	}

	
	public List<FinacialVo> getFinancialVos() {
		return financialVos;
	}

	public void setFinancialVos(List<FinacialVo> financialVos) {
		this.financialVos = financialVos;
	}

	public FinancialTypeVo(String financialTypeId, String financialTypeName) {
		super();
		this.financialTypeId = financialTypeId;
		this.financialTypeName = financialTypeName;
	}

	public FinancialTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FinancialTypeVo [financialTypeId=" + financialTypeId + ", financialTypeName=" + financialTypeName + "]";
	}
	
	
}
