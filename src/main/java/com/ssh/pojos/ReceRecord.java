package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the RECE_RECORD database table.
 * 
 */
@Entity
@Table(name="RECE_RECORD")
@NamedQuery(name="ReceRecord.findAll", query="SELECT r FROM ReceRecord r")
public class ReceRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RECE_RECORD_ID")
	private long receRecordId;

	@Column(name="CHARGE_JIESUAN_ID")
	private BigDecimal chargeJiesuanId;

	@Column(name="RECE_MONEY")
	private BigDecimal receMoney;

	@Column(name="RECE_REMARK")
	private String receRemark;

	//bi-directional many-to-one association to Rece
	@ManyToOne
	@JoinColumn(name="RECE_ID")
	private Rece rece;

	public ReceRecord() {
	}

	public long getReceRecordId() {
		return this.receRecordId;
	}

	public void setReceRecordId(long receRecordId) {
		this.receRecordId = receRecordId;
	}

	public BigDecimal getChargeJiesuanId() {
		return this.chargeJiesuanId;
	}

	public void setChargeJiesuanId(BigDecimal chargeJiesuanId) {
		this.chargeJiesuanId = chargeJiesuanId;
	}

	public BigDecimal getReceMoney() {
		return this.receMoney;
	}

	public void setReceMoney(BigDecimal receMoney) {
		this.receMoney = receMoney;
	}

	public String getReceRemark() {
		return this.receRemark;
	}

	public void setReceRemark(String receRemark) {
		this.receRemark = receRemark;
	}

	public Rece getRece() {
		return this.rece;
	}

	public void setRece(Rece rece) {
		this.rece = rece;
	}

}