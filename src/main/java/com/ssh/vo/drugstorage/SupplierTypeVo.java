package com.ssh.vo.drugstorage;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class SupplierTypeVo {
	@JSONField(name="id")
	private long supplierTypeId;
	@JSONField(name="text")
	private String supplierTypeName;
	
	
	private List<SupplierVo> suppliers;
	

	public List<SupplierVo> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<SupplierVo> suppliers) {
		this.suppliers = suppliers;
	}

	public long getSupplierTypeId() {
		return supplierTypeId;
	}

	public void setSupplierTypeId(long supplierTypeId) {
		this.supplierTypeId = supplierTypeId;
	}

	public String getSupplierTypeName() {
		return supplierTypeName;
	}

	public void setSupplierTypeName(String supplierTypeName) {
		this.supplierTypeName = supplierTypeName;
	}

	
	public SupplierTypeVo(long supplierTypeId, String supplierTypeName) {
		super();
		this.supplierTypeId = supplierTypeId;
		this.supplierTypeName = supplierTypeName;
	}

	public SupplierTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SupplierTypeVo [supplierTypeId=" + supplierTypeId + ", supplierTypeName=" + supplierTypeName + "]";
	}
	
	
}
