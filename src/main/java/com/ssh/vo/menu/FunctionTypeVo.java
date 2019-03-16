package com.ssh.vo.menu;

import java.math.BigDecimal;
import java.util.List;

public class FunctionTypeVo {
	
	private long functionTypeId;

	private String functionTypeIcon;

	private String functionTypeName;

	private BigDecimal functionTypeShowOrder;

	private List<FunctionsVo> functions;

	public FunctionTypeVo(long functionTypeId, String functionTypeIcon, String functionTypeName,
			BigDecimal functionTypeShowOrder) {
		super();
		this.functionTypeId = functionTypeId;
		this.functionTypeIcon = functionTypeIcon;
		this.functionTypeName = functionTypeName;
		this.functionTypeShowOrder = functionTypeShowOrder;
	}

	public FunctionTypeVo() {
		super();
	}

	public long getFunctionTypeId() {
		return functionTypeId;
	}

	public String getFunctionTypeIcon() {
		return functionTypeIcon;
	}

	public String getFunctionTypeName() {
		return functionTypeName;
	}

	public BigDecimal getFunctionTypeShowOrder() {
		return functionTypeShowOrder;
	}

	public List<FunctionsVo> getFunctions() {
		return functions;
	}

	public void setFunctionTypeId(long functionTypeId) {
		this.functionTypeId = functionTypeId;
	}

	public void setFunctionTypeIcon(String functionTypeIcon) {
		this.functionTypeIcon = functionTypeIcon;
	}

	public void setFunctionTypeName(String functionTypeName) {
		this.functionTypeName = functionTypeName;
	}

	public void setFunctionTypeShowOrder(BigDecimal functionTypeShowOrder) {
		this.functionTypeShowOrder = functionTypeShowOrder;
	}

	public void setFunctions(List<FunctionsVo> functions) {
		this.functions = functions;
	}
	
	
}
