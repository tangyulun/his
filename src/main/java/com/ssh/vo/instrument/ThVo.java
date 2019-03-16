package com.ssh.vo.instrument;

import java.math.BigDecimal;
import java.util.Date;



public class ThVo {
	
	private String qxReturngoosId;
	private Date qxReturngoosDate;
	private BigDecimal qxReturngoosMoney;
	private String qxReturngoosPzdh;
	private String qxReturngoosSatae;
	private SupplierVo supplier;
	public String getQxReturngoosId() {
		return qxReturngoosId;
	}
	public void setQxReturngoosId(String qxReturngoosId) {
		this.qxReturngoosId = qxReturngoosId;
	}
	public Date getQxReturngoosDate() {
		return qxReturngoosDate;
	}
	public void setQxReturngoosDate(Date qxReturngoosDate) {
		this.qxReturngoosDate = qxReturngoosDate;
	}
	public BigDecimal getQxReturngoosMoney() {
		return qxReturngoosMoney;
	}
	public void setQxReturngoosMoney(BigDecimal qxReturngoosMoney) {
		this.qxReturngoosMoney = qxReturngoosMoney;
	}
	public String getQxReturngoosPzdh() {
		return qxReturngoosPzdh;
	}
	public void setQxReturngoosPzdh(String qxReturngoosPzdh) {
		this.qxReturngoosPzdh = qxReturngoosPzdh;
	}
	public String getQxReturngoosSatae() {
		return qxReturngoosSatae;
	}
	public void setQxReturngoosSatae(String qxReturngoosSatae) {
		this.qxReturngoosSatae = qxReturngoosSatae;
	}
	public SupplierVo getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierVo supplier) {
		this.supplier = supplier;
	}
	public ThVo(String qxReturngoosId, Date qxReturngoosDate, BigDecimal qxReturngoosMoney, String qxReturngoosPzdh,
			String qxReturngoosSatae, SupplierVo supplier) {
		super();
		this.qxReturngoosId = qxReturngoosId;
		this.qxReturngoosDate = qxReturngoosDate;
		this.qxReturngoosMoney = qxReturngoosMoney;
		this.qxReturngoosPzdh = qxReturngoosPzdh;
		this.qxReturngoosSatae = qxReturngoosSatae;
		this.supplier = supplier;
	}
	public ThVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}