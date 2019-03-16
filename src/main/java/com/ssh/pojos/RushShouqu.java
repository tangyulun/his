package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RUSH_SHOUQU database table.
 * 
 */
@Entity
@Table(name="RUSH_SHOUQU")
@NamedQuery(name="RushShouqu.findAll", query="SELECT r FROM RushShouqu r")
public class RushShouqu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RUSH_SHOUQU_ID")
	private String rushShouquId;

	@Temporal(TemporalType.DATE)
	@Column(name="RUSH_SHOUQU_DATE")
	private Date rushShouquDate;

	@Column(name="RUSH_SHOUQU_STATE")
	private String rushShouquState;

	@Column(name="RUSH_SHOUQU_YINGSHOU_MONEY")
	private BigDecimal rushShouquYingshouMoney;

	@Column(name="RUSH_SHOUQU_YUSHOU_MONEY")
	private BigDecimal rushShouquYushouMoney;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	//bi-directional many-to-one association to HospitaNotify
	@ManyToOne
	@JoinColumn(name="HOSPITAL_NOTIFY_NUMBER")
	private HospitaNotify hospitaNotify;

	//bi-directional many-to-one association to ZhuyuanYushou
	@OneToMany(mappedBy="rushShouqu")
	private List<ZhuyuanYushou> zhuyuanYushous;

	public RushShouqu() {
	}

	public String getRushShouquId() {
		return this.rushShouquId;
	}

	public void setRushShouquId(String rushShouquId) {
		this.rushShouquId = rushShouquId;
	}

	public Date getRushShouquDate() {
		return this.rushShouquDate;
	}

	public void setRushShouquDate(Date rushShouquDate) {
		this.rushShouquDate = rushShouquDate;
	}

	public String getRushShouquState() {
		return this.rushShouquState;
	}

	public void setRushShouquState(String rushShouquState) {
		this.rushShouquState = rushShouquState;
	}

	public BigDecimal getRushShouquYingshouMoney() {
		return this.rushShouquYingshouMoney;
	}

	public void setRushShouquYingshouMoney(BigDecimal rushShouquYingshouMoney) {
		this.rushShouquYingshouMoney = rushShouquYingshouMoney;
	}

	public BigDecimal getRushShouquYushouMoney() {
		return this.rushShouquYushouMoney;
	}

	public void setRushShouquYushouMoney(BigDecimal rushShouquYushouMoney) {
		this.rushShouquYushouMoney = rushShouquYushouMoney;
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

	public HospitaNotify getHospitaNotify() {
		return this.hospitaNotify;
	}

	public void setHospitaNotify(HospitaNotify hospitaNotify) {
		this.hospitaNotify = hospitaNotify;
	}

	public List<ZhuyuanYushou> getZhuyuanYushous() {
		return this.zhuyuanYushous;
	}

	public void setZhuyuanYushous(List<ZhuyuanYushou> zhuyuanYushous) {
		this.zhuyuanYushous = zhuyuanYushous;
	}

	public ZhuyuanYushou addZhuyuanYushous(ZhuyuanYushou zhuyuanYushous) {
		getZhuyuanYushous().add(zhuyuanYushous);
		zhuyuanYushous.setRushShouqu(this);

		return zhuyuanYushous;
	}

	public ZhuyuanYushou removeZhuyuanYushous(ZhuyuanYushou zhuyuanYushous) {
		getZhuyuanYushous().remove(zhuyuanYushous);
		zhuyuanYushous.setRushShouqu(null);

		return zhuyuanYushous;
	}

}