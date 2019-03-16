package com.ssh.vo.finance;

import javax.persistence.Column;
import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

public class FuKuanVo {
	@JSONField(name="id")
	private long fukuanId;

	@JSONField(name="text")
	private String fukuanName;

	public long getFukuanId() {
		return fukuanId;
	}

	public void setFukuanId(long fukuanId) {
		this.fukuanId = fukuanId;
	}

	public String getFukuanName() {
		return fukuanName;
	}

	public void setFukuanName(String fukuanName) {
		this.fukuanName = fukuanName;
	}

	public FuKuanVo(long fukuanId, String fukuanName) {
		super();
		this.fukuanId = fukuanId;
		this.fukuanName = fukuanName;
	}
	
	
}
