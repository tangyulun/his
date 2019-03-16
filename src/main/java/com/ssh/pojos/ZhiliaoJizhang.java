package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ZHILIAO_JIZHANG database table.
 * 
 */
@Entity
@Table(name="ZHILIAO_JIZHANG")
@NamedQuery(name="ZhiliaoJizhang.findAll", query="SELECT z FROM ZhiliaoJizhang z")
public class ZhiliaoJizhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHILIAO_JIZHANG_ID")
	private String zhiliaoJizhangId;

	@Temporal(TemporalType.DATE)
	@Column(name="ZHILIAO_JIZHANG_DATE")
	private Date zhiliaoJizhangDate;

	@Column(name="ZHILIAO_JIZHANG_SATE")
	private String zhiliaoJizhangSate;

	@Column(name="ZHILIAO_JIZHANG_STATE")
	private String zhiliaoJizhangState;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	//bi-directional many-to-one association to ZhiliaoJizhangXq
	@OneToMany(mappedBy="zhiliaoJizhang")
	private List<ZhiliaoJizhangXq> zhiliaoJizhangXqs;

	public ZhiliaoJizhang() {
	}

	public String getZhiliaoJizhangId() {
		return this.zhiliaoJizhangId;
	}

	public void setZhiliaoJizhangId(String zhiliaoJizhangId) {
		this.zhiliaoJizhangId = zhiliaoJizhangId;
	}

	public Date getZhiliaoJizhangDate() {
		return this.zhiliaoJizhangDate;
	}

	public void setZhiliaoJizhangDate(Date zhiliaoJizhangDate) {
		this.zhiliaoJizhangDate = zhiliaoJizhangDate;
	}

	public String getZhiliaoJizhangSate() {
		return this.zhiliaoJizhangSate;
	}

	public void setZhiliaoJizhangSate(String zhiliaoJizhangSate) {
		this.zhiliaoJizhangSate = zhiliaoJizhangSate;
	}

	public String getZhiliaoJizhangState() {
		return this.zhiliaoJizhangState;
	}

	public void setZhiliaoJizhangState(String zhiliaoJizhangState) {
		this.zhiliaoJizhangState = zhiliaoJizhangState;
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

	public List<ZhiliaoJizhangXq> getZhiliaoJizhangXqs() {
		return this.zhiliaoJizhangXqs;
	}

	public void setZhiliaoJizhangXqs(List<ZhiliaoJizhangXq> zhiliaoJizhangXqs) {
		this.zhiliaoJizhangXqs = zhiliaoJizhangXqs;
	}

	public ZhiliaoJizhangXq addZhiliaoJizhangXq(ZhiliaoJizhangXq zhiliaoJizhangXq) {
		getZhiliaoJizhangXqs().add(zhiliaoJizhangXq);
		zhiliaoJizhangXq.setZhiliaoJizhang(this);

		return zhiliaoJizhangXq;
	}

	public ZhiliaoJizhangXq removeZhiliaoJizhangXq(ZhiliaoJizhangXq zhiliaoJizhangXq) {
		getZhiliaoJizhangXqs().remove(zhiliaoJizhangXq);
		zhiliaoJizhangXq.setZhiliaoJizhang(null);

		return zhiliaoJizhangXq;
	}

}