package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PRESCRIPTION_TYPE database table.
 * 
 */
@Entity
@Table(name="PRESCRIPTION_TYPE")
@NamedQuery(name="PrescriptionType.findAll", query="SELECT p FROM PrescriptionType p")
public class PrescriptionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRESPRICED_ID")
	private String prespricedId;

	@Column(name="PRESPRICED_YSJE")
	private BigDecimal prespricedYsje;

	@Column(name="PRESPRICED_ZONGFEIYONG")
	private BigDecimal prespricedZongfeiyong;

	@Column(name="PRESPRICED_ZT")
	private String prespricedZt;

	@Temporal(TemporalType.DATE)
	@Column(name="PRESPRICEDN_DATE")
	private Date prespricednDate;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRESCRIPTION_ID")
	private Prescription prescription;

	public PrescriptionType() {
	}

	public String getPrespricedId() {
		return this.prespricedId;
	}

	public void setPrespricedId(String prespricedId) {
		this.prespricedId = prespricedId;
	}

	public BigDecimal getPrespricedYsje() {
		return this.prespricedYsje;
	}

	public void setPrespricedYsje(BigDecimal prespricedYsje) {
		this.prespricedYsje = prespricedYsje;
	}

	public BigDecimal getPrespricedZongfeiyong() {
		return this.prespricedZongfeiyong;
	}

	public void setPrespricedZongfeiyong(BigDecimal prespricedZongfeiyong) {
		this.prespricedZongfeiyong = prespricedZongfeiyong;
	}

	public String getPrespricedZt() {
		return this.prespricedZt;
	}

	public void setPrespricedZt(String prespricedZt) {
		this.prespricedZt = prespricedZt;
	}

	public Date getPrespricednDate() {
		return this.prespricednDate;
	}

	public void setPrespricednDate(Date prespricednDate) {
		this.prespricednDate = prespricednDate;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
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