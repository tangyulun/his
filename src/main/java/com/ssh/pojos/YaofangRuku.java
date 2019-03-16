package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the YAOFANG_RUKU database table.
 * 
 */
@Entity
@Table(name="YAOFANG_RUKU")
@NamedQuery(name="YaofangRuku.findAll", query="SELECT y FROM YaofangRuku y")
public class YaofangRuku implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PHARMACY_WAREHOUSE_ID")
	private String pharmacyWarehouseId;

	@Temporal(TemporalType.DATE)
	@Column(name="PHARMACY_WAREHOUSE_RKDATE")
	private Date pharmacyWarehouseRkdate;

	@Column(name="PHARMACY_WAREHOUSE_ZJE")
	private String pharmacyWarehouseZje;

	@Column(name="PHARMACY_WAREHOUSE_ZT")
	private String pharmacyWarehouseZt;

	//bi-directional many-to-one association to PharmacyWarehouseDetali
	@OneToMany(mappedBy="yaofangRuku")
	private List<PharmacyWarehouseDetali> pharmacyWarehouseDetalis;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp1;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_EMP_ID")
	private Emp emp2;

	public YaofangRuku() {
	}

	public String getPharmacyWarehouseId() {
		return this.pharmacyWarehouseId;
	}

	public void setPharmacyWarehouseId(String pharmacyWarehouseId) {
		this.pharmacyWarehouseId = pharmacyWarehouseId;
	}

	public Date getPharmacyWarehouseRkdate() {
		return this.pharmacyWarehouseRkdate;
	}

	public void setPharmacyWarehouseRkdate(Date pharmacyWarehouseRkdate) {
		this.pharmacyWarehouseRkdate = pharmacyWarehouseRkdate;
	}

	public String getPharmacyWarehouseZje() {
		return this.pharmacyWarehouseZje;
	}

	public void setPharmacyWarehouseZje(String pharmacyWarehouseZje) {
		this.pharmacyWarehouseZje = pharmacyWarehouseZje;
	}

	public String getPharmacyWarehouseZt() {
		return this.pharmacyWarehouseZt;
	}

	public void setPharmacyWarehouseZt(String pharmacyWarehouseZt) {
		this.pharmacyWarehouseZt = pharmacyWarehouseZt;
	}

	public List<PharmacyWarehouseDetali> getPharmacyWarehouseDetalis() {
		return this.pharmacyWarehouseDetalis;
	}

	public void setPharmacyWarehouseDetalis(List<PharmacyWarehouseDetali> pharmacyWarehouseDetalis) {
		this.pharmacyWarehouseDetalis = pharmacyWarehouseDetalis;
	}

	public PharmacyWarehouseDetali addPharmacyWarehouseDetali(PharmacyWarehouseDetali pharmacyWarehouseDetali) {
		getPharmacyWarehouseDetalis().add(pharmacyWarehouseDetali);
		pharmacyWarehouseDetali.setYaofangRuku(this);

		return pharmacyWarehouseDetali;
	}

	public PharmacyWarehouseDetali removePharmacyWarehouseDetali(PharmacyWarehouseDetali pharmacyWarehouseDetali) {
		getPharmacyWarehouseDetalis().remove(pharmacyWarehouseDetali);
		pharmacyWarehouseDetali.setYaofangRuku(null);

		return pharmacyWarehouseDetali;
	}

	public Emp getEmp1() {
		return this.emp1;
	}

	public void setEmp1(Emp emp1) {
		this.emp1 = emp1;
	}

	public Emp getEmp2() {
		return this.emp2;
	}

	public void setEmp2(Emp emp2) {
		this.emp2 = emp2;
	}

}