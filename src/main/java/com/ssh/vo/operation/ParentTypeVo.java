package com.ssh.vo.operation;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class ParentTypeVo {
	
	@JSONField(name="id")
	private long typeId;
	@JSONField(name="text")
	private String typeName;
	@JSONField(name="children")
	private List<JianyanTypeVo> jyVo;
	public ParentTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ParentTypeVo(long typeId, String typeName, List<JianyanTypeVo> jyVo) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.jyVo = jyVo;
	}
	public long getTypeId() {
		return typeId;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public List<JianyanTypeVo> getJyVo() {
		return jyVo;
	}
	public void setJyVo(List<JianyanTypeVo> jyVo) {
		this.jyVo = jyVo;
	}
	
}
