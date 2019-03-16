package com.ssh.vo.drugstorage;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Drug;
import com.ssh.pojos.Unit;

public class ParentTypeVo {

	@JSONField(name="id")
	private long parentId;
	
	@JSONField(name="text")
	private String parentName;
	
	@JSONField(name="children")
	private List<SupplierTypeVo> type;
	
	public long getParentId() {
		return parentId;
	}
	public void setParentId(long parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public List<SupplierTypeVo> getType() {
		return type;
	}
	public void setType(List<SupplierTypeVo> type) {
		this.type = type;
	}
	public ParentTypeVo(long parentId, String parentName, List<SupplierTypeVo> type) {
		super();
		this.parentId = parentId;
		this.parentName = parentName;
		this.type = type;
	}
	public ParentTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
