package com.ssh.vo.instrument;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class ParentTypeVo {
	@JSONField(name="id")
	private long typeId;
	@JSONField(name="text")
	private String typeName;
	
	@JSONField(name="children")
	private List<InstrumentTypeVo>  inVo;

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

	public List<InstrumentTypeVo> getInVo() {
		return inVo;
	}

	public void setInVo(List<InstrumentTypeVo> inVo) {
		this.inVo = inVo;
	}

	public ParentTypeVo(long typeId, String typeName, List<InstrumentTypeVo> inVo) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.inVo = inVo;
	}

	public ParentTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
