package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUPPLIER_TYPE database table.
 * 
 */
@Entity
@Table(name="SUPPLIER_TYPE")
@NamedQuery(name="SupplierType.findAll", query="SELECT s FROM SupplierType s")
public class SupplierType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUPPLIER_TYPE_ID")
	private long supplierTypeId;

	@Column(name="SUPPLIER_TYPE_NAME")
	private String supplierTypeName;

	//bi-directional many-to-one association to Supplier
	@OneToMany(mappedBy="supplierType")
	private List<Supplier> suppliers;

	public SupplierType() {
	}

	public long getSupplierTypeId() {
		return this.supplierTypeId;
	}

	public void setSupplierTypeId(long supplierTypeId) {
		this.supplierTypeId = supplierTypeId;
	}

	public String getSupplierTypeName() {
		return this.supplierTypeName;
	}

	public void setSupplierTypeName(String supplierTypeName) {
		this.supplierTypeName = supplierTypeName;
	}

	public List<Supplier> getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Supplier addSupplier(Supplier supplier) {
		getSuppliers().add(supplier);
		supplier.setSupplierType(this);

		return supplier;
	}

	public Supplier removeSupplier(Supplier supplier) {
		getSuppliers().remove(supplier);
		supplier.setSupplierType(null);

		return supplier;
	}

}