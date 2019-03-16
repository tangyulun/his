package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PHARMACY_INVENTORY database table.
 * 
 */
@Entity
@Table(name="PHARMACY_INVENTORY")
@NamedQuery(name="PharmacyInventory.findAll", query="SELECT p FROM PharmacyInventory p")
public class PharmacyInventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_INVENTORY_ID")
	private String pharmacyInventoryId;

	@Temporal(TemporalType.DATE)
	@Column(name="PHARMACY_INVENTORY_PDDATE")
	private Date pharmacyInventoryPddate;

	@Column(name="PHARMACY_INVENTORY_YF")
	private String pharmacyInventoryYf;

	@Column(name="PHARMACY_INVENTORY_ZT")
	private String pharmacyInventoryZt;

	//bi-directional many-to-one association to PharmacyInventoryDetali
	@OneToMany(mappedBy="pharmacyInventory")
	private List<PharmacyInventoryDetali> pharmacyInventoryDetalis;

	public PharmacyInventory() {
	}

	public String getPharmacyInventoryId() {
		return this.pharmacyInventoryId;
	}

	public void setPharmacyInventoryId(String pharmacyInventoryId) {
		this.pharmacyInventoryId = pharmacyInventoryId;
	}

	public Date getPharmacyInventoryPddate() {
		return this.pharmacyInventoryPddate;
	}

	public void setPharmacyInventoryPddate(Date pharmacyInventoryPddate) {
		this.pharmacyInventoryPddate = pharmacyInventoryPddate;
	}

	public String getPharmacyInventoryYf() {
		return this.pharmacyInventoryYf;
	}

	public void setPharmacyInventoryYf(String pharmacyInventoryYf) {
		this.pharmacyInventoryYf = pharmacyInventoryYf;
	}

	public String getPharmacyInventoryZt() {
		return this.pharmacyInventoryZt;
	}

	public void setPharmacyInventoryZt(String pharmacyInventoryZt) {
		this.pharmacyInventoryZt = pharmacyInventoryZt;
	}

	public List<PharmacyInventoryDetali> getPharmacyInventoryDetalis() {
		return this.pharmacyInventoryDetalis;
	}

	public void setPharmacyInventoryDetalis(List<PharmacyInventoryDetali> pharmacyInventoryDetalis) {
		this.pharmacyInventoryDetalis = pharmacyInventoryDetalis;
	}

	public PharmacyInventoryDetali addPharmacyInventoryDetali(PharmacyInventoryDetali pharmacyInventoryDetali) {
		getPharmacyInventoryDetalis().add(pharmacyInventoryDetali);
		pharmacyInventoryDetali.setPharmacyInventory(this);

		return pharmacyInventoryDetali;
	}

	public PharmacyInventoryDetali removePharmacyInventoryDetali(PharmacyInventoryDetali pharmacyInventoryDetali) {
		getPharmacyInventoryDetalis().remove(pharmacyInventoryDetali);
		pharmacyInventoryDetali.setPharmacyInventory(null);

		return pharmacyInventoryDetali;
	}

}