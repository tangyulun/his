package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DRUG_INVENTORY database table.
 * 
 */
@Entity
@Table(name="DRUG_INVENTORY")
@NamedQuery(name="DrugInventory.findAll", query="SELECT d FROM DrugInventory d")
public class DrugInventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_INVENTORY_ID")
	private String drugInventoryId;

	@Temporal(TemporalType.DATE)
	@Column(name="DRUG_INVERTORY_PDDATE")
	private Date drugInvertoryPddate;

	@Column(name="DRUG_INVERTORY_PDYK")
	private String drugInvertoryPdyk;

	@Column(name="DRUG_INVERTORY_ZT")
	private String drugInvertoryZt;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to DrugInventoryDetali
	@OneToMany(mappedBy="drugInventory")
	private List<DrugInventoryDetali> drugInventoryDetalis;

	public DrugInventory() {
	}

	public String getDrugInventoryId() {
		return this.drugInventoryId;
	}

	public void setDrugInventoryId(String drugInventoryId) {
		this.drugInventoryId = drugInventoryId;
	}

	public Date getDrugInvertoryPddate() {
		return this.drugInvertoryPddate;
	}

	public void setDrugInvertoryPddate(Date drugInvertoryPddate) {
		this.drugInvertoryPddate = drugInvertoryPddate;
	}

	public String getDrugInvertoryPdyk() {
		return this.drugInvertoryPdyk;
	}

	public void setDrugInvertoryPdyk(String drugInvertoryPdyk) {
		this.drugInvertoryPdyk = drugInvertoryPdyk;
	}

	public String getDrugInvertoryZt() {
		return this.drugInvertoryZt;
	}

	public void setDrugInvertoryZt(String drugInvertoryZt) {
		this.drugInvertoryZt = drugInvertoryZt;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public List<DrugInventoryDetali> getDrugInventoryDetalis() {
		return this.drugInventoryDetalis;
	}

	public void setDrugInventoryDetalis(List<DrugInventoryDetali> drugInventoryDetalis) {
		this.drugInventoryDetalis = drugInventoryDetalis;
	}

	public DrugInventoryDetali addDrugInventoryDetali(DrugInventoryDetali drugInventoryDetali) {
		getDrugInventoryDetalis().add(drugInventoryDetali);
		drugInventoryDetali.setDrugInventory(this);

		return drugInventoryDetali;
	}

	public DrugInventoryDetali removeDrugInventoryDetali(DrugInventoryDetali drugInventoryDetali) {
		getDrugInventoryDetalis().remove(drugInventoryDetali);
		drugInventoryDetali.setDrugInventory(null);

		return drugInventoryDetali;
	}

}