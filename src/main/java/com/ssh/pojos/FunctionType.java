package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the FUNCTION_TYPE database table.
 * 
 */
@Entity
@Table(name="FUNCTION_TYPE")
@NamedQuery(name="FunctionType.findAll", query="SELECT f FROM FunctionType f")
public class FunctionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FUNCTION_TYPE_ID")
	private long functionTypeId;

	@Column(name="FUNCTION_TYPE_ICON")
	private String functionTypeIcon;

	@Column(name="FUNCTION_TYPE_NAME")
	private String functionTypeName;

	@Column(name="FUNCTION_TYPE_SHOW_ORDER")
	private BigDecimal functionTypeShowOrder;

	//bi-directional many-to-one association to Function
	@OneToMany(mappedBy="functionType")
	private List<Function> functions;

	public FunctionType() {
	}

	public long getFunctionTypeId() {
		return this.functionTypeId;
	}

	public void setFunctionTypeId(long functionTypeId) {
		this.functionTypeId = functionTypeId;
	}

	public String getFunctionTypeIcon() {
		return this.functionTypeIcon;
	}

	public void setFunctionTypeIcon(String functionTypeIcon) {
		this.functionTypeIcon = functionTypeIcon;
	}

	public String getFunctionTypeName() {
		return this.functionTypeName;
	}

	public void setFunctionTypeName(String functionTypeName) {
		this.functionTypeName = functionTypeName;
	}

	public BigDecimal getFunctionTypeShowOrder() {
		return this.functionTypeShowOrder;
	}

	public void setFunctionTypeShowOrder(BigDecimal functionTypeShowOrder) {
		this.functionTypeShowOrder = functionTypeShowOrder;
	}

	public List<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	public Function addFunction(Function function) {
		getFunctions().add(function);
		function.setFunctionType(this);

		return function;
	}

	public Function removeFunction(Function function) {
		getFunctions().remove(function);
		function.setFunctionType(null);

		return function;
	}

}