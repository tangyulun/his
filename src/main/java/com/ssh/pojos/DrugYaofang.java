package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DRUG_YAOFANG database table.
 * 
 */
@Entity
@Table(name="DRUG_YAOFANG")
@NamedQuery(name="DrugYaofang.findAll", query="SELECT d FROM DrugYaofang d")
public class DrugYaofang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_YAOFANG_ID")
	private String drugYaofangId;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_YAOFANG_DATE")
	private Date drugYaofangDate;

	@Column(name="DRUG_YAOFANG_STATE")
	private String drugYaofangState;

	@Column(name="ZHUYUAN_FAYAO_HOUSE")
	private String zhuyuanFayaoHouse;

	@Column(name="ZHUYUAN_FAYAO_ZMONEY")
	private BigDecimal zhuyuanFayaoZmoney;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRESCRIPTION_ID")
	private Prescription prescription;

	//bi-directional many-to-one association to DrugYaofangXq
	@OneToMany(mappedBy="drugYaofang")
	private List<DrugYaofangXq> drugYaofangXqs;

	public DrugYaofang() {
	}

	public String getDrugYaofangId() {
		return this.drugYaofangId;
	}

	public void setDrugYaofangId(String drugYaofangId) {
		this.drugYaofangId = drugYaofangId;
	}

	public Date getDrugYaofangDate() {
		return this.drugYaofangDate;
	}

	public void setDrugYaofangDate(Date drugYaofangDate) {
		this.drugYaofangDate = drugYaofangDate;
	}

	public String getDrugYaofangState() {
		return this.drugYaofangState;
	}

	public void setDrugYaofangState(String drugYaofangState) {
		this.drugYaofangState = drugYaofangState;
	}

	public String getZhuyuanFayaoHouse() {
		return this.zhuyuanFayaoHouse;
	}

	public void setZhuyuanFayaoHouse(String zhuyuanFayaoHouse) {
		this.zhuyuanFayaoHouse = zhuyuanFayaoHouse;
	}

	public BigDecimal getZhuyuanFayaoZmoney() {
		return this.zhuyuanFayaoZmoney;
	}

	public void setZhuyuanFayaoZmoney(BigDecimal zhuyuanFayaoZmoney) {
		this.zhuyuanFayaoZmoney = zhuyuanFayaoZmoney;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public OutpaitentRegist getOutpaitentRegist() {
		return this.outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public List<DrugYaofangXq> getDrugYaofangXqs() {
		return this.drugYaofangXqs;
	}

	public void setDrugYaofangXqs(List<DrugYaofangXq> drugYaofangXqs) {
		this.drugYaofangXqs = drugYaofangXqs;
	}

	public DrugYaofangXq addDrugYaofangXq(DrugYaofangXq drugYaofangXq) {
		getDrugYaofangXqs().add(drugYaofangXq);
		drugYaofangXq.setDrugYaofang(this);

		return drugYaofangXq;
	}

	public DrugYaofangXq removeDrugYaofangXq(DrugYaofangXq drugYaofangXq) {
		getDrugYaofangXqs().remove(drugYaofangXq);
		drugYaofangXq.setDrugYaofang(null);

		return drugYaofangXq;
	}

}