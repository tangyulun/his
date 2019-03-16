package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the SHOUSHU_MESS database table.
 * 
 */
@Entity
@Table(name="SHOUSHU_MESS")
@NamedQuery(name="ShoushuMess.findAll", query="SELECT s FROM ShoushuMess s")
public class ShoushuMess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SHOUSHU_MESS")
	private String shoushuMess;

	@Temporal(TemporalType.DATE)
	@Column(name="SHOUSHU_MESS_DATE")
	private Date shoushuMessDate;

	@Column(name="SHOUSHU_MESS_MONEY")
	private BigDecimal shoushuMessMoney;

	@Column(name="SHOUSHU_MESS_STATE")
	private String shoushuMessState;

	@Column(name="SHOUSHU_MESS_TYPE")
	private String shoushuMessType;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	//bi-directional many-to-one association to Shoushu
	@ManyToOne
	@JoinColumn(name="SHOUSHU_ID")
	private Shoushu shoushu;

	//bi-directional many-to-one association to ShoushuMessXq
	@OneToMany(mappedBy="shoushuMessBean")
	private List<ShoushuMessXq> shoushuMessXqs;

	public ShoushuMess() {
	}

	public String getShoushuMess() {
		return this.shoushuMess;
	}

	public void setShoushuMess(String shoushuMess) {
		this.shoushuMess = shoushuMess;
	}

	public Date getShoushuMessDate() {
		return this.shoushuMessDate;
	}

	public void setShoushuMessDate(Date shoushuMessDate) {
		this.shoushuMessDate = shoushuMessDate;
	}

	public BigDecimal getShoushuMessMoney() {
		return this.shoushuMessMoney;
	}

	public void setShoushuMessMoney(BigDecimal shoushuMessMoney) {
		this.shoushuMessMoney = shoushuMessMoney;
	}

	public String getShoushuMessState() {
		return this.shoushuMessState;
	}

	public void setShoushuMessState(String shoushuMessState) {
		this.shoushuMessState = shoushuMessState;
	}

	public String getShoushuMessType() {
		return this.shoushuMessType;
	}

	public void setShoushuMessType(String shoushuMessType) {
		this.shoushuMessType = shoushuMessType;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public HospitalRegistration getHospitalRegistration() {
		return this.hospitalRegistration;
	}

	public void setHospitalRegistration(HospitalRegistration hospitalRegistration) {
		this.hospitalRegistration = hospitalRegistration;
	}

	public Shoushu getShoushu() {
		return this.shoushu;
	}

	public void setShoushu(Shoushu shoushu) {
		this.shoushu = shoushu;
	}

	public List<ShoushuMessXq> getShoushuMessXqs() {
		return this.shoushuMessXqs;
	}

	public void setShoushuMessXqs(List<ShoushuMessXq> shoushuMessXqs) {
		this.shoushuMessXqs = shoushuMessXqs;
	}

	public ShoushuMessXq addShoushuMessXq(ShoushuMessXq shoushuMessXq) {
		getShoushuMessXqs().add(shoushuMessXq);
		shoushuMessXq.setShoushuMessBean(this);

		return shoushuMessXq;
	}

	public ShoushuMessXq removeShoushuMessXq(ShoushuMessXq shoushuMessXq) {
		getShoushuMessXqs().remove(shoushuMessXq);
		shoushuMessXq.setShoushuMessBean(null);

		return shoushuMessXq;
	}

}