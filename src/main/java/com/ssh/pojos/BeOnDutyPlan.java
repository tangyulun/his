package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BE_ON_DUTY_PLAN database table.
 * 
 */
@Entity
@Table(name="BE_ON_DUTY_PLAN")
@NamedQuery(name="BeOnDutyPlan.findAll", query="SELECT b FROM BeOnDutyPlan b")
public class BeOnDutyPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BE_ON_DUTY_PLAN_ID")
	private String beOnDutyPlanId;

	@Temporal(TemporalType.DATE)
	@Column(name="BE_ON_DUTY_PLAN_DATE")
	private Date beOnDutyPlanDate;

	@Temporal(TemporalType.DATE)
	@Column(name="BE_ON_DUTY_PLAN_END_DATE")
	private Date beOnDutyPlanEndDate;

	@Lob
	@Column(name="BE_ON_DUTY_PLAN_MESSAGE")
	private byte[] beOnDutyPlanMessage;

	@Temporal(TemporalType.DATE)
	@Column(name="BE_ON_DUTY_PLAN_START_DATE")
	private Date beOnDutyPlanStartDate;

	@Column(name="BE_ON_DUTY_PLAN_TYPE")
	private String beOnDutyPlanType;

	//bi-directional many-to-one association to BeOnDutyPlanXq
	@OneToMany(mappedBy="beOnDutyPlan")
	private List<BeOnDutyPlanXq> beOnDutyPlanXqs;

	public BeOnDutyPlan() {
	}

	public String getBeOnDutyPlanId() {
		return this.beOnDutyPlanId;
	}

	public void setBeOnDutyPlanId(String beOnDutyPlanId) {
		this.beOnDutyPlanId = beOnDutyPlanId;
	}

	public Date getBeOnDutyPlanDate() {
		return this.beOnDutyPlanDate;
	}

	public void setBeOnDutyPlanDate(Date beOnDutyPlanDate) {
		this.beOnDutyPlanDate = beOnDutyPlanDate;
	}

	public Date getBeOnDutyPlanEndDate() {
		return this.beOnDutyPlanEndDate;
	}

	public void setBeOnDutyPlanEndDate(Date beOnDutyPlanEndDate) {
		this.beOnDutyPlanEndDate = beOnDutyPlanEndDate;
	}

	public byte[] getBeOnDutyPlanMessage() {
		return this.beOnDutyPlanMessage;
	}

	public void setBeOnDutyPlanMessage(byte[] beOnDutyPlanMessage) {
		this.beOnDutyPlanMessage = beOnDutyPlanMessage;
	}

	public Date getBeOnDutyPlanStartDate() {
		return this.beOnDutyPlanStartDate;
	}

	public void setBeOnDutyPlanStartDate(Date beOnDutyPlanStartDate) {
		this.beOnDutyPlanStartDate = beOnDutyPlanStartDate;
	}

	public String getBeOnDutyPlanType() {
		return this.beOnDutyPlanType;
	}

	public void setBeOnDutyPlanType(String beOnDutyPlanType) {
		this.beOnDutyPlanType = beOnDutyPlanType;
	}

	public List<BeOnDutyPlanXq> getBeOnDutyPlanXqs() {
		return this.beOnDutyPlanXqs;
	}

	public void setBeOnDutyPlanXqs(List<BeOnDutyPlanXq> beOnDutyPlanXqs) {
		this.beOnDutyPlanXqs = beOnDutyPlanXqs;
	}

	public BeOnDutyPlanXq addBeOnDutyPlanXq(BeOnDutyPlanXq beOnDutyPlanXq) {
		getBeOnDutyPlanXqs().add(beOnDutyPlanXq);
		beOnDutyPlanXq.setBeOnDutyPlan(this);

		return beOnDutyPlanXq;
	}

	public BeOnDutyPlanXq removeBeOnDutyPlanXq(BeOnDutyPlanXq beOnDutyPlanXq) {
		getBeOnDutyPlanXqs().remove(beOnDutyPlanXq);
		beOnDutyPlanXq.setBeOnDutyPlan(null);

		return beOnDutyPlanXq;
	}

}