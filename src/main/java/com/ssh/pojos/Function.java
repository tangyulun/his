package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the FUNCTIONS database table.
 * 
 */
@Entity
@Table(name="FUNCTIONS")
@NamedQuery(name="Function.findAll", query="SELECT f FROM Function f")
public class Function implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FUNCTIONS_ID")
	private long functionsId;

	@Column(name="FUNCTIONS_HREF")
	private String functionsHref;

	@Column(name="FUNCTIONS_ICON")
	private String functionsIcon;

	@Column(name="FUNCTIONS_IS_SHOW_LEFT")
	private BigDecimal functionsIsShowLeft;

	@Column(name="FUNCTIONS_NAME")
	private String functionsName;

	@Column(name="FUNCTIONS_SHOW_ORDER")
	private BigDecimal functionsShowOrder;

	//bi-directional many-to-one association to FunctionType
	@ManyToOne
	@JoinColumn(name="FUNCTION_TYPE_ID")
	private FunctionType functionType;

	//bi-directional many-to-many association to Role
	@ManyToMany(mappedBy="functions")
	private List<Role> roles;

	public Function() {
	}

	public long getFunctionsId() {
		return this.functionsId;
	}

	public void setFunctionsId(long functionsId) {
		this.functionsId = functionsId;
	}

	public String getFunctionsHref() {
		return this.functionsHref;
	}

	public void setFunctionsHref(String functionsHref) {
		this.functionsHref = functionsHref;
	}

	public String getFunctionsIcon() {
		return this.functionsIcon;
	}

	public void setFunctionsIcon(String functionsIcon) {
		this.functionsIcon = functionsIcon;
	}

	public BigDecimal getFunctionsIsShowLeft() {
		return this.functionsIsShowLeft;
	}

	public void setFunctionsIsShowLeft(BigDecimal functionsIsShowLeft) {
		this.functionsIsShowLeft = functionsIsShowLeft;
	}

	public String getFunctionsName() {
		return this.functionsName;
	}

	public void setFunctionsName(String functionsName) {
		this.functionsName = functionsName;
	}

	public BigDecimal getFunctionsShowOrder() {
		return this.functionsShowOrder;
	}

	public void setFunctionsShowOrder(BigDecimal functionsShowOrder) {
		this.functionsShowOrder = functionsShowOrder;
	}

	public FunctionType getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(FunctionType functionType) {
		this.functionType = functionType;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}