package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the ZHILIAO_JIZHANG_XQ database table.
 * 
 */
@Entity
@Table(name="ZHILIAO_JIZHANG_XQ")
@NamedQuery(name="ZhiliaoJizhangXq.findAll", query="SELECT z FROM ZhiliaoJizhangXq z")
public class ZhiliaoJizhangXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHILIAO_JIZHANG_XQ_ID")
	private long zhiliaoJizhangXqId;

	@Temporal(TemporalType.DATE)
	@Column(name="ZHILIAO_JIZHANG_XQ_DATE")
	private Date zhiliaoJizhangXqDate;

	@Column(name="ZHILIAO_JIZHANG_XQ_NUMBER")
	private BigDecimal zhiliaoJizhangXqNumber;

	@Column(name="ZHILIAO_JIZHANG_XQ_STATE")
	private String zhiliaoJizhangXqState;

	@Column(name="ZHILIAO_JIZHANG_XQ_TIME")
	private String zhiliaoJizhangXqTime;

	//bi-directional many-to-one association to Financial
	@ManyToOne
	@JoinColumn(name="FINANCIAL_ID")
	private Financial financial;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRESCRIPTION_ID")
	private Prescription prescription;

	//bi-directional many-to-one association to ZhiliaoJizhang
	@ManyToOne
	@JoinColumn(name="ZHILIAO_JIZHANG_ID")
	private ZhiliaoJizhang zhiliaoJizhang;

	public ZhiliaoJizhangXq() {
	}

	public long getZhiliaoJizhangXqId() {
		return this.zhiliaoJizhangXqId;
	}

	public void setZhiliaoJizhangXqId(long zhiliaoJizhangXqId) {
		this.zhiliaoJizhangXqId = zhiliaoJizhangXqId;
	}

	public Date getZhiliaoJizhangXqDate() {
		return this.zhiliaoJizhangXqDate;
	}

	public void setZhiliaoJizhangXqDate(Date zhiliaoJizhangXqDate) {
		this.zhiliaoJizhangXqDate = zhiliaoJizhangXqDate;
	}

	public BigDecimal getZhiliaoJizhangXqNumber() {
		return this.zhiliaoJizhangXqNumber;
	}

	public void setZhiliaoJizhangXqNumber(BigDecimal zhiliaoJizhangXqNumber) {
		this.zhiliaoJizhangXqNumber = zhiliaoJizhangXqNumber;
	}

	public String getZhiliaoJizhangXqState() {
		return this.zhiliaoJizhangXqState;
	}

	public void setZhiliaoJizhangXqState(String zhiliaoJizhangXqState) {
		this.zhiliaoJizhangXqState = zhiliaoJizhangXqState;
	}

	public String getZhiliaoJizhangXqTime() {
		return this.zhiliaoJizhangXqTime;
	}

	public void setZhiliaoJizhangXqTime(String zhiliaoJizhangXqTime) {
		this.zhiliaoJizhangXqTime = zhiliaoJizhangXqTime;
	}

	public Financial getFinancial() {
		return this.financial;
	}

	public void setFinancial(Financial financial) {
		this.financial = financial;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public ZhiliaoJizhang getZhiliaoJizhang() {
		return this.zhiliaoJizhang;
	}

	public void setZhiliaoJizhang(ZhiliaoJizhang zhiliaoJizhang) {
		this.zhiliaoJizhang = zhiliaoJizhang;
	}

}