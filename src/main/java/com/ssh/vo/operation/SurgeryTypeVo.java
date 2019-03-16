package com.ssh.vo.operation;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class SurgeryTypeVo {
	@JSONField(name="id")
	private long typeId;
	@JSONField(name="text")
	private String typeName;
	@JSONField(name="children")
	private List<ShouShuTypeVo> ssVo;
	public SurgeryTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SurgeryTypeVo(long typeId, String typeName, List<ShouShuTypeVo> ssVo) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.ssVo = ssVo;
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
	public List<ShouShuTypeVo> getSsVo() {
		return ssVo;
	}
	public void setSsVo(List<ShouShuTypeVo> ssVo) {
		this.ssVo = ssVo;
	}
	
}
