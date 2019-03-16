package com.ssh.vo.drugstorage;

import java.math.BigDecimal;

import com.ssh.pojos.SupplierType;

public class SupplierVo {
	private String supplierId;

	private String supplierAddress;

	private String supplierBgdz;

	private String supplierBurman;

	private String supplierFkfs;

	private String supplierGsxz;

	private BigDecimal supplierIssh;

	private String supplierJc;

	private String supplierJzfs;

	private String supplierLxr;

	private String supplierName;

	private String supplierPd;

	private String supplierPhone;

	private String supplierShfs;

	private String supplierSm;
	
	private SupplierTypeVo supplierType;
	

	public SupplierVo(String supplierId, String supplierName) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
	}

	public SupplierTypeVo getSupplierTypeVo() {
		return supplierType;
	}

	public void setSupplierTypeVo(SupplierTypeVo supplierType) {
		this.supplierType = supplierType;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierBgdz() {
		return supplierBgdz;
	}

	public void setSupplierBgdz(String supplierBgdz) {
		this.supplierBgdz = supplierBgdz;
	}

	public String getSupplierBurman() {
		return supplierBurman;
	}

	public void setSupplierBurman(String supplierBurman) {
		this.supplierBurman = supplierBurman;
	}

	public String getSupplierFkfs() {
		return supplierFkfs;
	}

	public void setSupplierFkfs(String supplierFkfs) {
		this.supplierFkfs = supplierFkfs;
	}

	public String getSupplierGsxz() {
		return supplierGsxz;
	}

	public void setSupplierGsxz(String supplierGsxz) {
		this.supplierGsxz = supplierGsxz;
	}

	public BigDecimal getSupplierIssh() {
		return supplierIssh;
	}

	public void setSupplierIssh(BigDecimal supplierIssh) {
		this.supplierIssh = supplierIssh;
	}

	public String getSupplierJc() {
		return supplierJc;
	}

	public void setSupplierJc(String supplierJc) {
		this.supplierJc = supplierJc;
	}

	public String getSupplierJzfs() {
		return supplierJzfs;
	}

	public void setSupplierJzfs(String supplierJzfs) {
		this.supplierJzfs = supplierJzfs;
	}

	public String getSupplierLxr() {
		return supplierLxr;
	}

	public void setSupplierLxr(String supplierLxr) {
		this.supplierLxr = supplierLxr;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierPd() {
		return supplierPd;
	}

	public void setSupplierPd(String supplierPd) {
		this.supplierPd = supplierPd;
	}

	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}

	public String getSupplierShfs() {
		return supplierShfs;
	}

	public void setSupplierShfs(String supplierShfs) {
		this.supplierShfs = supplierShfs;
	}

	public String getSupplierSm() {
		return supplierSm;
	}

	public void setSupplierSm(String supplierSm) {
		this.supplierSm = supplierSm;
	}

	public SupplierVo(String supplierId, String supplierAddress, String supplierBgdz, String supplierBurman,
			String supplierFkfs, String supplierGsxz, BigDecimal supplierIssh, String supplierJc, String supplierJzfs,
			String supplierLxr, String supplierName, String supplierPd, String supplierPhone, String supplierShfs,
			String supplierSm) {
		super();
		this.supplierId = supplierId;
		this.supplierAddress = supplierAddress;
		this.supplierBgdz = supplierBgdz;
		this.supplierBurman = supplierBurman;
		this.supplierFkfs = supplierFkfs;
		this.supplierGsxz = supplierGsxz;
		this.supplierIssh = supplierIssh;
		this.supplierJc = supplierJc;
		this.supplierJzfs = supplierJzfs;
		this.supplierLxr = supplierLxr;
		this.supplierName = supplierName;
		this.supplierPd = supplierPd;
		this.supplierPhone = supplierPhone;
		this.supplierShfs = supplierShfs;
		this.supplierSm = supplierSm;
	}

	public SupplierVo(String supplierId, String supplierAddress, String supplierBurman, String supplierFkfs,
			String supplierJc, String supplierLxr, String supplierPhone, String supplierShfs) {
		super();
		this.supplierId = supplierId;
		this.supplierAddress = supplierAddress;
		this.supplierBurman = supplierBurman;
		this.supplierFkfs = supplierFkfs;
		this.supplierJc = supplierJc;
		this.supplierLxr = supplierLxr;
		this.supplierPhone = supplierPhone;
		this.supplierShfs = supplierShfs;
	}

	public SupplierVo(String supplierId, String supplierName, String supplierLxr, String supplierPhone) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierLxr = supplierLxr;
		this.supplierPhone = supplierPhone;
	}

	public SupplierVo() {
		super();
	}

	@Override
	public String toString() {
		return "SupplierVo [supplierId=" + supplierId + ", supplierAddress=" + supplierAddress + ", supplierBgdz="
				+ supplierBgdz + ", supplierBurman=" + supplierBurman + ", supplierFkfs=" + supplierFkfs
				+ ", supplierGsxz=" + supplierGsxz + ", supplierIssh=" + supplierIssh + ", supplierJc=" + supplierJc
				+ ", supplierJzfs=" + supplierJzfs + ", supplierLxr=" + supplierLxr + ", supplierName=" + supplierName
				+ ", supplierPd=" + supplierPd + ", supplierPhone=" + supplierPhone + ", supplierShfs=" + supplierShfs
				+ ", supplierSm=" + supplierSm + ", supplierTypeVo=" + supplierType + "]";
	}

}
