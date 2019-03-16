package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PRESCRIPTION database table.
 * 
 */
@Entity
@NamedQuery(name="Prescription.findAll", query="SELECT p FROM Prescription p")
public class Prescription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRESCRIPTION_ID")
	private String prescriptionId;

	@Temporal(TemporalType.DATE)
	@Column(name="PRESCRIPTION_DATE")
	private Date prescriptionDate;

	@Column(name="PRESCRIPTION_TYPE")
	private String prescriptionType;

	@Column(name="PRESCRIPTION_YZZX")
	private String prescriptionYzzx;

	@Column(name="PRESCRIPTION_ZT")
	private String prescriptionZt;

	//bi-directional many-to-one association to ChargeManagement
	@OneToMany(mappedBy="prescription")
	private List<ChargeManagement> chargeManagements;

	//bi-directional many-to-one association to DrugYaofang
	@OneToMany(mappedBy="prescription")
	private List<DrugYaofang> drugYaofangs;

	//bi-directional many-to-one association to FayaoJizhangXq
	@OneToMany(mappedBy="prescription")
	private List<FayaoJizhangXq> fayaoJizhangXqs;

	//bi-directional many-to-one association to PharmaceReturn
	@OneToMany(mappedBy="prescription")
	private List<PharmaceReturn> pharmaceReturns;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HospitalRegistration
	@ManyToOne
	@JoinColumn(name="HOSPITAL_REGISTRATION_ID")
	private HospitalRegistration hospitalRegistration;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	//bi-directional many-to-one association to Prescription
	@ManyToOne
	@JoinColumn(name="PRE_PRESCRIPTION_ID")
	private Prescription prescription;

	//bi-directional many-to-one association to Prescription
	@OneToMany(mappedBy="prescription")
	private List<Prescription> prescriptions;

	//bi-directional many-to-one association to PrescriptionType
	@OneToMany(mappedBy="prescription")
	private List<PrescriptionType> prescriptionTypes;

	//bi-directional many-to-one association to ZhiliaoJizhangXq
	@OneToMany(mappedBy="prescription")
	private List<ZhiliaoJizhangXq> zhiliaoJizhangXqs;

	//bi-directional many-to-one association to ZhuyuanFayao
	@OneToMany(mappedBy="prescription")
	private List<ZhuyuanFayao> zhuyuanFayaos;

	public Prescription() {
	}

	public String getPrescriptionId() {
		return this.prescriptionId;
	}

	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public Date getPrescriptionDate() {
		return this.prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public String getPrescriptionType() {
		return this.prescriptionType;
	}

	public void setPrescriptionType(String prescriptionType) {
		this.prescriptionType = prescriptionType;
	}

	public String getPrescriptionYzzx() {
		return this.prescriptionYzzx;
	}

	public void setPrescriptionYzzx(String prescriptionYzzx) {
		this.prescriptionYzzx = prescriptionYzzx;
	}

	public String getPrescriptionZt() {
		return this.prescriptionZt;
	}

	public void setPrescriptionZt(String prescriptionZt) {
		this.prescriptionZt = prescriptionZt;
	}

	public List<ChargeManagement> getChargeManagements() {
		return this.chargeManagements;
	}

	public void setChargeManagements(List<ChargeManagement> chargeManagements) {
		this.chargeManagements = chargeManagements;
	}

	public ChargeManagement addChargeManagement(ChargeManagement chargeManagement) {
		getChargeManagements().add(chargeManagement);
		chargeManagement.setPrescription(this);

		return chargeManagement;
	}

	public ChargeManagement removeChargeManagement(ChargeManagement chargeManagement) {
		getChargeManagements().remove(chargeManagement);
		chargeManagement.setPrescription(null);

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
		drugYaofang.setPrescription(this);

		return drugYaofang;
	}

	public DrugYaofang removeDrugYaofang(DrugYaofang drugYaofang) {
		getDrugYaofangs().remove(drugYaofang);
		drugYaofang.setPrescription(null);

		return drugYaofang;
	}

	public List<FayaoJizhangXq> getFayaoJizhangXqs() {
		return this.fayaoJizhangXqs;
	}

	public void setFayaoJizhangXqs(List<FayaoJizhangXq> fayaoJizhangXqs) {
		this.fayaoJizhangXqs = fayaoJizhangXqs;
	}

	public FayaoJizhangXq addFayaoJizhangXq(FayaoJizhangXq fayaoJizhangXq) {
		getFayaoJizhangXqs().add(fayaoJizhangXq);
		fayaoJizhangXq.setPrescription(this);

		return fayaoJizhangXq;
	}

	public FayaoJizhangXq removeFayaoJizhangXq(FayaoJizhangXq fayaoJizhangXq) {
		getFayaoJizhangXqs().remove(fayaoJizhangXq);
		fayaoJizhangXq.setPrescription(null);

		return fayaoJizhangXq;
	}

	public List<PharmaceReturn> getPharmaceReturns() {
		return this.pharmaceReturns;
	}

	public void setPharmaceReturns(List<PharmaceReturn> pharmaceReturns) {
		this.pharmaceReturns = pharmaceReturns;
	}

	public PharmaceReturn addPharmaceReturn(PharmaceReturn pharmaceReturn) {
		getPharmaceReturns().add(pharmaceReturn);
		pharmaceReturn.setPrescription(this);

		return pharmaceReturn;
	}

	public PharmaceReturn removePharmaceReturn(PharmaceReturn pharmaceReturn) {
		getPharmaceReturns().remove(pharmaceReturn);
		pharmaceReturn.setPrescription(null);

		return pharmaceReturn;
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

	public OutpaitentRegist getOutpaitentRegist() {
		return this.outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public Prescription getPrescription() {
		return this.prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}

	public List<Prescription> getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Prescription addPrescription(Prescription prescription) {
		getPrescriptions().add(prescription);
		prescription.setPrescription(this);

		return prescription;
	}

	public Prescription removePrescription(Prescription prescription) {
		getPrescriptions().remove(prescription);
		prescription.setPrescription(null);

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
		prescriptionType.setPrescription(this);

		return prescriptionType;
	}

	public PrescriptionType removePrescriptionType(PrescriptionType prescriptionType) {
		getPrescriptionTypes().remove(prescriptionType);
		prescriptionType.setPrescription(null);

		return prescriptionType;
	}

	public List<ZhiliaoJizhangXq> getZhiliaoJizhangXqs() {
		return this.zhiliaoJizhangXqs;
	}

	public void setZhiliaoJizhangXqs(List<ZhiliaoJizhangXq> zhiliaoJizhangXqs) {
		this.zhiliaoJizhangXqs = zhiliaoJizhangXqs;
	}

	public ZhiliaoJizhangXq addZhiliaoJizhangXq(ZhiliaoJizhangXq zhiliaoJizhangXq) {
		getZhiliaoJizhangXqs().add(zhiliaoJizhangXq);
		zhiliaoJizhangXq.setPrescription(this);

		return zhiliaoJizhangXq;
	}

	public ZhiliaoJizhangXq removeZhiliaoJizhangXq(ZhiliaoJizhangXq zhiliaoJizhangXq) {
		getZhiliaoJizhangXqs().remove(zhiliaoJizhangXq);
		zhiliaoJizhangXq.setPrescription(null);

		return zhiliaoJizhangXq;
	}

	public List<ZhuyuanFayao> getZhuyuanFayaos() {
		return this.zhuyuanFayaos;
	}

	public void setZhuyuanFayaos(List<ZhuyuanFayao> zhuyuanFayaos) {
		this.zhuyuanFayaos = zhuyuanFayaos;
	}

	public ZhuyuanFayao addZhuyuanFayao(ZhuyuanFayao zhuyuanFayao) {
		getZhuyuanFayaos().add(zhuyuanFayao);
		zhuyuanFayao.setPrescription(this);

		return zhuyuanFayao;
	}

	public ZhuyuanFayao removeZhuyuanFayao(ZhuyuanFayao zhuyuanFayao) {
		getZhuyuanFayaos().remove(zhuyuanFayao);
		zhuyuanFayao.setPrescription(null);

		return zhuyuanFayao;
	}

}