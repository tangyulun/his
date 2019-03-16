package com.ssh.vo.finance;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Drug;

public class ParentTypeVo {

	@JSONField(name="id")
	private long parentId;
	
	@JSONField(name="text")
	private String parentName;
	
	@JSONField(name="children")
	private List<FuKuanVo> type;
	
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
	public List<FuKuanVo> getType() {
		return type;
	}
	public void setType(List<FuKuanVo> type) {
		this.type = type;
	}
	public ParentTypeVo(long parentId, String parentName, List<FuKuanVo> type) {
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
