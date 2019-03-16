package com.ssh.vo.behospitalized;

import javax.persistence.Column;
import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

public class BedTypeVo {
	@JSONField(name="id")
	private long bedTypeId;
	@JSONField(name="text")
	private String bedTypeName;

	public long getBedTypeId() {
		return bedTypeId;
	}

	public void setBedTypeId(long bedTypeId) {
		this.bedTypeId = bedTypeId;
	}

	public String getBedTypeName() {
		return bedTypeName;
	}

	public void setBedTypeName(String bedTypeName) {
		this.bedTypeName = bedTypeName;
	}

	public BedTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BedTypeVo(long bedTypeId, String bedTypeName) {
		super();
		this.bedTypeId = bedTypeId;
		this.bedTypeName = bedTypeName;
	}
	
	
}
