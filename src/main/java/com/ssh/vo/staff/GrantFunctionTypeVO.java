package com.ssh.vo.staff;

import java.math.BigDecimal;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class GrantFunctionTypeVO {
	
	@JSONField(name="id")
	private long functionTypeId;

	@JSONField(name="text")
	private String functionTypeName;

	@JSONField(name="children")
	private List<GrantFunctionsVO> functions;

	public long getFunctionTypeId() {
		return functionTypeId;
	}

	public String getFunctionTypeName() {
		return functionTypeName;
	}

	public List<GrantFunctionsVO> getFunctions() {
		return functions;
	}

	public void setFunctionTypeId(long functionTypeId) {
		this.functionTypeId = functionTypeId;
	}

	public void setFunctionTypeName(String functionTypeName) {
		this.functionTypeName = functionTypeName;
	}

	public void setFunctions(List<GrantFunctionsVO> functions) {
		this.functions = functions;
	}

	
	public GrantFunctionTypeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GrantFunctionTypeVO(long functionTypeId, String functionTypeName) {
		super();
		this.functionTypeId = functionTypeId;
		this.functionTypeName = functionTypeName;
	}

	
	
}
