package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FINANCE_SUMUP database table.
 * 
 */
@Entity
@Table(name="FINANCE_SUMUP")
@NamedQuery(name="FinanceSumup.findAll", query="SELECT f FROM FinanceSumup f")
public class FinanceSumup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FINANCE_SUMUP_ID")
	private String financeSumupId;

	@Temporal(TemporalType.DATE)
	@Column(name="FINANCE_SUMUP_DISPOSE_DATE")
	private Date financeSumupDisposeDate;

	@Temporal(TemporalType.DATE)
	@Column(name="FINANCE_SUMUP_DISPOSE_TIME")
	private Date financeSumupDisposeTime;

	@Column(name="FINANCE_SUMUP_IS")
	private String financeSumupIs;

	@Column(name="FINANCE_SUMUP_SMONEY")
	private BigDecimal financeSumupSmoney;

	@Column(name="FINANCE_SUMUP_TYPE")
	private String financeSumupType;

	@Column(name="FINANCE_SUMUP_YMONEY")
	private BigDecimal financeSumupYmoney;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	public FinanceSumup() {
	}

	public String getFinanceSumupId() {
		return this.financeSumupId;
	}

	public void setFinanceSumupId(String financeSumupId) {
		this.financeSumupId = financeSumupId;
	}

	public Date getFinanceSumupDisposeDate() {
		return this.financeSumupDisposeDate;
	}

	public void setFinanceSumupDisposeDate(Date financeSumupDisposeDate) {
		this.financeSumupDisposeDate = financeSumupDisposeDate;
	}

	public Date getFinanceSumupDisposeTime() {
		return this.financeSumupDisposeTime;
	}

	public void setFinanceSumupDisposeTime(Date financeSumupDisposeTime) {
		this.financeSumupDisposeTime = financeSumupDisposeTime;
	}

	public String getFinanceSumupIs() {
		return this.financeSumupIs;
	}

	public void setFinanceSumupIs(String financeSumupIs) {
		this.financeSumupIs = financeSumupIs;
	}

	public BigDecimal getFinanceSumupSmoney() {
		return this.financeSumupSmoney;
	}

	public void setFinanceSumupSmoney(BigDecimal financeSumupSmoney) {
		this.financeSumupSmoney = financeSumupSmoney;
	}

	public String getFinanceSumupType() {
		return this.financeSumupType;
	}

	public void setFinanceSumupType(String financeSumupType) {
		this.financeSumupType = financeSumupType;
	}

	public BigDecimal getFinanceSumupYmoney() {
		return this.financeSumupYmoney;
	}

	public void setFinanceSumupYmoney(BigDecimal financeSumupYmoney) {
		this.financeSumupYmoney = financeSumupYmoney;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}