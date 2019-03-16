package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BE_ON_DUTY_PLAN_XQ database table.
 * 
 */
@Entity
@Table(name="BE_ON_DUTY_PLAN_XQ")
@NamedQuery(name="BeOnDutyPlanXq.findAll", query="SELECT b FROM BeOnDutyPlanXq b")
public class BeOnDutyPlanXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BE_ON_DUTY_PLAN_XQ")
	private long beOnDutyPlanXq;

	@Temporal(TemporalType.DATE)
	@Column(name="BE_ON_DUTY_PLAN_XQ_DATE")
	private Date beOnDutyPlanXqDate;

	//bi-directional many-to-one association to Bclass
	@ManyToOne
	@JoinColumn(name="BCLASSES_ID")
	private Bclass bclass;

	//bi-directional many-to-one association to BeOnDutyPlan
	@ManyToOne
	@JoinColumn(name="BE_ON_DUTY_PLAN_ID")
	private BeOnDutyPlan beOnDutyPlan;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	public BeOnDutyPlanXq() {
	}

	public long getBeOnDutyPlanXq() {
		return this.beOnDutyPlanXq;
	}

	public void setBeOnDutyPlanXq(long beOnDutyPlanXq) {
		this.beOnDutyPlanXq = beOnDutyPlanXq;
	}

	public Date getBeOnDutyPlanXqDate() {
		return this.beOnDutyPlanXqDate;
	}

	public void setBeOnDutyPlanXqDate(Date beOnDutyPlanXqDate) {
		this.beOnDutyPlanXqDate = beOnDutyPlanXqDate;
	}

	public Bclass getBclass() {
		return this.bclass;
	}

	public void setBclass(Bclass bclass) {
		this.bclass = bclass;
	}

	public BeOnDutyPlan getBeOnDutyPlan() {
		return this.beOnDutyPlan;
	}

	public void setBeOnDutyPlan(BeOnDutyPlan beOnDutyPlan) {
		this.beOnDutyPlan = beOnDutyPlan;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}