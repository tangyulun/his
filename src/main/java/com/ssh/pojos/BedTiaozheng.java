package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the BED_TIAOZHENG database table.
 * 
 */
@Entity
@Table(name="BED_TIAOZHENG")
@NamedQuery(name="BedTiaozheng.findAll", query="SELECT b FROM BedTiaozheng b")
public class BedTiaozheng implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BED_TIAOZHENG_ID")
	private String bedTiaozhengId;

	@Temporal(TemporalType.DATE)
	@Column(name="BED_TIAOZHENG_DATE")
	private Date bedTiaozhengDate;

	@Column(name="BED_TIAOZHENG_REMARK")
	private String bedTiaozhengRemark;

	@Column(name="BED_TIAOZHENG_STATE")
	private String bedTiaozhengState;

	//bi-directional many-to-one association to Bed
	@ManyToOne
	@JoinColumn(name="BED_ID")
	private Bed bed;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_EMP_ID")
	private Emp emp1;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp2;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	public BedTiaozheng() {
	}

	public String getBedTiaozhengId() {
		return this.bedTiaozhengId;
	}

	public void setBedTiaozhengId(String bedTiaozhengId) {
		this.bedTiaozhengId = bedTiaozhengId;
	}

	public Date getBedTiaozhengDate() {
		return this.bedTiaozhengDate;
	}

	public void setBedTiaozhengDate(Date bedTiaozhengDate) {
		this.bedTiaozhengDate = bedTiaozhengDate;
	}

	public String getBedTiaozhengRemark() {
		return this.bedTiaozhengRemark;
	}

	public void setBedTiaozhengRemark(String bedTiaozhengRemark) {
		this.bedTiaozhengRemark = bedTiaozhengRemark;
	}

	public String getBedTiaozhengState() {
		return this.bedTiaozhengState;
	}

	public void setBedTiaozhengState(String bedTiaozhengState) {
		this.bedTiaozhengState = bedTiaozhengState;
	}

	public Bed getBed() {
		return this.bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public Emp getEmp1() {
		return this.emp1;
	}

	public void setEmp1(Emp emp1) {
		this.emp1 = emp1;
	}

	public Emp getEmp2() {
		return this.emp2;
	}

	public void setEmp2(Emp emp2) {
		this.emp2 = emp2;
	}

	public HospitalRegistration getHospitalRegistration() {
		return this.hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistration hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

}