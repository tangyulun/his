package com.ssh.vo.behospitalized;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class BedTypeTypeVo {
	
	@JSONField(name="id")
	private long bedTypeTypeId;
	@JSONField(name="text")
	private String bedTypeTypeName;

	@JSONField(name="children")
	private List<BedTypeVo> bType;
	
	public List<BedTypeVo> getbType() {
		return bType;
	}

	public void setbType(List<BedTypeVo> bType) {
		this.bType = bType;
	}

	public long getBedTypeTypeId() {
		return bedTypeTypeId;
	}

	public void setBedTypeTypeId(long bedTypeTypeId) {
		this.bedTypeTypeId = bedTypeTypeId;
	}

	public String getBedTypeTypeName() {
		return bedTypeTypeName;
	}

	public void setBedTypeTypeName(String bedTypeTypeName) {
		this.bedTypeTypeName = bedTypeTypeName;
	}

	public BedTypeTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BedTypeTypeVo(long bedTypeTypeId, String bedTypeTypeName) {
		super();
		this.bedTypeTypeId = bedTypeTypeId;
		this.bedTypeTypeName = bedTypeTypeName;
	}
	
	
}
