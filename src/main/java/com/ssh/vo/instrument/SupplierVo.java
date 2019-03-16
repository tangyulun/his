package com.ssh.vo.instrument;

import java.math.BigDecimal;

import com.ssh.vo.drugstorage.SupplierTypeVo;

public class SupplierVo {
	private String suplierId;

	private String suplierAddress;

	private String suplierBgdz;

	private String suplierBurman;

	private String suplierFkfs;

	private String suplierGsxz;

	private BigDecimal suplierIssh;

	private String suplierJc;

	private String suplierJzfs;

	private String suplierLxr;

	private String suplierName;

	private String suplierPd;

	private String suplierPhone;

	private String suplierShfs;

	private String suplierSm;
	
	private SupplierTypeVo suplierType;

	public SupplierVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierVo(String suplierId, String suplierAddress, String suplierBgdz, String suplierBurman,
			String suplierFkfs, String suplierGsxz, BigDecimal suplierIssh, String suplierJc, String suplierJzfs,
			String suplierLxr, String suplierName, String suplierPd, String suplierPhone, String suplierShfs,
			String suplierSm, SupplierTypeVo suplierType) {
		super();
		this.suplierId = suplierId;
		this.suplierAddress = suplierAddress;
		this.suplierBgdz = suplierBgdz;
		this.suplierBurman = suplierBurman;
		this.suplierFkfs = suplierFkfs;
		this.suplierGsxz = suplierGsxz;
		this.suplierIssh = suplierIssh;
		this.suplierJc = suplierJc;
		this.suplierJzfs = suplierJzfs;
		this.suplierLxr = suplierLxr;
		this.suplierName = suplierName;
		this.suplierPd = suplierPd;
		this.suplierPhone = suplierPhone;
		this.suplierShfs = suplierShfs;
		this.suplierSm = suplierSm;
		this.suplierType = suplierType;
	}

	public String getSuplierId() {
		return suplierId;
	}

	public void setSuplierId(String suplierId) {
		this.suplierId = suplierId;
	}

	public String getSuplierAddress() {
		return suplierAddress;
	}

	public void setSuplierAddress(String suplierAddress) {
		this.suplierAddress = suplierAddress;
	}

	public String getSuplierBgdz() {
		return suplierBgdz;
	}

	public void setSuplierBgdz(String suplierBgdz) {
		this.suplierBgdz = suplierBgdz;
	}

	public String getSuplierBurman() {
		return suplierBurman;
	}

	public void setSuplierBurman(String suplierBurman) {
		this.suplierBurman = suplierBurman;
	}

	public String getSuplierFkfs() {
		return suplierFkfs;
	}

	public void setSuplierFkfs(String suplierFkfs) {
		this.suplierFkfs = suplierFkfs;
	}

	public String getSuplierGsxz() {
		return suplierGsxz;
	}

	public void setSuplierGsxz(String suplierGsxz) {
		this.suplierGsxz = suplierGsxz;
	}

	public BigDecimal getSuplierIssh() {
		return suplierIssh;
	}

	public void setSuplierIssh(BigDecimal suplierIssh) {
		this.suplierIssh = suplierIssh;
	}

	public String getSuplierJc() {
		return suplierJc;
	}

	public void setSuplierJc(String suplierJc) {
		this.suplierJc = suplierJc;
	}

	public String getSuplierJzfs() {
		return suplierJzfs;
	}

	public void setSuplierJzfs(String suplierJzfs) {
		this.suplierJzfs = suplierJzfs;
	}

	public String getSuplierLxr() {
		return suplierLxr;
	}

	public void setSuplierLxr(String suplierLxr) {
		this.suplierLxr = suplierLxr;
	}

	public String getSuplierName() {
		return suplierName;
	}

	public void setSuplierName(String suplierName) {
		this.suplierName = suplierName;
	}

	public String getSuplierPd() {
		return suplierPd;
	}

	public void setSuplierPd(String suplierPd) {
		this.suplierPd = suplierPd;
	}

	public String getSuplierPhone() {
		return suplierPhone;
	}

	public void setSuplierPhone(String suplierPhone) {
		this.suplierPhone = suplierPhone;
	}

	public String getSuplierShfs() {
		return suplierShfs;
	}

	public void setSuplierShfs(String suplierShfs) {
		this.suplierShfs = suplierShfs;
	}

	public String getSuplierSm() {
		return suplierSm;
	}

	public void setSuplierSm(String suplierSm) {
		this.suplierSm = suplierSm;
	}

	public SupplierTypeVo getSuplierType() {
		return suplierType;
	}

	public void setSuplierType(SupplierTypeVo suplierType) {
		this.suplierType = suplierType;
	}

	public SupplierVo(String suplierId, String suplierName) {
		super();
		this.suplierId = suplierId;
		this.suplierName = suplierName;
	}

	public SupplierVo(String suplierId, String suplierName, String suplierLxr, String suplierPhone) {
		super();
		this.suplierId = suplierId;
		this.suplierName = suplierName;
		this.suplierLxr = suplierLxr;
		this.suplierPhone = suplierPhone;
	}
	
}
