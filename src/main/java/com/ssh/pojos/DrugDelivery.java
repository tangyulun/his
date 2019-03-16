package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DRUG_DELIVERY database table.
 * 
 */
@Entity
@Table(name="DRUG_DELIVERY")
@NamedQuery(name="DrugDelivery.findAll", query="SELECT d FROM DrugDelivery d")
public class DrugDelivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_DELIVERY_ID")
	private String drugDeliveryId;

	@Column(name="DRUG_DELIVERY_CGY")
	private String drugDeliveryCgy;

	@Column(name="DRUG_DELIVERY_CK")
	private String drugDeliveryCk;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_DELIVERY_CKDATE")
	private Date drugDeliveryCkdate;

	@Column(name="DRUG_DELIVERY_CKDX")
	private String drugDeliveryCkdx;

	@Column(name="DRUG_DELIVERY_CKLX")
	private String drugDeliveryCklx;

	@Column(name="DRUG_DELIVERY_PZDH")
	private String drugDeliveryPzdh;

	@Column(name="DRUG_DELIVERY_ZT")
	private String drugDeliveryZt;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to DrugDeliveryDetali
	@OneToMany(mappedBy="drugDelivery")
	private List<DrugDeliveryDetali> drugDeliveryDetalis;

	public DrugDelivery() {
	}

	public String getDrugDeliveryId() {
		return this.drugDeliveryId;
	}

	public void setDrugDeliveryId(String drugDeliveryId) {
		this.drugDeliveryId = drugDeliveryId;
	}

	public String getDrugDeliveryCgy() {
		return this.drugDeliveryCgy;
	}

	public void setDrugDeliveryCgy(String drugDeliveryCgy) {
		this.drugDeliveryCgy = drugDeliveryCgy;
	}

	public String getDrugDeliveryCk() {
		return this.drugDeliveryCk;
	}

	public void setDrugDeliveryCk(String drugDeliveryCk) {
		this.drugDeliveryCk = drugDeliveryCk;
	}

	public Date getDrugDeliveryCkdate() {
		return this.drugDeliveryCkdate;
	}

	public void setDrugDeliveryCkdate(Date drugDeliveryCkdate) {
		this.drugDeliveryCkdate = drugDeliveryCkdate;
	}

	public String getDrugDeliveryCkdx() {
		return this.drugDeliveryCkdx;
	}

	public void setDrugDeliveryCkdx(String drugDeliveryCkdx) {
		this.drugDeliveryCkdx = drugDeliveryCkdx;
	}

	public String getDrugDeliveryCklx() {
		return this.drugDeliveryCklx;
	}

	public void setDrugDeliveryCklx(String drugDeliveryCklx) {
		this.drugDeliveryCklx = drugDeliveryCklx;
	}

	public String getDrugDeliveryPzdh() {
		return this.drugDeliveryPzdh;
	}

	public void setDrugDeliveryPzdh(String drugDeliveryPzdh) {
		this.drugDeliveryPzdh = drugDeliveryPzdh;
	}

	public String getDrugDeliveryZt() {
		return this.drugDeliveryZt;
	}

	public void setDrugDeliveryZt(String drugDeliveryZt) {
		this.drugDeliveryZt = drugDeliveryZt;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public List<DrugDeliveryDetali> getDrugDeliveryDetalis() {
		return this.drugDeliveryDetalis;
	}

	public void setDrugDeliveryDetalis(List<DrugDeliveryDetali> drugDeliveryDetalis) {
		this.drugDeliveryDetalis = drugDeliveryDetalis;
	}

	public DrugDeliveryDetali addDrugDeliveryDetali(DrugDeliveryDetali drugDeliveryDetali) {
		getDrugDeliveryDetalis().add(drugDeliveryDetali);
		drugDeliveryDetali.setDrugDelivery(this);

		return drugDeliveryDetali;
	}

	public DrugDeliveryDetali removeDrugDeliveryDetali(DrugDeliveryDetali drugDeliveryDetali) {
		getDrugDeliveryDetalis().remove(drugDeliveryDetali);
		drugDeliveryDetali.setDrugDelivery(null);

		return drugDeliveryDetali;
	}

}