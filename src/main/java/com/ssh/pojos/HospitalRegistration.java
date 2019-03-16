package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the HOSPITAL_REGISTRATION database table.
 * 
 */
@Entity
@Table(name="HOSPITAL_REGISTRATION")
@NamedQuery(name="HospitalRegistration.findAll", query="SELECT h FROM HospitalRegistration h")
public class HospitalRegistration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HOSPITAL_REGISTRATION_ID")
	private String hospitalRegistrationId;

	@Temporal(TemporalType.DATE)
	@Column(name="HOSPITAL_REGISTRATION_DATE")
	private Date hospitalRegistrationDate;

	@Column(name="HOSPITAL_REGISTRATION_STATE")
	private String hospitalRegistrationState;

	//bi-directional many-to-one association to BedTiaozheng
	@OneToMany(mappedBy="hospitalRegistration")
	private List<BedTiaozheng> bedTiaozhengs;

	//bi-directional many-to-one association to ChuyuanInform
	@OneToMany(mappedBy="hospitalRegistration")
	private List<ChuyuanInform> chuyuanInforms;

	//bi-directional many-to-one association to FayaoJizhang
	@OneToMany(mappedBy="hospitalRegistration")
	private List<FayaoJizhang> fayaoJizhangs;

	//bi-directional many-to-one association to Bed
	@ManyToOne
	@JoinColumn(name="BED_ID")
	private Bed bed;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitaNotify
	@ManyToOne
	@JoinColumn(name="HOSPITAL_NOTIFY_NUMBER")
	private HospitaNotify hospitaNotify;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="hospitalRegistration")
	private List<Prescription> prescriptions;

	//bi-directional many-to-one association to RushFee
	@OneToMany(mappedBy="hospitalRegistration")
	private List<RushFee> rushFees;

	//bi-directional many-to-one association to RushShouqu
	@OneToMany(mappedBy="hospitalRegistration")
	private List<RushShouqu> rushShouqus;

	//bi-directional many-to-one association to ShoushuMess
	@OneToMany(mappedBy="hospitalRegistration")
	private List<ShoushuMess> shoushuMesses;

	//bi-directional many-to-one association to ZhiliaoJizhang
	@OneToMany(mappedBy="hospitalRegistration")
	private List<ZhiliaoJizhang> zhiliaoJizhangs;

	//bi-directional many-to-one association to ZhuyuanFayao
	@OneToMany(mappedBy="hospitalRegistration")
	private List<ZhuyuanFayao> zhuyuanFayaos;

	//bi-directional many-to-one association to ZhuyuanHesuan
	@OneToMany(mappedBy="hospitalRegistration")
	private List<ZhuyuanHesuan> zhuyuanHesuans;

	//bi-directional many-to-one association to ZhuyuanJiezhang
	@OneToMany(mappedBy="hospitalRegistration")
	private List<ZhuyuanJiezhang> zhuyuanJiezhangs;

	public HospitalRegistration() {
	}

	public String getHospitalRegistrationId() {
		return this.hospitalRegistrationId;
	}

	public void setHospitalRegistrationId(String hospitalRegistrationId) {
		this.hospitalRegistrationId = hospitalRegistrationId;
	}

	public Date getHospitalRegistrationDate() {
		return this.hospitalRegistrationDate;
	}

	public void setHospitalRegistrationDate(Date hospitalRegistrationDate) {
		this.hospitalRegistrationDate = hospitalRegistrationDate;
	}

	public String getHospitalRegistrationState() {
		return this.hospitalRegistrationState;
	}

	public void setHospitalRegistrationState(String hospitalRegistrationState) {
		this.hospitalRegistrationState = hospitalRegistrationState;
	}

	public List<BedTiaozheng> getBedTiaozhengs() {
		return this.bedTiaozhengs;
	}

	public void setBedTiaozhengs(List<BedTiaozheng> bedTiaozhengs) {
		this.bedTiaozhengs = bedTiaozhengs;
	}

	public BedTiaozheng addBedTiaozheng(BedTiaozheng bedTiaozheng) {
		getBedTiaozhengs().add(bedTiaozheng);
		bedTiaozheng.setHospitalRegistration(this);

		return bedTiaozheng;
	}

	public BedTiaozheng removeBedTiaozheng(BedTiaozheng bedTiaozheng) {
		getBedTiaozhengs().remove(bedTiaozheng);
		bedTiaozheng.setHospitalRegistration(null);

		return bedTiaozheng;
	}

	public List<ChuyuanInform> getChuyuanInforms() {
		return this.chuyuanInforms;
	}

	public void setChuyuanInforms(List<ChuyuanInform> chuyuanInforms) {
		this.chuyuanInforms = chuyuanInforms;
	}

	public ChuyuanInform addChuyuanInform(ChuyuanInform chuyuanInform) {
		getChuyuanInforms().add(chuyuanInform);
		chuyuanInform.setHospitalRegistration(this);

		return chuyuanInform;
	}

	public ChuyuanInform removeChuyuanInform(ChuyuanInform chuyuanInform) {
		getChuyuanInforms().remove(chuyuanInform);
		chuyuanInform.setHospitalRegistration(null);

		return chuyuanInform;
	}

	public List<FayaoJizhang> getFayaoJizhangs() {
		return this.fayaoJizhangs;
	}

	public void setFayaoJizhangs(List<FayaoJizhang> fayaoJizhangs) {
		this.fayaoJizhangs = fayaoJizhangs;
	}

	public FayaoJizhang addFayaoJizhang(FayaoJizhang fayaoJizhang) {
		getFayaoJizhangs().add(fayaoJizhang);
		fayaoJizhang.setHospitalRegistration(this);

		return fayaoJizhang;
	}

	public FayaoJizhang removeFayaoJizhang(FayaoJizhang fayaoJizhang) {
		getFayaoJizhangs().remove(fayaoJizhang);
		fayaoJizhang.setHospitalRegistration(null);

		return fayaoJizhang;
	}

	public Bed getBed() {
		return this.bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public HospitaNotify getHospitaNotify() {
		return this.hospitaNotify;
	}

	public void setHospitaNotify(HospitaNotify hospitaNotify) {
		this.hospitaNotify = hospitaNotify;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setHospitalRegistration(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setHospitalRegistration(null);

		return prescription;
	}

	public List<RushFee> getRushFees() {
		return this.rushFees;
	}

	public void setRushFees(List<RushFee> rushFees) {
		this.rushFees = rushFees;
	}

	public RushFee addRushFee(RushFee rushFee) {
		getRushFees().add(rushFee);
		rushFee.setHospitalRegistration(this);

		return rushFee;
	}

	public RushFee removeRushFee(RushFee rushFee) {
		getRushFees().remove(rushFee);
		rushFee.setHospitalRegistration(null);

		return rushFee;
	}

	public List<RushShouqu> getRushShouqus() {
		return this.rushShouqus;
	}

	public void setRushShouqus(List<RushShouqu> rushShouqus) {
		this.rushShouqus = rushShouqus;
	}

	public RushShouqu addRushShouqus(RushShouqu rushShouqus) {
		getRushShouqus().add(rushShouqus);
		rushShouqus.setHospitalRegistration(this);

		return rushShouqus;
	}

	public RushShouqu removeRushShouqus(RushShouqu rushShouqus) {
		getRushShouqus().remove(rushShouqus);
		rushShouqus.setHospitalRegistration(null);

		return rushShouqus;
	}

	public List<ShoushuMess> getShoushuMesses() {
		return this.shoushuMesses;
	}

	public void setShoushuMesses(List<ShoushuMess> shoushuMesses) {
		this.shoushuMesses = shoushuMesses;
	}

	public ShoushuMess addShoushuMess(ShoushuMess shoushuMess) {
		getShoushuMesses().add(shoushuMess);
		shoushuMess.setHospitalRegistration(this);

		return shoushuMess;
	}

	public ShoushuMess removeShoushuMess(ShoushuMess shoushuMess) {
		getShoushuMesses().remove(shoushuMess);
		shoushuMess.setHospitalRegistration(null);

		return shoushuMess;
	}

	public List<ZhiliaoJizhang> getZhiliaoJizhangs() {
		return this.zhiliaoJizhangs;
	}

	public void setZhiliaoJizhangs(List<ZhiliaoJizhang> zhiliaoJizhangs) {
		this.zhiliaoJizhangs = zhiliaoJizhangs;
	}

	public ZhiliaoJizhang addZhiliaoJizhang(ZhiliaoJizhang zhiliaoJizhang) {
		getZhiliaoJizhangs().add(zhiliaoJizhang);
		zhiliaoJizhang.setHospitalRegistration(this);

		return zhiliaoJizhang;
	}

	public ZhiliaoJizhang removeZhiliaoJizhang(ZhiliaoJizhang zhiliaoJizhang) {
		getZhiliaoJizhangs().remove(zhiliaoJizhang);
		zhiliaoJizhang.setHospitalRegistration(null);

		return zhiliaoJizhang;
	}

	public List<ZhuyuanFayao> getZhuyuanFayaos() {
		return this.zhuyuanFayaos;
	}

	public void setZhuyuanFayaos(List<ZhuyuanFayao> zhuyuanFayaos) {
		this.zhuyuanFayaos = zhuyuanFayaos;
	}

	public ZhuyuanFayao addZhuyuanFayao(ZhuyuanFayao zhuyuanFayao) {
		getZhuyuanFayaos().add(zhuyuanFayao);
		zhuyuanFayao.setHospitalRegistration(this);

		return zhuyuanFayao;
	}

	public ZhuyuanFayao removeZhuyuanFayao(ZhuyuanFayao zhuyuanFayao) {
		getZhuyuanFayaos().remove(zhuyuanFayao);
		zhuyuanFayao.setHospitalRegistration(null);

		return zhuyuanFayao;
	}

	public List<ZhuyuanHesuan> getZhuyuanHesuans() {
		return this.zhuyuanHesuans;
	}

	public void setZhuyuanHesuans(List<ZhuyuanHesuan> zhuyuanHesuans) {
		this.zhuyuanHesuans = zhuyuanHesuans;
	}

	public ZhuyuanHesuan addZhuyuanHesuan(ZhuyuanHesuan zhuyuanHesuan) {
		getZhuyuanHesuans().add(zhuyuanHesuan);
		zhuyuanHesuan.setHospitalRegistration(this);

		return zhuyuanHesuan;
	}

	public ZhuyuanHesuan removeZhuyuanHesuan(ZhuyuanHesuan zhuyuanHesuan) {
		getZhuyuanHesuans().remove(zhuyuanHesuan);
		zhuyuanHesuan.setHospitalRegistration(null);

		return zhuyuanHesuan;
	}

	public List<ZhuyuanJiezhang> getZhuyuanJiezhangs() {
		return this.zhuyuanJiezhangs;
	}

	public void setZhuyuanJiezhangs(List<ZhuyuanJiezhang> zhuyuanJiezhangs) {
		this.zhuyuanJiezhangs = zhuyuanJiezhangs;
	}

	public ZhuyuanJiezhang addZhuyuanJiezhang(ZhuyuanJiezhang zhuyuanJiezhang) {
		getZhuyuanJiezhangs().add(zhuyuanJiezhang);
		zhuyuanJiezhang.setHospitalRegistration(this);

		return zhuyuanJiezhang;
	}

	public ZhuyuanJiezhang removeZhuyuanJiezhang(ZhuyuanJiezhang zhuyuanJiezhang) {
		getZhuyuanJiezhangs().remove(zhuyuanJiezhang);
		zhuyuanJiezhang.setHospitalRegistration(null);

		return zhuyuanJiezhang;
	}

}