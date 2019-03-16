package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMP database table.
 * 
 */
@Entity
@NamedQuery(name="Emp.findAll", query="SELECT e FROM Emp e")
public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EMP_ID")
	private long empId;

	@Temporal(TemporalType.DATE)
	@Column(name="EMP_DATE")
	private Date empDate;

	@Column(name="EMP_LOGIN_NAME")
	private String empLoginName;

	@Column(name="EMP_NAME")
	private String empName;

	@Column(name="EMP_PWD")
	private String empPwd;

	@Column(name="EMP_SEX")
	private String empSex;

	@Column(name="EMP_STATE")
	private BigDecimal empState;

	//bi-directional many-to-one association to Bed
	@OneToMany(mappedBy="emp")
	private List<Bed> beds;

	//bi-directional many-to-one association to BedTiaozheng
	@OneToMany(mappedBy="emp1")
	private List<BedTiaozheng> bedTiaozhengs1;

	//bi-directional many-to-one association to BedTiaozheng
	@OneToMany(mappedBy="emp2")
	private List<BedTiaozheng> bedTiaozhengs2;

	//bi-directional many-to-one association to BeOnDutyPlanXq
	@OneToMany(mappedBy="emp")
	private List<BeOnDutyPlanXq> beOnDutyPlanXqs;

	//bi-directional many-to-one association to CaozuoLogger
	@OneToMany(mappedBy="emp")
	private List<CaozuoLogger> caozuoLoggers;

	//bi-directional many-to-one association to ChargeJiesuan
	@OneToMany(mappedBy="emp")
	private List<ChargeJiesuan> chargeJiesuans;

	//bi-directional many-to-one association to ChuyuanInform
	@OneToMany(mappedBy="emp")
	private List<ChuyuanInform> chuyuanInforms;

	//bi-directional many-to-one association to DrugDelivery
	@OneToMany(mappedBy="emp")
	private List<DrugDelivery> drugDeliveries;

	//bi-directional many-to-one association to DrugInventory
	@OneToMany(mappedBy="emp")
	private List<DrugInventory> drugInventories;

	//bi-directional many-to-one association to DrugPurchase
	@OneToMany(mappedBy="emp")
	private List<DrugPurchase> drugPurchases;

	//bi-directional many-to-one association to DrugTuihuo
	@OneToMany(mappedBy="emp")
	private List<DrugTuihuo> drugTuihuos;

	//bi-directional many-to-one association to DrugYaofang
	@OneToMany(mappedBy="emp")
	private List<DrugYaofang> drugYaofangs;

	//bi-directional many-to-one association to Dclass
	@ManyToOne
	@JoinColumn(name="DCLASS_ID")
	private Dclass dclass;

	//bi-directional many-to-one association to Dept
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Dept dept;

	//bi-directional many-to-one association to Zhiwu
	@ManyToOne
	@JoinColumn(name="ZHIWU_ID")
	private Zhiwu zhiwu;

	//bi-directional many-to-one association to EmpMessage
	@OneToMany(mappedBy="emp")
	private List<EmpMessage> empMessages;

	//bi-directional many-to-one association to FayaoJizhang
	@OneToMany(mappedBy="emp")
	private List<FayaoJizhang> fayaoJizhangs;

	//bi-directional many-to-one association to FinanceSumup
	@OneToMany(mappedBy="emp")
	private List<FinanceSumup> financeSumups;

	//bi-directional many-to-one association to Financial
	@OneToMany(mappedBy="emp")
	private List<Financial> financials;

	//bi-directional many-to-one association to HospitalRegistration
	@OneToMany(mappedBy="emp")
	private List<HospitalRegistration> hospitalRegistrations;

	//bi-directional many-to-one association to Instrument
	@OneToMany(mappedBy="emp")
	private List<Instrument> instruments;

	//bi-directional many-to-one association to InstrumentRk
	@OneToMany(mappedBy="emp")
	private List<InstrumentRk> instrumentRks;

	//bi-directional many-to-one association to Jianyan
	@OneToMany(mappedBy="emp")
	private List<Jianyan> jianyans;

	//bi-directional many-to-one association to JianyanMess
	@OneToMany(mappedBy="emp")
	private List<JianyanMess> jianyanMesses;

	//bi-directional many-to-one association to LoginLogger
	@OneToMany(mappedBy="emp")
	private List<LoginLogger> loginLoggers;

	//bi-directional many-to-one association to OutpaitentRegist
	@OneToMany(mappedBy="emp")
	private List<OutpaitentRegist> outpaitentRegists;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="emp")
	private List<Prescription> prescriptions;

	//bi-directional many-to-one association to PrescriptionType
	@OneToMany(mappedBy="emp")
	private List<PrescriptionType> prescriptionTypes;

	//bi-directional many-to-one association to QianDao
	@OneToMany(mappedBy="emp")
	private List<QianDao> qianDaos;

	//bi-directional many-to-one association to QxThelibrary
	@OneToMany(mappedBy="emp")
	private List<QxThelibrary> qxThelibraries;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
			name="USER_ROLES"
			, joinColumns={
				@JoinColumn(name="EMP_ID")
				}
			, inverseJoinColumns={
				@JoinColumn(name="ROLES_ID")
				}
			)
	private List<Role> roles;

	//bi-directional many-to-one association to RushShouqu
	@OneToMany(mappedBy="emp")
	private List<RushShouqu> rushShouqus;

	//bi-directional many-to-one association to Shoushu
	@OneToMany(mappedBy="emp")
	private List<Shoushu> shoushus;

	//bi-directional many-to-one association to ShoushuMess
	@OneToMany(mappedBy="emp")
	private List<ShoushuMess> shoushuMesses;

	//bi-directional many-to-one association to SupplierJiesuan
	@OneToMany(mappedBy="emp")
	private List<SupplierJiesuan> supplierJiesuans;

	//bi-directional many-to-one association to YajinTuifei
	@OneToMany(mappedBy="emp")
	private List<YajinTuifei> yajinTuifeis;

	//bi-directional many-to-one association to YaofangRuku
	@OneToMany(mappedBy="emp1")
	private List<YaofangRuku> yaofangRukus1;

	//bi-directional many-to-one association to YaofangRuku
	@OneToMany(mappedBy="emp2")
	private List<YaofangRuku> yaofangRukus2;

	//bi-directional many-to-one association to ZhiliaoJizhang
	@OneToMany(mappedBy="emp")
	private List<ZhiliaoJizhang> zhiliaoJizhangs;

	//bi-directional many-to-one association to ZhuyuanFayao
	@OneToMany(mappedBy="emp")
	private List<ZhuyuanFayao> zhuyuanFayaos;

	public Emp() {
	}

	public long getEmpId() {
		return this.empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public Date getEmpDate() {
		return this.empDate;
	}

	public void setEmpDate(Date empDate) {
		this.empDate = empDate;
	}

	public String getEmpLoginName() {
		return this.empLoginName;
	}

	public void setEmpLoginName(String empLoginName) {
		this.empLoginName = empLoginName;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPwd() {
		return this.empPwd;
	}

	public void setEmpPwd(String empPwd) {
		this.empPwd = empPwd;
	}

	public String getEmpSex() {
		return this.empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public BigDecimal getEmpState() {
		return this.empState;
	}

	public void setEmpState(BigDecimal empState) {
		this.empState = empState;
	}

	public List<Bed> getBeds() {
		return this.beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public Bed addBed(Bed bed) {
		getBeds().add(bed);
		bed.setEmp(this);

		return bed;
	}

	public Bed removeBed(Bed bed) {
		getBeds().remove(bed);
		bed.setEmp(null);

		return bed;
	}

	public List<BedTiaozheng> getBedTiaozhengs1() {
		return this.bedTiaozhengs1;
	}

	public void setBedTiaozhengs1(List<BedTiaozheng> bedTiaozhengs1) {
		this.bedTiaozhengs1 = bedTiaozhengs1;
	}

	public BedTiaozheng addBedTiaozhengs1(BedTiaozheng bedTiaozhengs1) {
		getBedTiaozhengs1().add(bedTiaozhengs1);
		bedTiaozhengs1.setEmp1(this);

		return bedTiaozhengs1;
	}

	public BedTiaozheng removeBedTiaozhengs1(BedTiaozheng bedTiaozhengs1) {
		getBedTiaozhengs1().remove(bedTiaozhengs1);
		bedTiaozhengs1.setEmp1(null);

		return bedTiaozhengs1;
	}

	public List<BedTiaozheng> getBedTiaozhengs2() {
		return this.bedTiaozhengs2;
	}

	public void setBedTiaozhengs2(List<BedTiaozheng> bedTiaozhengs2) {
		this.bedTiaozhengs2 = bedTiaozhengs2;
	}

	public BedTiaozheng addBedTiaozhengs2(BedTiaozheng bedTiaozhengs2) {
		getBedTiaozhengs2().add(bedTiaozhengs2);
		bedTiaozhengs2.setEmp2(this);

		return bedTiaozhengs2;
	}

	public BedTiaozheng removeBedTiaozhengs2(BedTiaozheng bedTiaozhengs2) {
		getBedTiaozhengs2().remove(bedTiaozhengs2);
		bedTiaozhengs2.setEmp2(null);

		return bedTiaozhengs2;
	}

	public List<BeOnDutyPlanXq> getBeOnDutyPlanXqs() {
		return this.beOnDutyPlanXqs;
	}

	public void setBeOnDutyPlanXqs(List<BeOnDutyPlanXq> beOnDutyPlanXqs) {
		this.beOnDutyPlanXqs = beOnDutyPlanXqs;
	}

	public BeOnDutyPlanXq addBeOnDutyPlanXq(BeOnDutyPlanXq beOnDutyPlanXq) {
		getBeOnDutyPlanXqs().add(beOnDutyPlanXq);
		beOnDutyPlanXq.setEmp(this);

		return beOnDutyPlanXq;
	}

	public BeOnDutyPlanXq removeBeOnDutyPlanXq(BeOnDutyPlanXq beOnDutyPlanXq) {
		getBeOnDutyPlanXqs().remove(beOnDutyPlanXq);
		beOnDutyPlanXq.setEmp(null);

		return beOnDutyPlanXq;
	}

	public List<CaozuoLogger> getCaozuoLoggers() {
		return this.caozuoLoggers;
	}

	public void setCaozuoLoggers(List<CaozuoLogger> caozuoLoggers) {
		this.caozuoLoggers = caozuoLoggers;
	}

	public CaozuoLogger addCaozuoLogger(CaozuoLogger caozuoLogger) {
		getCaozuoLoggers().add(caozuoLogger);
		caozuoLogger.setEmp(this);

		return caozuoLogger;
	}

	public CaozuoLogger removeCaozuoLogger(CaozuoLogger caozuoLogger) {
		getCaozuoLoggers().remove(caozuoLogger);
		caozuoLogger.setEmp(null);

		return caozuoLogger;
	}

	public List<ChargeJiesuan> getChargeJiesuans() {
		return this.chargeJiesuans;
	}

	public void setChargeJiesuans(List<ChargeJiesuan> chargeJiesuans) {
		this.chargeJiesuans = chargeJiesuans;
	}

	public ChargeJiesuan addChargeJiesuan(ChargeJiesuan chargeJiesuan) {
		getChargeJiesuans().add(chargeJiesuan);
		chargeJiesuan.setEmp(this);

		return chargeJiesuan;
	}

	public ChargeJiesuan removeChargeJiesuan(ChargeJiesuan chargeJiesuan) {
		getChargeJiesuans().remove(chargeJiesuan);
		chargeJiesuan.setEmp(null);

		return chargeJiesuan;
	}

	public List<ChuyuanInform> getChuyuanInforms() {
		return this.chuyuanInforms;
	}

	public void setChuyuanInforms(List<ChuyuanInform> chuyuanInforms) {
		this.chuyuanInforms = chuyuanInforms;
	}

	public ChuyuanInform addChuyuanInform(ChuyuanInform chuyuanInform) {
		getChuyuanInforms().add(chuyuanInform);
		chuyuanInform.setEmp(this);

		return chuyuanInform;
	}

	public ChuyuanInform removeChuyuanInform(ChuyuanInform chuyuanInform) {
		getChuyuanInforms().remove(chuyuanInform);
		chuyuanInform.setEmp(null);

		return chuyuanInform;
	}

	public List<DrugDelivery> getDrugDeliveries() {
		return this.drugDeliveries;
	}

	public void setDrugDeliveries(List<DrugDelivery> drugDeliveries) {
		this.drugDeliveries = drugDeliveries;
	}

	public DrugDelivery addDrugDelivery(DrugDelivery drugDelivery) {
		getDrugDeliveries().add(drugDelivery);
		drugDelivery.setEmp(this);

		return drugDelivery;
	}

	public DrugDelivery removeDrugDelivery(DrugDelivery drugDelivery) {
		getDrugDeliveries().remove(drugDelivery);
		drugDelivery.setEmp(null);

		return drugDelivery;
	}

	public List<DrugInventory> getDrugInventories() {
		return this.drugInventories;
	}

	public void setDrugInventories(List<DrugInventory> drugInventories) {
		this.drugInventories = drugInventories;
	}

	public DrugInventory addDrugInventory(DrugInventory drugInventory) {
		getDrugInventories().add(drugInventory);
		drugInventory.setEmp(this);

		return drugInventory;
	}

	public DrugInventory removeDrugInventory(DrugInventory drugInventory) {
		getDrugInventories().remove(drugInventory);
		drugInventory.setEmp(null);

		return drugInventory;
	}

	public List<DrugPurchase> getDrugPurchases() {
		return this.drugPurchases;
	}

	public void setDrugPurchases(List<DrugPurchase> drugPurchases) {
		this.drugPurchases = drugPurchases;
	}

	public DrugPurchase addDrugPurchas(DrugPurchase drugPurchas) {
		getDrugPurchases().add(drugPurchas);
		drugPurchas.setEmp(this);

		return drugPurchas;
	}

	public DrugPurchase removeDrugPurchas(DrugPurchase drugPurchas) {
		getDrugPurchases().remove(drugPurchas);
		drugPurchas.setEmp(null);

		return drugPurchas;
	}

	public List<DrugTuihuo> getDrugTuihuos() {
		return this.drugTuihuos;
	}

	public void setDrugTuihuos(List<DrugTuihuo> drugTuihuos) {
		this.drugTuihuos = drugTuihuos;
	}

	public DrugTuihuo addDrugTuihuo(DrugTuihuo drugTuihuo) {
		getDrugTuihuos().add(drugTuihuo);
		drugTuihuo.setEmp(this);

		return drugTuihuo;
	}

	public DrugTuihuo removeDrugTuihuo(DrugTuihuo drugTuihuo) {
		getDrugTuihuos().remove(drugTuihuo);
		drugTuihuo.setEmp(null);

		return drugTuihuo;
	}

	public List<DrugYaofang> getDrugYaofangs() {
		return this.drugYaofangs;
	}

	public void setDrugYaofangs(List<DrugYaofang> drugYaofangs) {
		this.drugYaofangs = drugYaofangs;
	}

	public DrugYaofang addDrugYaofang(DrugYaofang drugYaofang) {
		getDrugYaofangs().add(drugYaofang);
		drugYaofang.setEmp(this);

		return drugYaofang;
	}

	public DrugYaofang removeDrugYaofang(DrugYaofang drugYaofang) {
		getDrugYaofangs().remove(drugYaofang);
		drugYaofang.setEmp(null);

		return drugYaofang;
	}

	public Dclass getDclass() {
		return this.dclass;
	}

	public void setDclass(Dclass dclass) {
		this.dclass = dclass;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Zhiwu getZhiwu() {
		return this.zhiwu;
	}

	public void setZhiwu(Zhiwu zhiwu) {
		this.zhiwu = zhiwu;
	}

	public List<EmpMessage> getEmpMessages() {
		return this.empMessages;
	}

	public void setEmpMessages(List<EmpMessage> empMessages) {
		this.empMessages = empMessages;
	}

	public EmpMessage addEmpMessage(EmpMessage empMessage) {
		getEmpMessages().add(empMessage);
		empMessage.setEmp(this);

		return empMessage;
	}

	public EmpMessage removeEmpMessage(EmpMessage empMessage) {
		getEmpMessages().remove(empMessage);
		empMessage.setEmp(null);

		return empMessage;
	}

	public List<FayaoJizhang> getFayaoJizhangs() {
		return this.fayaoJizhangs;
	}

	public void setFayaoJizhangs(List<FayaoJizhang> fayaoJizhangs) {
		this.fayaoJizhangs = fayaoJizhangs;
	}

	public FayaoJizhang addFayaoJizhang(FayaoJizhang fayaoJizhang) {
		getFayaoJizhangs().add(fayaoJizhang);
		fayaoJizhang.setEmp(this);

		return fayaoJizhang;
	}

	public FayaoJizhang removeFayaoJizhang(FayaoJizhang fayaoJizhang) {
		getFayaoJizhangs().remove(fayaoJizhang);
		fayaoJizhang.setEmp(null);

		return fayaoJizhang;
	}

	public List<FinanceSumup> getFinanceSumups() {
		return this.financeSumups;
	}

	public void setFinanceSumups(List<FinanceSumup> financeSumups) {
		this.financeSumups = financeSumups;
	}

	public FinanceSumup addFinanceSumup(FinanceSumup financeSumup) {
		getFinanceSumups().add(financeSumup);
		financeSumup.setEmp(this);

		return financeSumup;
	}

	public FinanceSumup removeFinanceSumup(FinanceSumup financeSumup) {
		getFinanceSumups().remove(financeSumup);
		financeSumup.setEmp(null);

		return financeSumup;
	}

	public List<Financial> getFinancials() {
		return this.financials;
	}

	public void setFinancials(List<Financial> financials) {
		this.financials = financials;
	}

	public Financial addFinancial(Financial financial) {
		getFinancials().add(financial);
		financial.setEmp(this);

		return financial;
	}

	public Financial removeFinancial(Financial financial) {
		getFinancials().remove(financial);
		financial.setEmp(null);

		return financial;
	}

	public List<HospitalRegistration> getHospitalRegistrations() {
		return this.hospitalRegistrations;
	}

	public void setHospitalRegistrations(List<HospitalRegistration> hospitalRegistrations) {
		this.hospitalRegistrations = hospitalRegistrations;
	}

	public HospitalRegistration addHospitalRegistration(HospitalRegistration hospitalRegistration) {
		getHospitalRegistrations().add(hospitalRegistration);
		hospitalRegistration.setEmp(this);

		return hospitalRegistration;
	}

	public HospitalRegistration removeHospitalRegistration(HospitalRegistration hospitalRegistration) {
		getHospitalRegistrations().remove(hospitalRegistration);
		hospitalRegistration.setEmp(null);

		return hospitalRegistration;
	}

	public List<Instrument> getInstruments() {
		return this.instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}

	public Instrument addInstrument(Instrument instrument) {
		getInstruments().add(instrument);
		instrument.setEmp(this);

		return instrument;
	}

	public Instrument removeInstrument(Instrument instrument) {
		getInstruments().remove(instrument);
		instrument.setEmp(null);

		return instrument;
	}

	public List<InstrumentRk> getInstrumentRks() {
		return this.instrumentRks;
	}

	public void setInstrumentRks(List<InstrumentRk> instrumentRks) {
		this.instrumentRks = instrumentRks;
	}

	public InstrumentRk addInstrumentRk(InstrumentRk instrumentRk) {
		getInstrumentRks().add(instrumentRk);
		instrumentRk.setEmp(this);

		return instrumentRk;
	}

	public InstrumentRk removeInstrumentRk(InstrumentRk instrumentRk) {
		getInstrumentRks().remove(instrumentRk);
		instrumentRk.setEmp(null);

		return instrumentRk;
	}

	public List<Jianyan> getJianyans() {
		return this.jianyans;
	}

	public void setJianyans(List<Jianyan> jianyans) {
		this.jianyans = jianyans;
	}

	public Jianyan addJianyan(Jianyan jianyan) {
		getJianyans().add(jianyan);
		jianyan.setEmp(this);

		return jianyan;
	}

	public Jianyan removeJianyan(Jianyan jianyan) {
		getJianyans().remove(jianyan);
		jianyan.setEmp(null);

		return jianyan;
	}

	public List<JianyanMess> getJianyanMesses() {
		return this.jianyanMesses;
	}

	public void setJianyanMesses(List<JianyanMess> jianyanMesses) {
		this.jianyanMesses = jianyanMesses;
	}

	public JianyanMess addJianyanMess(JianyanMess jianyanMess) {
		getJianyanMesses().add(jianyanMess);
		jianyanMess.setEmp(this);

		return jianyanMess;
	}

	public JianyanMess removeJianyanMess(JianyanMess jianyanMess) {
		getJianyanMesses().remove(jianyanMess);
		jianyanMess.setEmp(null);

		return jianyanMess;
	}

	public List<LoginLogger> getLoginLoggers() {
		return this.loginLoggers;
	}

	public void setLoginLoggers(List<LoginLogger> loginLoggers) {
		this.loginLoggers = loginLoggers;
	}

	public LoginLogger addLoginLogger(LoginLogger loginLogger) {
		getLoginLoggers().add(loginLogger);
		loginLogger.setEmp(this);

		return loginLogger;
	}

	public LoginLogger removeLoginLogger(LoginLogger loginLogger) {
		getLoginLoggers().remove(loginLogger);
		loginLogger.setEmp(null);

		return loginLogger;
	}

	public List<OutpaitentRegist> getOutpaitentRegists() {
		return this.outpaitentRegists;
	}

	public void setOutpaitentRegists(List<OutpaitentRegist> outpaitentRegists) {
		this.outpaitentRegists = outpaitentRegists;
	}

	public OutpaitentRegist addOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		getOutpaitentRegists().add(outpaitentRegist);
		outpaitentRegist.setEmp(this);

		return outpaitentRegist;
	}

	public OutpaitentRegist removeOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		getOutpaitentRegists().remove(outpaitentRegist);
		outpaitentRegist.setEmp(null);

		return outpaitentRegist;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setEmp(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setEmp(null);

		return prescription;
	}

	public List<PrescriptionType> getPrescriptionTypes() {
		return this.prescriptionTypes;
	}

	public void setPrescriptionTypes(List<PrescriptionType> prescriptionTypes) {
		this.prescriptionTypes = prescriptionTypes;
	}

	public PrescriptionType addPrescriptionType(PrescriptionType prescriptionType) {
		getPrescriptionTypes().add(prescriptionType);
		prescriptionType.setEmp(this);

		return prescriptionType;
	}

	public PrescriptionType removePrescriptionType(PrescriptionType prescriptionType) {
		getPrescriptionTypes().remove(prescriptionType);
		prescriptionType.setEmp(null);

		return prescriptionType;
	}

	public List<QianDao> getQianDaos() {
		return this.qianDaos;
	}

	public void setQianDaos(List<QianDao> qianDaos) {
		this.qianDaos = qianDaos;
	}

	public QianDao addQianDao(QianDao qianDao) {
		getQianDaos().add(qianDao);
		qianDao.setEmp(this);

		return qianDao;
	}

	public QianDao removeQianDao(QianDao qianDao) {
		getQianDaos().remove(qianDao);
		qianDao.setEmp(null);

		return qianDao;
	}

	public List<QxThelibrary> getQxThelibraries() {
		return this.qxThelibraries;
	}

	public void setQxThelibraries(List<QxThelibrary> qxThelibraries) {
		this.qxThelibraries = qxThelibraries;
	}

	public QxThelibrary addQxThelibrary(QxThelibrary qxThelibrary) {
		getQxThelibraries().add(qxThelibrary);
		qxThelibrary.setEmp(this);

		return qxThelibrary;
	}

	public QxThelibrary removeQxThelibrary(QxThelibrary qxThelibrary) {
		getQxThelibraries().remove(qxThelibrary);
		qxThelibrary.setEmp(null);

		return qxThelibrary;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<RushShouqu> getRushShouqus() {
		return this.rushShouqus;
	}

	public void setRushShouqus(List<RushShouqu> rushShouqus) {
		this.rushShouqus = rushShouqus;
	}

	public RushShouqu addRushShouqus(RushShouqu rushShouqus) {
		getRushShouqus().add(rushShouqus);
		rushShouqus.setEmp(this);

		return rushShouqus;
	}

	public RushShouqu removeRushShouqus(RushShouqu rushShouqus) {
		getRushShouqus().remove(rushShouqus);
		rushShouqus.setEmp(null);

		return rushShouqus;
	}

	public List<Shoushu> getShoushus() {
		return this.shoushus;
	}

	public void setShoushus(List<Shoushu> shoushus) {
		this.shoushus = shoushus;
	}

	public Shoushu addShoushus(Shoushu shoushus) {
		getShoushus().add(shoushus);
		shoushus.setEmp(this);

		return shoushus;
	}

	public Shoushu removeShoushus(Shoushu shoushus) {
		getShoushus().remove(shoushus);
		shoushus.setEmp(null);

		return shoushus;
	}

	public List<ShoushuMess> getShoushuMesses() {
		return this.shoushuMesses;
	}

	public void setShoushuMesses(List<ShoushuMess> shoushuMesses) {
		this.shoushuMesses = shoushuMesses;
	}

	public ShoushuMess addShoushuMess(ShoushuMess shoushuMess) {
		getShoushuMesses().add(shoushuMess);
		shoushuMess.setEmp(this);

		return shoushuMess;
	}

	public ShoushuMess removeShoushuMess(ShoushuMess shoushuMess) {
		getShoushuMesses().remove(shoushuMess);
		shoushuMess.setEmp(null);

		return shoushuMess;
	}

	public List<SupplierJiesuan> getSupplierJiesuans() {
		return this.supplierJiesuans;
	}

	public void setSupplierJiesuans(List<SupplierJiesuan> supplierJiesuans) {
		this.supplierJiesuans = supplierJiesuans;
	}

	public SupplierJiesuan addSupplierJiesuan(SupplierJiesuan supplierJiesuan) {
		getSupplierJiesuans().add(supplierJiesuan);
		supplierJiesuan.setEmp(this);

		return supplierJiesuan;
	}

	public SupplierJiesuan removeSupplierJiesuan(SupplierJiesuan supplierJiesuan) {
		getSupplierJiesuans().remove(supplierJiesuan);
		supplierJiesuan.setEmp(null);

		return supplierJiesuan;
	}

	public List<YajinTuifei> getYajinTuifeis() {
		return this.yajinTuifeis;
	}

	public void setYajinTuifeis(List<YajinTuifei> yajinTuifeis) {
		this.yajinTuifeis = yajinTuifeis;
	}

	public YajinTuifei addYajinTuifei(YajinTuifei yajinTuifei) {
		getYajinTuifeis().add(yajinTuifei);
		yajinTuifei.setEmp(this);

		return yajinTuifei;
	}

	public YajinTuifei removeYajinTuifei(YajinTuifei yajinTuifei) {
		getYajinTuifeis().remove(yajinTuifei);
		yajinTuifei.setEmp(null);

		return yajinTuifei;
	}

	public List<YaofangRuku> getYaofangRukus1() {
		return this.yaofangRukus1;
	}

	public void setYaofangRukus1(List<YaofangRuku> yaofangRukus1) {
		this.yaofangRukus1 = yaofangRukus1;
	}

	public YaofangRuku addYaofangRukus1(YaofangRuku yaofangRukus1) {
		getYaofangRukus1().add(yaofangRukus1);
		yaofangRukus1.setEmp1(this);

		return yaofangRukus1;
	}

	public YaofangRuku removeYaofangRukus1(YaofangRuku yaofangRukus1) {
		getYaofangRukus1().remove(yaofangRukus1);
		yaofangRukus1.setEmp1(null);

		return yaofangRukus1;
	}

	public List<YaofangRuku> getYaofangRukus2() {
		return this.yaofangRukus2;
	}

	public void setYaofangRukus2(List<YaofangRuku> yaofangRukus2) {
		this.yaofangRukus2 = yaofangRukus2;
	}

	public YaofangRuku addYaofangRukus2(YaofangRuku yaofangRukus2) {
		getYaofangRukus2().add(yaofangRukus2);
		yaofangRukus2.setEmp2(this);

		return yaofangRukus2;
	}

	public YaofangRuku removeYaofangRukus2(YaofangRuku yaofangRukus2) {
		getYaofangRukus2().remove(yaofangRukus2);
		yaofangRukus2.setEmp2(null);

		return yaofangRukus2;
	}

	public List<ZhiliaoJizhang> getZhiliaoJizhangs() {
		return this.zhiliaoJizhangs;
	}

	public void setZhiliaoJizhangs(List<ZhiliaoJizhang> zhiliaoJizhangs) {
		this.zhiliaoJizhangs = zhiliaoJizhangs;
	}

	public ZhiliaoJizhang addZhiliaoJizhang(ZhiliaoJizhang zhiliaoJizhang) {
		getZhiliaoJizhangs().add(zhiliaoJizhang);
		zhiliaoJizhang.setEmp(this);

		return zhiliaoJizhang;
	}

	public ZhiliaoJizhang removeZhiliaoJizhang(ZhiliaoJizhang zhiliaoJizhang) {
		getZhiliaoJizhangs().remove(zhiliaoJizhang);
		zhiliaoJizhang.setEmp(null);

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
		zhuyuanFayao.setEmp(this);

		return zhuyuanFayao;
	}

	public ZhuyuanFayao removeZhuyuanFayao(ZhuyuanFayao zhuyuanFayao) {
		getZhuyuanFayaos().remove(zhuyuanFayao);
		zhuyuanFayao.setEmp(null);

		return zhuyuanFayao;
	}

}