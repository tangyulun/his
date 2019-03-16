package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ZHUYUAN_FAYAO database table.
 * 
 */
@Entity
@Table(name="ZHUYUAN_FAYAO")
@NamedQuery(name="ZhuyuanFayao.findAll", query="SELECT z FROM ZhuyuanFayao z")
public class ZhuyuanFayao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHUYUAN_FAYAO_ID")
	private String zhuyuanFayaoId;

	@Temporal(TemporalType.DATE)
	@Column(name="ZHUYUAN_FAYAO_DATE")
	private Date zhuyuanFayaoDate;

	@Column(name="ZHUYUAN_FAYAO_HOUSE")
	private String zhuyuanFayaoHouse;

	@Column(name="ZHUYUAN_FAYAO_STATE")
	private String zhuyuanFayaoState;

	@Column(name="ZHUYUAN_FAYAO_TYPE")
	private String zhuyuanFayaoType;

	@Column(name="ZHUYUAN_FAYAO_ZMONEY")
	private BigDecimal zhuyuanFayaoZmoney;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRESCRIPTION_ID")
	private Prescription prescription;

	//bi-directional many-to-one association to ZhuyuanFayaoXq
	@OneToMany(mappedBy="zhuyuanFayao")
	private List<ZhuyuanFayaoXq> zhuyuanFayaoXqs;

	public ZhuyuanFayao() {
	}

	public String getZhuyuanFayaoId() {
		return this.zhuyuanFayaoId;
	}

	public void setZhuyuanFayaoId(String zhuyuanFayaoId) {
		this.zhuyuanFayaoId = zhuyuanFayaoId;
	}

	public Date getZhuyuanFayaoDate() {
		return this.zhuyuanFayaoDate;
	}

	public void setZhuyuanFayaoDate(Date zhuyuanFayaoDate) {
		this.zhuyuanFayaoDate = zhuyuanFayaoDate;
	}

	public String getZhuyuanFayaoHouse() {
		return this.zhuyuanFayaoHouse;
	}

	public void setZhuyuanFayaoHouse(String zhuyuanFayaoHouse) {
		this.zhuyuanFayaoHouse = zhuyuanFayaoHouse;
	}

	public String getZhuyuanFayaoState() {
		return this.zhuyuanFayaoState;
	}

	public void setZhuyuanFayaoState(String zhuyuanFayaoState) {
		this.zhuyuanFayaoState = zhuyuanFayaoState;
	}

	public String getZhuyuanFayaoType() {
		return this.zhuyuanFayaoType;
	}

	public void setZhuyuanFayaoType(String zhuyuanFayaoType) {
		this.zhuyuanFayaoType = zhuyuanFayaoType;
	}

	public BigDecimal getZhuyuanFayaoZmoney() {
		return this.zhuyuanFayaoZmoney;
	}

	public void setZhuyuanFayaoZmoney(BigDecimal zhuyuanFayaoZmoney) {
		this.zhuyuanFayaoZmoney = zhuyuanFayaoZmoney;
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

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public List<ZhuyuanFayaoXq> getZhuyuanFayaoXqs() {
		return this.zhuyuanFayaoXqs;
	}

	public void setZhuyuanFayaoXqs(List<ZhuyuanFayaoXq> zhuyuanFayaoXqs) {
		this.zhuyuanFayaoXqs = zhuyuanFayaoXqs;
	}

	public ZhuyuanFayaoXq addZhuyuanFayaoXq(ZhuyuanFayaoXq zhuyuanFayaoXq) {
		getZhuyuanFayaoXqs().add(zhuyuanFayaoXq);
		zhuyuanFayaoXq.setZhuyuanFayao(this);

		return zhuyuanFayaoXq;
	}

	public ZhuyuanFayaoXq removeZhuyuanFayaoXq(ZhuyuanFayaoXq zhuyuanFayaoXq) {
		getZhuyuanFayaoXqs().remove(zhuyuanFayaoXq);
		zhuyuanFayaoXq.setZhuyuanFayao(null);

		return zhuyuanFayaoXq;
	}

}