package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FAYAO_JIZHANG_XQ database table.
 * 
 */
@Entity
@Table(name="FAYAO_JIZHANG_XQ")
@NamedQuery(name="FayaoJizhangXq.findAll", query="SELECT f FROM FayaoJizhangXq f")
public class FayaoJizhangXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FAYAO_JIZHANG_XQ_ID")
	private long fayaoJizhangXqId;

	@Temporal(TemporalType.DATE)
	@Column(name="FAYAO_JIZHANG_XQ_DATE")
	private Date fayaoJizhangXqDate;

	@Column(name="FAYAO_JIZHANG_XQ_JILIANG")
	private BigDecimal fayaoJizhangXqJiliang;

	@Column(name="FAYAO_JIZHANG_XQ_NUM")
	private BigDecimal fayaoJizhangXqNum;

	@Column(name="FAYAO_JIZHANG_XQ_PRICE")
	private BigDecimal fayaoJizhangXqPrice;

	@Column(name="FAYAO_JIZHANG_XQ_STATE")
	private String fayaoJizhangXqState;

	@Column(name="FAYAO_JIZHANG_XQ_TIME")
	private String fayaoJizhangXqTime;

	//bi-directional many-to-one association to Drug
	@ManyToOne
	@JoinColumn(name="DRUG_ID")
	private Drug drug;

	//bi-directional many-to-one association to FayaoJizhang
	@ManyToOne
	@JoinColumn(name="ZHUYUAN_JIZHANG_ID")
	private FayaoJizhang fayaoJizhang;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRESCRIPTION_ID")
	private Prescription prescription;

	public FayaoJizhangXq() {
	}

	public long getFayaoJizhangXqId() {
		return this.fayaoJizhangXqId;
	}

	public void setFayaoJizhangXqId(long fayaoJizhangXqId) {
		this.fayaoJizhangXqId = fayaoJizhangXqId;
	}

	public Date getFayaoJizhangXqDate() {
		return this.fayaoJizhangXqDate;
	}

	public void setFayaoJizhangXqDate(Date fayaoJizhangXqDate) {
		this.fayaoJizhangXqDate = fayaoJizhangXqDate;
	}

	public BigDecimal getFayaoJizhangXqJiliang() {
		return this.fayaoJizhangXqJiliang;
	}

	public void setFayaoJizhangXqJiliang(BigDecimal fayaoJizhangXqJiliang) {
		this.fayaoJizhangXqJiliang = fayaoJizhangXqJiliang;
	}

	public BigDecimal getFayaoJizhangXqNum() {
		return this.fayaoJizhangXqNum;
	}

	public void setFayaoJizhangXqNum(BigDecimal fayaoJizhangXqNum) {
		this.fayaoJizhangXqNum = fayaoJizhangXqNum;
	}

	public BigDecimal getFayaoJizhangXqPrice() {
		return this.fayaoJizhangXqPrice;
	}

	public void setFayaoJizhangXqPrice(BigDecimal fayaoJizhangXqPrice) {
		this.fayaoJizhangXqPrice = fayaoJizhangXqPrice;
	}

	public String getFayaoJizhangXqState() {
		return this.fayaoJizhangXqState;
	}

	public void setFayaoJizhangXqState(String fayaoJizhangXqState) {
		this.fayaoJizhangXqState = fayaoJizhangXqState;
	}

	public String getFayaoJizhangXqTime() {
		return this.fayaoJizhangXqTime;
	}

	public void setFayaoJizhangXqTime(String fayaoJizhangXqTime) {
		this.fayaoJizhangXqTime = fayaoJizhangXqTime;
	}

	public Drug getDrug() {
		return this.drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public FayaoJizhang getFayaoJizhang() {
		return this.fayaoJizhang;
	}

	public void setFayaoJizhang(FayaoJizhang fayaoJizhang) {
		this.fayaoJizhang = fayaoJizhang;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

}