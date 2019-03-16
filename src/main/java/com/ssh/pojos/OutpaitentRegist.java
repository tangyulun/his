package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the OUTPAITENT_REGIST database table.
 * 
 */
@Entity
@Table(name="OUTPAITENT_REGIST")
@NamedQuery(name="OutpaitentRegist.findAll", query="SELECT o FROM OutpaitentRegist o")
public class OutpaitentRegist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="OUTPAITENT_REGIST_ID")
	private String outpaitentRegistId;

	@Column(name="OUTPAITENT_REGIST_BINGLIHAO")
	private String outpaitentRegistBinglihao;

	@Temporal(TemporalType.DATE)
	@Column(name="OUTPAITENT_REGIST_GUAHAODATE")
	private Date outpaitentRegistGuahaodate;

	@Column(name="OUTPAITENT_REGIST_GUAHAOTIME")
	private String outpaitentRegistGuahaotime;

	@Column(name="OUTPAITENT_REGIST_LIUSHUIHAO")
	private BigDecimal outpaitentRegistLiushuihao;

	@Column(name="OUTPAITENT_REGIST_TYPE")
	private String outpaitentRegistType;

	@Column(name="OUTPAITENT_REGIST_ZHUANGTAI")
	private String outpaitentRegistZhuangtai;

	//bi-directional many-to-one association to ChargeManagement
	@OneToMany(mappedBy="outpaitentRegist")
	private List<ChargeManagement> chargeManagements;

	//bi-directional many-to-one association to DrugYaofang
	@OneToMany(mappedBy="outpaitentRegist")
	private List<DrugYaofang> drugYaofangs;

	//bi-directional many-to-one association to FinancialHistory
	@OneToMany(mappedBy="outpaitentRegist")
	private List<FinancialHistory> financialHistories;

	//bi-directional many-to-one association to HospitaNotify
	@OneToMany(mappedBy="outpaitentRegist")
	private List<HospitaNotify> hospitaNotifies;

	//bi-directional many-to-one association to JianyanMess
	@OneToMany(mappedBy="outpaitentRegist")
	private List<JianyanMess> jianyanMesses;

	//bi-directional many-to-one association to Dclass
	@ManyToOne
	@JoinColumn(name="DCLASS_ID")
	private Dclass dclass;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to MedicalCard
	@ManyToOne
	@JoinColumn(name="MEDICAL_CARD_CARD_ID")
	private MedicalCard medicalCard;

	//bi-directional many-to-one association to PharmaceReturn
	@OneToMany(mappedBy="outpaitentRegist")
	private List<PharmaceReturn> pharmaceReturns;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="outpaitentRegist")
	private List<Prescription> prescriptions;

	//bi-directional many-to-one association to PrescriptionType
	@OneToMany(mappedBy="outpaitentRegist")
	private List<PrescriptionType> prescriptionTypes;

	public OutpaitentRegist() {
	}

	public String getOutpaitentRegistId() {
		return this.outpaitentRegistId;
	}

	public void setOutpaitentRegistId(String outpaitentRegistId) {
		this.outpaitentRegistId = outpaitentRegistId;
	}

	public String getOutpaitentRegistBinglihao() {
		return this.outpaitentRegistBinglihao;
	}

	public void setOutpaitentRegistBinglihao(String outpaitentRegistBinglihao) {
		this.outpaitentRegistBinglihao = outpaitentRegistBinglihao;
	}

	public Date getOutpaitentRegistGuahaodate() {
		return this.outpaitentRegistGuahaodate;
	}

	public void setOutpaitentRegistGuahaodate(Date outpaitentRegistGuahaodate) {
		this.outpaitentRegistGuahaodate = outpaitentRegistGuahaodate;
	}

	public String getOutpaitentRegistGuahaotime() {
		return this.outpaitentRegistGuahaotime;
	}

	public void setOutpaitentRegistGuahaotime(String outpaitentRegistGuahaotime) {
		this.outpaitentRegistGuahaotime = outpaitentRegistGuahaotime;
	}

	public BigDecimal getOutpaitentRegistLiushuihao() {
		return this.outpaitentRegistLiushuihao;
	}

	public void setOutpaitentRegistLiushuihao(BigDecimal outpaitentRegistLiushuihao) {
		this.outpaitentRegistLiushuihao = outpaitentRegistLiushuihao;
	}

	public String getOutpaitentRegistType() {
		return this.outpaitentRegistType;
	}

	public void setOutpaitentRegistType(String outpaitentRegistType) {
		this.outpaitentRegistType = outpaitentRegistType;
	}

	public String getOutpaitentRegistZhuangtai() {
		return this.outpaitentRegistZhuangtai;
	}

	public void setOutpaitentRegistZhuangtai(String outpaitentRegistZhuangtai) {
		this.outpaitentRegistZhuangtai = outpaitentRegistZhuangtai;
	}

	public List<ChargeManagement> getChargeManagements() {
		return this.chargeManagements;
	}

	public void setChargeManagements(List<ChargeManagement> chargeManagements) {
		this.chargeManagements = chargeManagements;
	}

	public ChargeManagement addChargeManagement(ChargeManagement chargeManagement) {
		getChargeManagements().add(chargeManagement);
		chargeManagement.setOutpaitentRegist(this);

		return chargeManagement;
	}

	public ChargeManagement removeChargeManagement(ChargeManagement chargeManagement) {
		getChargeManagements().remove(chargeManagement);
		chargeManagement.setOutpaitentRegist(null);

		return chargeManagement;
	}

	public List<DrugYaofang> getDrugYaofangs() {
		return this.drugYaofangs;
	}

	public void setDrugYaofangs(List<DrugYaofang> drugYaofangs) {
		this.drugYaofangs = drugYaofangs;
	}

	public DrugYaofang addDrugYaofang(DrugYaofang drugYaofang) {
		getDrugYaofangs().add(drugYaofang);
		drugYaofang.setOutpaitentRegist(this);

		return drugYaofang;
	}

	public DrugYaofang removeDrugYaofang(DrugYaofang drugYaofang) {
		getDrugYaofangs().remove(drugYaofang);
		drugYaofang.setOutpaitentRegist(null);

		return drugYaofang;
	}

	public List<FinancialHistory> getFinancialHistories() {
		return this.financialHistories;
	}

	public void setFinancialHistories(List<FinancialHistory> financialHistories) {
		this.financialHistories = financialHistories;
	}

	public FinancialHistory addFinancialHistory(FinancialHistory financialHistory) {
		getFinancialHistories().add(financialHistory);
		financialHistory.setOutpaitentRegist(this);

		return financialHistory;
	}

	public FinancialHistory removeFinancialHistory(FinancialHistory financialHistory) {
		getFinancialHistories().remove(financialHistory);
		financialHistory.setOutpaitentRegist(null);

		return financialHistory;
	}

	public List<HospitaNotify> getHospitaNotifies() {
		return this.hospitaNotifies;
	}

	public void setHospitaNotifies(List<HospitaNotify> hospitaNotifies) {
		this.hospitaNotifies = hospitaNotifies;
	}

	public HospitaNotify addHospitaNotify(HospitaNotify hospitaNotify) {
		getHospitaNotifies().add(hospitaNotify);
		hospitaNotify.setOutpaitentRegist(this);

		return hospitaNotify;
	}

	public HospitaNotify removeHospitaNotify(HospitaNotify hospitaNotify) {
		getHospitaNotifies().remove(hospitaNotify);
		hospitaNotify.setOutpaitentRegist(null);

		return hospitaNotify;
	}

	public List<JianyanMess> getJianyanMesses() {
		return this.jianyanMesses;
	}

	public void setJianyanMesses(List<JianyanMess> jianyanMesses) {
		this.jianyanMesses = jianyanMesses;
	}

	public JianyanMess addJianyanMess(JianyanMess jianyanMess) {
		getJianyanMesses().add(jianyanMess);
		jianyanMess.setOutpaitentRegist(this);

		return jianyanMess;
	}

	public JianyanMess removeJianyanMess(JianyanMess jianyanMess) {
		getJianyanMesses().remove(jianyanMess);
		jianyanMess.setOutpaitentRegist(null);

		return jianyanMess;
	}

	public Dclass getDclass() {
		return this.dclass;
	}

	public void setDclass(Dclass dclass) {
		this.dclass = dclass;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public MedicalCard getMedicalCard() {
		return this.medicalCard;
	}

	public void setMedicalCard(MedicalCard medicalCard) {
		this.medicalCard = medicalCard;
	}

	public List<PharmaceReturn> getPharmaceReturns() {
		return this.pharmaceReturns;
	}

	public void setPharmaceReturns(List<PharmaceReturn> pharmaceReturns) {
		this.pharmaceReturns = pharmaceReturns;
	}

	public PharmaceReturn addPharmaceReturn(PharmaceReturn pharmaceReturn) {
		getPharmaceReturns().add(pharmaceReturn);
		pharmaceReturn.setOutpaitentRegist(this);

		return pharmaceReturn;
	}

	public PharmaceReturn removePharmaceReturn(PharmaceReturn pharmaceReturn) {
		getPharmaceReturns().remove(pharmaceReturn);
		pharmaceReturn.setOutpaitentRegist(null);

		return pharmaceReturn;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setOutpaitentRegist(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setOutpaitentRegist(null);

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
		prescriptionType.setOutpaitentRegist(this);

		return prescriptionType;
	}

	public PrescriptionType removePrescriptionType(PrescriptionType prescriptionType) {
		getPrescriptionTypes().remove(prescriptionType);
		prescriptionType.setOutpaitentRegist(null);

		return prescriptionType;
	}

}