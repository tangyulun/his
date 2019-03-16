package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DRUG_TUIHUO database table.
 * 
 */
@Entity
@Table(name="DRUG_TUIHUO")
@NamedQuery(name="DrugTuihuo.findAll", query="SELECT d FROM DrugTuihuo d")
public class DrugTuihuo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_TUIHUO_ID")
	private String drugTuihuoId;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_TUIHUO_DATE")
	private Date drugTuihuoDate;

	@Column(name="DRUG_TUIHUO_MONEY")
	private BigDecimal drugTuihuoMoney;

	@Column(name="DRUG_TUIHUO_PZ_ID")
	private String drugTuihuoPzId;

	@Column(name="DRUG_TUIHUO_STATE")
	private String drugTuihuoState;

	//bi-directional many-to-one association to DrugAcceptance
	@ManyToOne
	@JoinColumn(name="DRUG_ACCEPTANCE_ID")
	private DrugAcceptance drugAcceptance;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID")
	private Supplier supplier;

	//bi-directional many-to-one association to DrugTuihuoXq
	@OneToMany(mappedBy="drugTuihuo")
	private List<DrugTuihuoXq> drugTuihuoXqs;

	public DrugTuihuo() {
	}

	public String getDrugTuihuoId() {
		return this.drugTuihuoId;
	}

	public void setDrugTuihuoId(String drugTuihuoId) {
		this.drugTuihuoId = drugTuihuoId;
	}

	public Date getDrugTuihuoDate() {
		return this.drugTuihuoDate;
	}

	public void setDrugTuihuoDate(Date drugTuihuoDate) {
		this.drugTuihuoDate = drugTuihuoDate;
	}

	public BigDecimal getDrugTuihuoMoney() {
		return this.drugTuihuoMoney;
	}

	public void setDrugTuihuoMoney(BigDecimal drugTuihuoMoney) {
		this.drugTuihuoMoney = drugTuihuoMoney;
	}

	public String getDrugTuihuoPzId() {
		return this.drugTuihuoPzId;
	}

	public void setDrugTuihuoPzId(String drugTuihuoPzId) {
		this.drugTuihuoPzId = drugTuihuoPzId;
	}

	public String getDrugTuihuoState() {
		return this.drugTuihuoState;
	}

	public void setDrugTuihuoState(String drugTuihuoState) {
		this.drugTuihuoState = drugTuihuoState;
	}

	public DrugAcceptance getDrugAcceptance() {
		return this.drugAcceptance;
	}

	public void setDrugAcceptance(DrugAcceptance drugAcceptance) {
		this.drugAcceptance = drugAcceptance;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<DrugTuihuoXq> getDrugTuihuoXqs() {
		return this.drugTuihuoXqs;
	}

	public void setDrugTuihuoXqs(List<DrugTuihuoXq> drugTuihuoXqs) {
		this.drugTuihuoXqs = drugTuihuoXqs;
	}

	public DrugTuihuoXq addDrugTuihuoXq(DrugTuihuoXq drugTuihuoXq) {
		getDrugTuihuoXqs().add(drugTuihuoXq);
		drugTuihuoXq.setDrugTuihuo(this);

		return drugTuihuoXq;
	}

	public DrugTuihuoXq removeDrugTuihuoXq(DrugTuihuoXq drugTuihuoXq) {
		getDrugTuihuoXqs().remove(drugTuihuoXq);
		drugTuihuoXq.setDrugTuihuo(null);

		return drugTuihuoXq;
	}

}