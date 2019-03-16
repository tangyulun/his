package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FINANCIAL_TYPE database table.
 * 
 */
@Entity
@Table(name="FINANCIAL_TYPE")
@NamedQuery(name="FinancialType.findAll", query="SELECT f FROM FinancialType f")
public class FinancialType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FINANCIAL_TYPE_ID")
	private String financialTypeId;

	@Column(name="FINANCIAL_TYPE_NAME")
	private String financialTypeName;

	//bi-directional many-to-one association to Financial
	@OneToMany(mappedBy="financialTypeBean")
	private List<Financial> financials;

	public FinancialType() {
	}

	public String getFinancialTypeId() {
		return this.financialTypeId;
	}

	public void setFinancialTypeId(String financialTypeId) {
		this.financialTypeId = financialTypeId;
	}

	public String getFinancialTypeName() {
		return this.financialTypeName;
	}

	public void setFinancialTypeName(String financialTypeName) {
		this.financialTypeName = financialTypeName;
	}

	public List<Financial> getFinancials() {
		return this.financials;
	}

	public void setFinancials(List<Financial> financials) {
		this.financials = financials;
	}

	public Financial addFinancial(Financial financial) {
		getFinancials().add(financial);
		financial.setFinancialTypeBean(this);

		return financial;
	}

	public Financial removeFinancial(Financial financial) {
		getFinancials().remove(financial);
		financial.setFinancialTypeBean(null);

		return financial;
	}

}