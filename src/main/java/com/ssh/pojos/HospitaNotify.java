package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HOSPITA_NOTIFY database table.
 * 
 */
@Entity
@Table(name="HOSPITA_NOTIFY")
@NamedQuery(name="HospitaNotify.findAll", query="SELECT h FROM HospitaNotify h")
public class HospitaNotify implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HOSPITAL_NOTIFY_NUMBER")
	private String hospitalNotifyNumber;

	@Column(name="HOSPITAL_NOTIFY_ALERT_THE_JINE")
	private BigDecimal hospitalNotifyAlertTheJine;

	@Column(name="HOSPITAL_NOTIFY_CASH_FEIYONG")
	private BigDecimal hospitalNotifyCashFeiyong;

	@Column(name="HOSPITAL_NOTIFY_CASH_YANJIN")
	private BigDecimal hospitalNotifyCashYanjin;

	@Column(name="HOSPITAL_NOTIFY_COST")
	private BigDecimal hospitalNotifyCost;

	@Temporal(TemporalType.DATE)
	@Column(name="HOSPITAL_NOTIFY_DATE")
	private Date hospitalNotifyDate;

	@Column(name="HOSPITAL_NOTIFY_EXPLAIN")
	private String hospitalNotifyExplain;

	@Column(name="HOSPITAL_NOTIFY_STATE")
	private String hospitalNotifyState;

	//bi-directional many-to-one association to HospitalRegistration
	@OneToMany(mappedBy="hospitaNotify")
	private List<HospitalRegistration> hospitalRegistrations;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	//bi-directional many-to-one association to RushShouqu
	@OneToMany(mappedBy="hospitaNotify")
	private List<RushShouqu> rushShouqus;

	public HospitaNotify() {
	}

	public String getHospitalNotifyNumber() {
		return this.hospitalNotifyNumber;
	}

	public void setHospitalNotifyNumber(String hospitalNotifyNumber) {
		this.hospitalNotifyNumber = hospitalNotifyNumber;
	}

	public BigDecimal getHospitalNotifyAlertTheJine() {
		return this.hospitalNotifyAlertTheJine;
	}

	public void setHospitalNotifyAlertTheJine(BigDecimal hospitalNotifyAlertTheJine) {
		this.hospitalNotifyAlertTheJine = hospitalNotifyAlertTheJine;
	}

	public BigDecimal getHospitalNotifyCashFeiyong() {
		return this.hospitalNotifyCashFeiyong;
	}

	public void setHospitalNotifyCashFeiyong(BigDecimal hospitalNotifyCashFeiyong) {
		this.hospitalNotifyCashFeiyong = hospitalNotifyCashFeiyong;
	}

	public BigDecimal getHospitalNotifyCashYanjin() {
		return this.hospitalNotifyCashYanjin;
	}

	public void setHospitalNotifyCashYanjin(BigDecimal hospitalNotifyCashYanjin) {
		this.hospitalNotifyCashYanjin = hospitalNotifyCashYanjin;
	}

	public BigDecimal getHospitalNotifyCost() {
		return this.hospitalNotifyCost;
	}

	public void setHospitalNotifyCost(BigDecimal hospitalNotifyCost) {
		this.hospitalNotifyCost = hospitalNotifyCost;
	}

	public Date getHospitalNotifyDate() {
		return this.hospitalNotifyDate;
	}

	public void setHospitalNotifyDate(Date hospitalNotifyDate) {
		this.hospitalNotifyDate = hospitalNotifyDate;
	}

	public String getHospitalNotifyExplain() {
		return this.hospitalNotifyExplain;
	}

	public void setHospitalNotifyExplain(String hospitalNotifyExplain) {
		this.hospitalNotifyExplain = hospitalNotifyExplain;
	}

	public String getHospitalNotifyState() {
		return this.hospitalNotifyState;
	}

	public void setHospitalNotifyState(String hospitalNotifyState) {
		this.hospitalNotifyState = hospitalNotifyState;
	}

	public List<HospitalRegistration> getHospitalRegistrations() {
		return this.hospitalRegistrations;
	}

	public void setHospitalRegistrations(List<HospitalRegistration> hospitalRegistrations) {
		this.hospitalRegistrations = hospitalRegistrations;
	}

	public HospitalRegistration addHospitalRegistration(HospitalRegistration hospitalRegistration) {
		getHospitalRegistrations().add(hospitalRegistration);
		hospitalRegistration.setHospitaNotify(this);

		return hospitalRegistration;
	}

	public HospitalRegistration removeHospitalRegistration(HospitalRegistration hospitalRegistration) {
		getHospitalRegistrations().remove(hospitalRegistration);
		hospitalRegistration.setHospitaNotify(null);

		return hospitalRegistration;
	}

	public OutpaitentRegist getOutpaitentRegist() {
		return this.outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public List<RushShouqu> getRushShouqus() {
		return this.rushShouqus;
	}

	public void setRushShouqus(List<RushShouqu> rushShouqus) {
		this.rushShouqus = rushShouqus;
	}

	public RushShouqu addRushShouqus(RushShouqu rushShouqus) {
		getRushShouqus().add(rushShouqus);
		rushShouqus.setHospitaNotify(this);

		return rushShouqus;
	}

	public RushShouqu removeRushShouqus(RushShouqu rushShouqus) {
		getRushShouqus().remove(rushShouqus);
		rushShouqus.setHospitaNotify(null);

		return rushShouqus;
	}

}