package com.ssh.vo.behospitalized;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.ssh.pojos.Bed;

public class HouseTypeVo {
	@JSONField(name="id")
	private long houseTypeId;
	
	@JSONField(name="text")
	private String houseTypeName;

	public long getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(long houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public HouseTypeVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HouseTypeVo(long houseTypeId, String houseTypeName) {
		super();
		this.houseTypeId = houseTypeId;
		this.houseTypeName = houseTypeName;
	}
	
		

}
