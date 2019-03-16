package com.ssh.vo.menu;

import java.math.BigDecimal;

public class FunctionsVo {
	private long functionsId;

	private String functionsHref;

	private String functionsIcon;

	private BigDecimal functionsIsShowLeft;

	private String functionsName;

	private BigDecimal functionsShowOrder;

	private FunctionTypeVo functionTypeVo;

	public FunctionsVo(long functionsId, String functionsHref, String functionsIcon, BigDecimal functionsIsShowLeft,
			String functionsName, BigDecimal functionsShowOrder) {
		super();
		this.functionsId = functionsId;
		this.functionsHref = functionsHref;
		this.functionsIcon = functionsIcon;
		this.functionsIsShowLeft = functionsIsShowLeft;
		this.functionsName = functionsName;
		this.functionsShowOrder = functionsShowOrder;
	}

	public FunctionsVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getFunctionsId() {
		return functionsId;
	}

	public String getFunctionsHref() {
		return functionsHref;
	}

	public String getFunctionsIcon() {
		return functionsIcon;
	}

	public BigDecimal getFunctionsIsShowLeft() {
		return functionsIsShowLeft;
	}

	public String getFunctionsName() {
		return functionsName;
	}

	public BigDecimal getFunctionsShowOrder() {
		return functionsShowOrder;
	}

	public FunctionTypeVo getFunctionTypeVo() {
		return functionTypeVo;
	}

	public void setFunctionsId(long functionsId) {
		this.functionsId = functionsId;
	}

	public void setFunctionsHref(String functionsHref) {
		this.functionsHref = functionsHref;
	}

	public void setFunctionsIcon(String functionsIcon) {
		this.functionsIcon = functionsIcon;
	}

	public void setFunctionsIsShowLeft(BigDecimal functionsIsShowLeft) {
		this.functionsIsShowLeft = functionsIsShowLeft;
	}

	public void setFunctionsName(String functionsName) {
		this.functionsName = functionsName;
	}

	public void setFunctionsShowOrder(BigDecimal functionsShowOrder) {
		this.functionsShowOrder = functionsShowOrder;
	}

	public void setFunctionTypeVo(FunctionTypeVo functionTypeVo) {
		this.functionTypeVo = functionTypeVo;
	}

	public FunctionsVo(long functionsId, String functionsName) {
		super();
		this.functionsId = functionsId;
		this.functionsName = functionsName;
	}
	
	
}
