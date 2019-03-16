package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the CHUYUAN_INFORM database table.
 * 
 */
@Entity
@Table(name="CHUYUAN_INFORM")
@NamedQuery(name="ChuyuanInform.findAll", query="SELECT c FROM ChuyuanInform c")
public class ChuyuanInform implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CHUYUAN_INFORM_ID")
	private String chuyuanInformId;

	@Temporal(TemporalType.DATE)
	@Column(name="CHUYUAN_INFORM_DATE")
	private Date chuyuanInformDate;

	@Column(name="CHUYUAN_INFORM_FEIYONG_ZMONEY")
	private BigDecimal chuyuanInformFeiyongZmoney;

	@Column(name="CHUYUAN_INFORM_REMARK")
	private String chuyuanInformRemark;

	@Column(name="CHUYUAN_INFORM_STATE")
	private String chuyuanInformState;

	@Column(name="CHUYUAN_INFORM_TYPE")
	private String chuyuanInformType;

	@Column(name="CHUYUAN_INFORM_YAJIN_ZMONEY")
	private BigDecimal chuyuanInformYajinZmoney;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	//bi-directional many-to-one association to YajinTuifei
	@OneToMany(mappedBy="chuyuanInform")
	private List<YajinTuifei> yajinTuifeis;

	//bi-directional many-to-one association to ChuyuanLogin
	@OneToMany(mappedBy="chuyuanInform")
	private List<ChuyuanLogin> chuyuanLogins;

	public ChuyuanInform() {
	}

	public String getChuyuanInformId() {
		return this.chuyuanInformId;
	}

	public void setChuyuanInformId(String chuyuanInformId) {
		this.chuyuanInformId = chuyuanInformId;
	}

	public Date getChuyuanInformDate() {
		return this.chuyuanInformDate;
	}

	public void setChuyuanInformDate(Date chuyuanInformDate) {
		this.chuyuanInformDate = chuyuanInformDate;
	}

	public BigDecimal getChuyuanInformFeiyongZmoney() {
		return this.chuyuanInformFeiyongZmoney;
	}

	public void setChuyuanInformFeiyongZmoney(BigDecimal chuyuanInformFeiyongZmoney) {
		this.chuyuanInformFeiyongZmoney = chuyuanInformFeiyongZmoney;
	}

	public String getChuyuanInformRemark() {
		return this.chuyuanInformRemark;
	}

	public void setChuyuanInformRemark(String chuyuanInformRemark) {
		this.chuyuanInformRemark = chuyuanInformRemark;
	}

	public String getChuyuanInformState() {
		return this.chuyuanInformState;
	}

	public void setChuyuanInformState(String chuyuanInformState) {
		this.chuyuanInformState = chuyuanInformState;
	}

	public String getChuyuanInformType() {
		return this.chuyuanInformType;
	}

	public void setChuyuanInformType(String chuyuanInformType) {
		this.chuyuanInformType = chuyuanInformType;
	}

	public BigDecimal getChuyuanInformYajinZmoney() {
		return this.chuyuanInformYajinZmoney;
	}

	public void setChuyuanInformYajinZmoney(BigDecimal chuyuanInformYajinZmoney) {
		this.chuyuanInformYajinZmoney = chuyuanInformYajinZmoney;
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

	public List<YajinTuifei> getYajinTuifeis() {
		return this.yajinTuifeis;
	}

	public void setYajinTuifeis(List<YajinTuifei> yajinTuifeis) {
		this.yajinTuifeis = yajinTuifeis;
	}

	public YajinTuifei addYajinTuifei(YajinTuifei yajinTuifei) {
		getYajinTuifeis().add(yajinTuifei);
		yajinTuifei.setChuyuanInform(this);

		return yajinTuifei;
	}

	public YajinTuifei removeYajinTuifei(YajinTuifei yajinTuifei) {
		getYajinTuifeis().remove(yajinTuifei);
		yajinTuifei.setChuyuanInform(null);

		return yajinTuifei;
	}

	public List<ChuyuanLogin> getChuyuanLogins() {
		return this.chuyuanLogins;
	}

	public void setChuyuanLogins(List<ChuyuanLogin> chuyuanLogins) {
		this.chuyuanLogins = chuyuanLogins;
	}

	public ChuyuanLogin addChuyuanLogin(ChuyuanLogin chuyuanLogin) {
		getChuyuanLogins().add(chuyuanLogin);
		chuyuanLogin.setChuyuanInform(this);

		return chuyuanLogin;
	}

	public ChuyuanLogin removeChuyuanLogin(ChuyuanLogin chuyuanLogin) {
		getChuyuanLogins().remove(chuyuanLogin);
		chuyuanLogin.setChuyuanInform(null);

		return chuyuanLogin;
	}

}