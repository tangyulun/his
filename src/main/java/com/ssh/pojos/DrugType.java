package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DRUG_TYPE database table.
 * 
 */
@Entity
@Table(name="DRUG_TYPE")
@NamedQuery(name="DrugType.findAll", query="SELECT d FROM DrugType d")
public class DrugType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_TYPE_ID")
	private long drugTypeId;

	@Column(name="DRUG_TYPE_NAME")
	private String drugTypeName;

	//bi-directional many-to-one association to Drug
	@OneToMany(mappedBy="drugType")
	private List<Drug> drugs;

	public DrugType() {
	}

	public long getDrugTypeId() {
		return this.drugTypeId;
	}

	public void setDrugTypeId(long drugTypeId) {
		this.drugTypeId = drugTypeId;
	}

	public String getDrugTypeName() {
		return this.drugTypeName;
	}

	public void setDrugTypeName(String drugTypeName) {
		this.drugTypeName = drugTypeName;
	}

	public List<Drug> getDrugs() {
		return this.drugs;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public Drug addDrug(Drug drug) {
		getDrugs().add(drug);
		drug.setDrugType(this);

		return drug;
	}

	public Drug removeDrug(Drug drug) {
		getDrugs().remove(drug);
		drug.setDrugType(null);

		return drug;
	}

}