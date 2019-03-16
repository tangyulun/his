package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the SUPPLIER database table.
 * 
 */
@Entity
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SUPPLIER_ID")
	private String supplierId;

	@Column(name="SUPPLIER_ADDRESS")
	private String supplierAddress;

	@Column(name="SUPPLIER_BGDZ")
	private String supplierBgdz;

	@Column(name="SUPPLIER_BURMAN")
	private String supplierBurman;

	@Column(name="SUPPLIER_FKFS")
	private String supplierFkfs;

	@Column(name="SUPPLIER_GSXZ")
	private String supplierGsxz;

	@Column(name="SUPPLIER_ISSH")
	private BigDecimal supplierIssh;

	@Column(name="SUPPLIER_JC")
	private String supplierJc;

	@Column(name="SUPPLIER_JZFS")
	private String supplierJzfs;

	@Column(name="SUPPLIER_LXR")
	private String supplierLxr;

	@Column(name="SUPPLIER_NAME")
	private String supplierName;

	@Column(name="SUPPLIER_PD")
	private String supplierPd;

	@Column(name="SUPPLIER_PHONE")
	private String supplierPhone;

	@Column(name="SUPPLIER_SHFS")
	private String supplierShfs;

	@Column(name="SUPPLIER_SM")
	private String supplierSm;

	//bi-directional many-to-one association to DrugPurchase
	@OneToMany(mappedBy="supplier")
	private List<DrugPurchase> drugPurchases;

	//bi-directional many-to-one association to DrugTuihuo
	@OneToMany(mappedBy="supplier")
	private List<DrugTuihuo> drugTuihuos;

	//bi-directional many-to-one association to InstrumentCaigou
	@OneToMany(mappedBy="supplier")
	private List<InstrumentCaigou> instrumentCaigous;

	//bi-directional many-to-one association to QxReturngoo
	@OneToMany(mappedBy="supplier")
	private List<QxReturngoo> qxReturngoos;

	//bi-directional many-to-one association to SupplierType
	@ManyToOne
	@JoinColumn(name="SUPPLIER_TYPE_ID")
	private SupplierType supplierType;

	public Supplier() {
	}

	public String getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierBgdz() {
		return this.supplierBgdz;
	}

	public void setSupplierBgdz(String supplierBgdz) {
		this.supplierBgdz = supplierBgdz;
	}

	public String getSupplierBurman() {
		return this.supplierBurman;
	}

	public void setSupplierBurman(String supplierBurman) {
		this.supplierBurman = supplierBurman;
	}

	public String getSupplierFkfs() {
		return this.supplierFkfs;
	}

	public void setSupplierFkfs(String supplierFkfs) {
		this.supplierFkfs = supplierFkfs;
	}

	public String getSupplierGsxz() {
		return this.supplierGsxz;
	}

	public void setSupplierGsxz(String supplierGsxz) {
		this.supplierGsxz = supplierGsxz;
	}

	public BigDecimal getSupplierIssh() {
		return this.supplierIssh;
	}

	public void setSupplierIssh(BigDecimal supplierIssh) {
		this.supplierIssh = supplierIssh;
	}

	public String getSupplierJc() {
		return this.supplierJc;
	}

	public void setSupplierJc(String supplierJc) {
		this.supplierJc = supplierJc;
	}

	public String getSupplierJzfs() {
		return this.supplierJzfs;
	}

	public void setSupplierJzfs(String supplierJzfs) {
		this.supplierJzfs = supplierJzfs;
	}

	public String getSupplierLxr() {
		return this.supplierLxr;
	}

	public void setSupplierLxr(String supplierLxr) {
		this.supplierLxr = supplierLxr;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPd() {
		return this.supplierPd;
	}

	public void setSupplierPd(String supplierPd) {
		this.supplierPd = supplierPd;
	}

	public String getSupplierPhone() {
		return this.supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierShfs() {
		return this.supplierShfs;
	}

	public void setSupplierShfs(String supplierShfs) {
		this.supplierShfs = supplierShfs;
	}

	public String getSupplierSm() {
		return this.supplierSm;
	}

	public void setSupplierSm(String supplierSm) {
		this.supplierSm = supplierSm;
	}

	public List<DrugPurchase> getDrugPurchases() {
		return this.drugPurchases;
	}

	public void setDrugPurchases(List<DrugPurchase> drugPurchases) {
		this.drugPurchases = drugPurchases;
	}

	public DrugPurchase addDrugPurchas(DrugPurchase drugPurchas) {
		getDrugPurchases().add(drugPurchas);
		drugPurchas.setSupplier(this);

		return drugPurchas;
	}

	public DrugPurchase removeDrugPurchas(DrugPurchase drugPurchas) {
		getDrugPurchases().remove(drugPurchas);
		drugPurchas.setSupplier(null);

		return drugPurchas;
	}

	public List<DrugTuihuo> getDrugTuihuos() {
		return this.drugTuihuos;
	}

	public void setDrugTuihuos(List<DrugTuihuo> drugTuihuos) {
		this.drugTuihuos = drugTuihuos;
	}

	public DrugTuihuo addDrugTuihuo(DrugTuihuo drugTuihuo) {
		getDrugTuihuos().add(drugTuihuo);
		drugTuihuo.setSupplier(this);

		return drugTuihuo;
	}

	public DrugTuihuo removeDrugTuihuo(DrugTuihuo drugTuihuo) {
		getDrugTuihuos().remove(drugTuihuo);
		drugTuihuo.setSupplier(null);

		return drugTuihuo;
	}

	public List<InstrumentCaigou> getInstrumentCaigous() {
		return this.instrumentCaigous;
	}

	public void setInstrumentCaigous(List<InstrumentCaigou> instrumentCaigous) {
		this.instrumentCaigous = instrumentCaigous;
	}

	public InstrumentCaigou addInstrumentCaigous(InstrumentCaigou instrumentCaigous) {
		getInstrumentCaigous().add(instrumentCaigous);
		instrumentCaigous.setSupplier(this);

		return instrumentCaigous;
	}

	public InstrumentCaigou removeInstrumentCaigous(InstrumentCaigou instrumentCaigous) {
		getInstrumentCaigous().remove(instrumentCaigous);
		instrumentCaigous.setSupplier(null);

		return instrumentCaigous;
	}

	public List<QxReturngoo> getQxReturngoos() {
		return this.qxReturngoos;
	}

	public void setQxReturngoos(List<QxReturngoo> qxReturngoos) {
		this.qxReturngoos = qxReturngoos;
	}

	public QxReturngoo addQxReturngoo(QxReturngoo qxReturngoo) {
		getQxReturngoos().add(qxReturngoo);
		qxReturngoo.setSupplier(this);

		return qxReturngoo;
	}

	public QxReturngoo removeQxReturngoo(QxReturngoo qxReturngoo) {
		getQxReturngoos().remove(qxReturngoo);
		qxReturngoo.setSupplier(null);

		return qxReturngoo;
	}

	public SupplierType getSupplierType() {
		return this.supplierType;
	}

	public void setSupplierType(SupplierType supplierType) {
		this.supplierType = supplierType;
	}

}