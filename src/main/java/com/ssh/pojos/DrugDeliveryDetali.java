package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DRUG_DELIVERY_DETALIS database table.
 * 
 */
@Entity
@Table(name="DRUG_DELIVERY_DETALIS")
@NamedQuery(name="DrugDeliveryDetali.findAll", query="SELECT d FROM DrugDeliveryDetali d")
public class DrugDeliveryDetali implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_DELIVERY_DETALIS_ID")
	private long drugDeliveryDetalisId;

	@Column(name="DRUG_DELIVERY_DETALIS_BZ")
	private String drugDeliveryDetalisBz;

	@Column(name="DRUG_DELIVERY_DETALIS_NUM")
	private String drugDeliveryDetalisNum;

	@Column(name="DRUG_DELIVERY_DETALIS_PH")
	private String drugDeliveryDetalisPh;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to DrugDelivery
	@ManyToOne
	@JoinColumn(name="DRUG_DELIVERY_ID")
	private DrugDelivery drugDelivery;

	public DrugDeliveryDetali() {
	}

	public long getDrugDeliveryDetalisId() {
		return this.drugDeliveryDetalisId;
	}

	public void setDrugDeliveryDetalisId(long drugDeliveryDetalisId) {
		this.drugDeliveryDetalisId = drugDeliveryDetalisId;
	}

	public String getDrugDeliveryDetalisBz() {
		return this.drugDeliveryDetalisBz;
	}

	public void setDrugDeliveryDetalisBz(String drugDeliveryDetalisBz) {
		this.drugDeliveryDetalisBz = drugDeliveryDetalisBz;
	}

	public String getDrugDeliveryDetalisNum() {
		return this.drugDeliveryDetalisNum;
	}

	public void setDrugDeliveryDetalisNum(String drugDeliveryDetalisNum) {
		this.drugDeliveryDetalisNum = drugDeliveryDetalisNum;
	}

	public String getDrugDeliveryDetalisPh() {
		return this.drugDeliveryDetalisPh;
	}

	public void setDrugDeliveryDetalisPh(String drugDeliveryDetalisPh) {
		this.drugDeliveryDetalisPh = drugDeliveryDetalisPh;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public DrugDelivery getDrugDelivery() {
		return this.drugDelivery;
	}

	public void setDrugDelivery(DrugDelivery drugDelivery) {
		this.drugDelivery = drugDelivery;
	}

}