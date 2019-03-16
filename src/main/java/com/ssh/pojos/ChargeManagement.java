package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the CHARGE_MANAGEMENT database table.
 * 
 */
@Entity
@Table(name="CHARGE_MANAGEMENT")
@NamedQuery(name="ChargeManagement.findAll", query="SELECT c FROM ChargeManagement c")
public class ChargeManagement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHARGE_MANAGEMENT_ID")
	private String chargeManagementId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHARGE_MANAGEMENT_CHARGEDATE")
	private Date chargeManagementChargedate;

	@Column(name="CHARGE_MANAGEMENT_SSJINE")
	private BigDecimal chargeManagementSsjine;

	@Column(name="CHARGE_MANAGEMENT_YSJINE")
	private BigDecimal chargeManagementYsjine;

	@Column(name="CHARGE_MANAGEMENT_YTJINE")
	private BigDecimal chargeManagementYtjine;

	@Column(name="CHARGE_MANAGEMENT_ZT")
	private String chargeManagementZt;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRESCRIPTION_ID")
	private Prescription prescription;

	public ChargeManagement() {
	}

	public String getChargeManagementId() {
		return this.chargeManagementId;
	}

	public void setChargeManagementId(String chargeManagementId) {
		this.chargeManagementId = chargeManagementId;
	}

	public Date getChargeManagementChargedate() {
		return this.chargeManagementChargedate;
	}

	public void setChargeManagementChargedate(Date chargeManagementChargedate) {
		this.chargeManagementChargedate = chargeManagementChargedate;
	}

	public BigDecimal getChargeManagementSsjine() {
		return this.chargeManagementSsjine;
	}

	public void setChargeManagementSsjine(BigDecimal chargeManagementSsjine) {
		this.chargeManagementSsjine = chargeManagementSsjine;
	}

	public BigDecimal getChargeManagementYsjine() {
		return this.chargeManagementYsjine;
	}

	public void setChargeManagementYsjine(BigDecimal chargeManagementYsjine) {
		this.chargeManagementYsjine = chargeManagementYsjine;
	}

	public BigDecimal getChargeManagementYtjine() {
		return this.chargeManagementYtjine;
	}

	public void setChargeManagementYtjine(BigDecimal chargeManagementYtjine) {
		this.chargeManagementYtjine = chargeManagementYtjine;
	}

	public String getChargeManagementZt() {
		return this.chargeManagementZt;
	}

	public void setChargeManagementZt(String chargeManagementZt) {
		this.chargeManagementZt = chargeManagementZt;
	}

	public OutpaitentRegist getOutpaitentRegist() {
		return this.outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

}