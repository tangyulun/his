package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the FAYAO_JIZHANG database table.
 * 
 */
@Entity
@Table(name="FAYAO_JIZHANG")
@NamedQuery(name="FayaoJizhang.findAll", query="SELECT f FROM FayaoJizhang f")
public class FayaoJizhang implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHUYUAN_JIZHANG_ID")
	private String zhuyuanJizhangId;

	@Temporal(TemporalType.DATE)
	@Column(name="ZHUYUAN_JIZHANG_DATE")
	private Date zhuyuanJizhangDate;

	@Column(name="ZHUYUAN_JIZHANG_SATE")
	private String zhuyuanJizhangSate;

	@Column(name="ZHUYUAN_JIZHANG_STATE")
	private String zhuyuanJizhangState;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	//bi-directional many-to-one association to FayaoJizhangXq
	@OneToMany(mappedBy="fayaoJizhang")
	private List<FayaoJizhangXq> fayaoJizhangXqs;

	public FayaoJizhang() {
	}

	public String getZhuyuanJizhangId() {
		return this.zhuyuanJizhangId;
	}

	public void setZhuyuanJizhangId(String zhuyuanJizhangId) {
		this.zhuyuanJizhangId = zhuyuanJizhangId;
	}

	public Date getZhuyuanJizhangDate() {
		return this.zhuyuanJizhangDate;
	}

	public void setZhuyuanJizhangDate(Date zhuyuanJizhangDate) {
		this.zhuyuanJizhangDate = zhuyuanJizhangDate;
	}

	public String getZhuyuanJizhangSate() {
		return this.zhuyuanJizhangSate;
	}

	public void setZhuyuanJizhangSate(String zhuyuanJizhangSate) {
		this.zhuyuanJizhangSate = zhuyuanJizhangSate;
	}

	public String getZhuyuanJizhangState() {
		return this.zhuyuanJizhangState;
	}

	public void setZhuyuanJizhangState(String zhuyuanJizhangState) {
		this.zhuyuanJizhangState = zhuyuanJizhangState;
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

	public List<FayaoJizhangXq> getFayaoJizhangXqs() {
		return this.fayaoJizhangXqs;
	}

	public void setFayaoJizhangXqs(List<FayaoJizhangXq> fayaoJizhangXqs) {
		this.fayaoJizhangXqs = fayaoJizhangXqs;
	}

	public FayaoJizhangXq addFayaoJizhangXq(FayaoJizhangXq fayaoJizhangXq) {
		getFayaoJizhangXqs().add(fayaoJizhangXq);
		fayaoJizhangXq.setFayaoJizhang(this);

		return fayaoJizhangXq;
	}

	public FayaoJizhangXq removeFayaoJizhangXq(FayaoJizhangXq fayaoJizhangXq) {
		getFayaoJizhangXqs().remove(fayaoJizhangXq);
		fayaoJizhangXq.setFayaoJizhang(null);

		return fayaoJizhangXq;
	}

}