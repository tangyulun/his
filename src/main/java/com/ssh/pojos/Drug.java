package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the DRUG database table.
 * 
 */
@Entity
@NamedQuery(name="Drug.findAll", query="SELECT d FROM Drug d")
public class Drug implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DRUG_ID")
	private String drugId;

	@Column(name="DRUG_BNAME")
	private String drugBname;

	@Column(name="DRUG_BZ")
	private String drugBz;

	@Column(name="DRUG_BZDATE")
	private String drugBzdate;

	@Column(name="DRUG_CF")
	private String drugCf;

	@Column(name="DRUG_GG")
	private String drugGg;

	@Column(name="DRUG_JX")
	private String drugJx;

	@Column(name="DRUG_LSPRICE")
	private BigDecimal drugLsprice;

	@Column(name="DRUG_LX")
	private String drugLx;

	@Column(name="DRUG_NAME")
	private String drugName;

	@Column(name="DRUG_PFPRICE")
	private BigDecimal drugPfprice;

	@Column(name="DRUG_SCCJ")
	private String drugSccj;

	@Column(name="DRUG_SHR")
	private String drugShr;

	@Column(name="DRUG_YF")
	private String drugYf;

	@Column(name="DRUG_ZT")
	private String drugZt;

	//bi-directional many-to-one association to DrugType
	@ManyToOne
	@JoinColumn(name="DRUG_TYPE_ID")
	private DrugType drugType;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="UNITS_ID")
	private Unit unit;

	//bi-directional many-to-one association to YaokuKucun
	@ManyToOne
	@JoinColumn(name="YAOKU_KUCUN_ID")
	private YaokuKucun yaokuKucun;

	//bi-directional many-to-one association to DrugAcceptanceXq
	@OneToMany(mappedBy="drug")
	private List<DrugAcceptanceXq> drugAcceptanceXqs;

	//bi-directional many-to-one association to DrugDeliveryDetali
	@OneToMany(mappedBy="drug")
	private List<DrugDeliveryDetali> drugDeliveryDetalis;

	//bi-directional many-to-one association to DrugInventoryDetali
	@OneToMany(mappedBy="drug")
	private List<DrugInventoryDetali> drugInventoryDetalis;

	//bi-directional many-to-one association to DrugLogin
	@OneToMany(mappedBy="drug")
	private List<DrugLogin> drugLogins;

	//bi-directional many-to-one association to DrugPurchaseDetail
	@OneToMany(mappedBy="drug")
	private List<DrugPurchaseDetail> drugPurchaseDetails;

	//bi-directional many-to-one association to DrugTuihuoXq
	@OneToMany(mappedBy="drug")
	private List<DrugTuihuoXq> drugTuihuoXqs;

	//bi-directional many-to-one association to DrugWarehouseXq
	@OneToMany(mappedBy="drug")
	private List<DrugWarehouseXq> drugWarehouseXqs;

	//bi-directional many-to-one association to DrugYaofangXq
	@OneToMany(mappedBy="drug")
	private List<DrugYaofangXq> drugYaofangXqs;

	//bi-directional many-to-one association to FayaoJizhangXq
	@OneToMany(mappedBy="drug")
	private List<FayaoJizhangXq> fayaoJizhangXqs;

	//bi-directional many-to-one association to PharmacyInventoryDetali
	@OneToMany(mappedBy="drug")
	private List<PharmacyInventoryDetali> pharmacyInventoryDetalis;

	//bi-directional many-to-one association to PharmacyRecipientsDetali
	@OneToMany(mappedBy="drug")
	private List<PharmacyRecipientsDetali> pharmacyRecipientsDetalis;

	//bi-directional many-to-one association to PharmacyReturnDetali
	@OneToMany(mappedBy="drug")
	private List<PharmacyReturnDetali> pharmacyReturnDetalis;

	//bi-directional many-to-one association to PharmacyWarehouseDetali
	@OneToMany(mappedBy="drug")
	private List<PharmacyWarehouseDetali> pharmacyWarehouseDetalis;

	//bi-directional many-to-one association to PrescriptionRecode
	@OneToMany(mappedBy="drug")
	private List<PrescriptionRecode> prescriptionRecodes;

	//bi-directional many-to-one association to ZhuyuanFayaoXq
	@OneToMany(mappedBy="drug")
	private List<ZhuyuanFayaoXq> zhuyuanFayaoXqs;

	public Drug() {
	}

	public String getDrugId() {
		return this.drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugBname() {
		return this.drugBname;
	}

	public void setDrugBname(String drugBname) {
		this.drugBname = drugBname;
	}

	public String getDrugBz() {
		return this.drugBz;
	}

	public void setDrugBz(String drugBz) {
		this.drugBz = drugBz;
	}

	public String getDrugBzdate() {
		return this.drugBzdate;
	}

	public void setDrugBzdate(String drugBzdate) {
		this.drugBzdate = drugBzdate;
	}

	public String getDrugCf() {
		return this.drugCf;
	}

	public void setDrugCf(String drugCf) {
		this.drugCf = drugCf;
	}

	public String getDrugGg() {
		return this.drugGg;
	}

	public void setDrugGg(String drugGg) {
		this.drugGg = drugGg;
	}

	public String getDrugJx() {
		return this.drugJx;
	}

	public void setDrugJx(String drugJx) {
		this.drugJx = drugJx;
	}

	public BigDecimal getDrugLsprice() {
		return this.drugLsprice;
	}

	public void setDrugLsprice(BigDecimal drugLsprice) {
		this.drugLsprice = drugLsprice;
	}

	public String getDrugLx() {
		return this.drugLx;
	}

	public void setDrugLx(String drugLx) {
		this.drugLx = drugLx;
	}

	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public BigDecimal getDrugPfprice() {
		return this.drugPfprice;
	}

	public void setDrugPfprice(BigDecimal drugPfprice) {
		this.drugPfprice = drugPfprice;
	}

	public String getDrugSccj() {
		return this.drugSccj;
	}

	public void setDrugSccj(String drugSccj) {
		this.drugSccj = drugSccj;
	}

	public String getDrugShr() {
		return this.drugShr;
	}

	public void setDrugShr(String drugShr) {
		this.drugShr = drugShr;
	}

	public String getDrugYf() {
		return this.drugYf;
	}

	public void setDrugYf(String drugYf) {
		this.drugYf = drugYf;
	}

	public String getDrugZt() {
		return this.drugZt;
	}

	public void setDrugZt(String drugZt) {
		this.drugZt = drugZt;
	}

	public DrugType getDrugType() {
		return this.drugType;
	}

	public void setDrugType(DrugType drugType) {
		this.drugType = drugType;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public YaokuKucun getYaokuKucun() {
		return this.yaokuKucun;
	}

	public void setYaokuKucun(YaokuKucun yaokuKucun) {
		this.yaokuKucun = yaokuKucun;
	}

	public List<DrugAcceptanceXq> getDrugAcceptanceXqs() {
		return this.drugAcceptanceXqs;
	}

	public void setDrugAcceptanceXqs(List<DrugAcceptanceXq> drugAcceptanceXqs) {
		this.drugAcceptanceXqs = drugAcceptanceXqs;
	}

	public DrugAcceptanceXq addDrugAcceptanceXq(DrugAcceptanceXq drugAcceptanceXq) {
		getDrugAcceptanceXqs().add(drugAcceptanceXq);
		drugAcceptanceXq.setDrug(this);

		return drugAcceptanceXq;
	}

	public DrugAcceptanceXq removeDrugAcceptanceXq(DrugAcceptanceXq drugAcceptanceXq) {
		getDrugAcceptanceXqs().remove(drugAcceptanceXq);
		drugAcceptanceXq.setDrug(null);

		return drugAcceptanceXq;
	}

	public List<DrugDeliveryDetali> getDrugDeliveryDetalis() {
		return this.drugDeliveryDetalis;
	}

	public void setDrugDeliveryDetalis(List<DrugDeliveryDetali> drugDeliveryDetalis) {
		this.drugDeliveryDetalis = drugDeliveryDetalis;
	}

	public DrugDeliveryDetali addDrugDeliveryDetali(DrugDeliveryDetali drugDeliveryDetali) {
		getDrugDeliveryDetalis().add(drugDeliveryDetali);
		drugDeliveryDetali.setDrug(this);

		return drugDeliveryDetali;
	}

	public DrugDeliveryDetali removeDrugDeliveryDetali(DrugDeliveryDetali drugDeliveryDetali) {
		getDrugDeliveryDetalis().remove(drugDeliveryDetali);
		drugDeliveryDetali.setDrug(null);

		return drugDeliveryDetali;
	}

	public List<DrugInventoryDetali> getDrugInventoryDetalis() {
		return this.drugInventoryDetalis;
	}

	public void setDrugInventoryDetalis(List<DrugInventoryDetali> drugInventoryDetalis) {
		this.drugInventoryDetalis = drugInventoryDetalis;
	}

	public DrugInventoryDetali addDrugInventoryDetali(DrugInventoryDetali drugInventoryDetali) {
		getDrugInventoryDetalis().add(drugInventoryDetali);
		drugInventoryDetali.setDrug(this);

		return drugInventoryDetali;
	}

	public DrugInventoryDetali removeDrugInventoryDetali(DrugInventoryDetali drugInventoryDetali) {
		getDrugInventoryDetalis().remove(drugInventoryDetali);
		drugInventoryDetali.setDrug(null);

		return drugInventoryDetali;
	}

	public List<DrugLogin> getDrugLogins() {
		return this.drugLogins;
	}

	public void setDrugLogins(List<DrugLogin> drugLogins) {
		this.drugLogins = drugLogins;
	}

	public DrugLogin addDrugLogin(DrugLogin drugLogin) {
		getDrugLogins().add(drugLogin);
		drugLogin.setDrug(this);

		return drugLogin;
	}

	public DrugLogin removeDrugLogin(DrugLogin drugLogin) {
		getDrugLogins().remove(drugLogin);
		drugLogin.setDrug(null);

		return drugLogin;
	}

	public List<DrugPurchaseDetail> getDrugPurchaseDetails() {
		return this.drugPurchaseDetails;
	}

	public void setDrugPurchaseDetails(List<DrugPurchaseDetail> drugPurchaseDetails) {
		this.drugPurchaseDetails = drugPurchaseDetails;
	}

	public DrugPurchaseDetail addDrugPurchaseDetail(DrugPurchaseDetail drugPurchaseDetail) {
		getDrugPurchaseDetails().add(drugPurchaseDetail);
		drugPurchaseDetail.setDrug(this);

		return drugPurchaseDetail;
	}

	public DrugPurchaseDetail removeDrugPurchaseDetail(DrugPurchaseDetail drugPurchaseDetail) {
		getDrugPurchaseDetails().remove(drugPurchaseDetail);
		drugPurchaseDetail.setDrug(null);

		return drugPurchaseDetail;
	}

	public List<DrugTuihuoXq> getDrugTuihuoXqs() {
		return this.drugTuihuoXqs;
	}

	public void setDrugTuihuoXqs(List<DrugTuihuoXq> drugTuihuoXqs) {
		this.drugTuihuoXqs = drugTuihuoXqs;
	}

	public DrugTuihuoXq addDrugTuihuoXq(DrugTuihuoXq drugTuihuoXq) {
		getDrugTuihuoXqs().add(drugTuihuoXq);
		drugTuihuoXq.setDrug(this);

		return drugTuihuoXq;
	}

	public DrugTuihuoXq removeDrugTuihuoXq(DrugTuihuoXq drugTuihuoXq) {
		getDrugTuihuoXqs().remove(drugTuihuoXq);
		drugTuihuoXq.setDrug(null);

		return drugTuihuoXq;
	}

	public List<DrugWarehouseXq> getDrugWarehouseXqs() {
		return this.drugWarehouseXqs;
	}

	public void setDrugWarehouseXqs(List<DrugWarehouseXq> drugWarehouseXqs) {
		this.drugWarehouseXqs = drugWarehouseXqs;
	}

	public DrugWarehouseXq addDrugWarehouseXq(DrugWarehouseXq drugWarehouseXq) {
		getDrugWarehouseXqs().add(drugWarehouseXq);
		drugWarehouseXq.setDrug(this);

		return drugWarehouseXq;
	}

	public DrugWarehouseXq removeDrugWarehouseXq(DrugWarehouseXq drugWarehouseXq) {
		getDrugWarehouseXqs().remove(drugWarehouseXq);
		drugWarehouseXq.setDrug(null);

		return drugWarehouseXq;
	}

	public List<DrugYaofangXq> getDrugYaofangXqs() {
		return this.drugYaofangXqs;
	}

	public void setDrugYaofangXqs(List<DrugYaofangXq> drugYaofangXqs) {
		this.drugYaofangXqs = drugYaofangXqs;
	}

	public DrugYaofangXq addDrugYaofangXq(DrugYaofangXq drugYaofangXq) {
		getDrugYaofangXqs().add(drugYaofangXq);
		drugYaofangXq.setDrug(this);

		return drugYaofangXq;
	}

	public DrugYaofangXq removeDrugYaofangXq(DrugYaofangXq drugYaofangXq) {
		getDrugYaofangXqs().remove(drugYaofangXq);
		drugYaofangXq.setDrug(null);

		return drugYaofangXq;
	}

	public List<FayaoJizhangXq> getFayaoJizhangXqs() {
		return this.fayaoJizhangXqs;
	}

	public void setFayaoJizhangXqs(List<FayaoJizhangXq> fayaoJizhangXqs) {
		this.fayaoJizhangXqs = fayaoJizhangXqs;
	}

	public FayaoJizhangXq addFayaoJizhangXq(FayaoJizhangXq fayaoJizhangXq) {
		getFayaoJizhangXqs().add(fayaoJizhangXq);
		fayaoJizhangXq.setDrug(this);

		return fayaoJizhangXq;
	}

	public FayaoJizhangXq removeFayaoJizhangXq(FayaoJizhangXq fayaoJizhangXq) {
		getFayaoJizhangXqs().remove(fayaoJizhangXq);
		fayaoJizhangXq.setDrug(null);

		return fayaoJizhangXq;
	}

	public List<PharmacyInventoryDetali> getPharmacyInventoryDetalis() {
		return this.pharmacyInventoryDetalis;
	}

	public void setPharmacyInventoryDetalis(List<PharmacyInventoryDetali> pharmacyInventoryDetalis) {
		this.pharmacyInventoryDetalis = pharmacyInventoryDetalis;
	}

	public PharmacyInventoryDetali addPharmacyInventoryDetali(PharmacyInventoryDetali pharmacyInventoryDetali) {
		getPharmacyInventoryDetalis().add(pharmacyInventoryDetali);
		pharmacyInventoryDetali.setDrug(this);

		return pharmacyInventoryDetali;
	}

	public PharmacyInventoryDetali removePharmacyInventoryDetali(PharmacyInventoryDetali pharmacyInventoryDetali) {
		getPharmacyInventoryDetalis().remove(pharmacyInventoryDetali);
		pharmacyInventoryDetali.setDrug(null);

		return pharmacyInventoryDetali;
	}

	public List<PharmacyRecipientsDetali> getPharmacyRecipientsDetalis() {
		return this.pharmacyRecipientsDetalis;
	}

	public void setPharmacyRecipientsDetalis(List<PharmacyRecipientsDetali> pharmacyRecipientsDetalis) {
		this.pharmacyRecipientsDetalis = pharmacyRecipientsDetalis;
	}

	public PharmacyRecipientsDetali addPharmacyRecipientsDetali(PharmacyRecipientsDetali pharmacyRecipientsDetali) {
		getPharmacyRecipientsDetalis().add(pharmacyRecipientsDetali);
		pharmacyRecipientsDetali.setDrug(this);

		return pharmacyRecipientsDetali;
	}

	public PharmacyRecipientsDetali removePharmacyRecipientsDetali(PharmacyRecipientsDetali pharmacyRecipientsDetali) {
		getPharmacyRecipientsDetalis().remove(pharmacyRecipientsDetali);
		pharmacyRecipientsDetali.setDrug(null);

		return pharmacyRecipientsDetali;
	}

	public List<PharmacyReturnDetali> getPharmacyReturnDetalis() {
		return this.pharmacyReturnDetalis;
	}

	public void setPharmacyReturnDetalis(List<PharmacyReturnDetali> pharmacyReturnDetalis) {
		this.pharmacyReturnDetalis = pharmacyReturnDetalis;
	}

	public PharmacyReturnDetali addPharmacyReturnDetali(PharmacyReturnDetali pharmacyReturnDetali) {
		getPharmacyReturnDetalis().add(pharmacyReturnDetali);
		pharmacyReturnDetali.setDrug(this);

		return pharmacyReturnDetali;
	}

	public PharmacyReturnDetali removePharmacyReturnDetali(PharmacyReturnDetali pharmacyReturnDetali) {
		getPharmacyReturnDetalis().remove(pharmacyReturnDetali);
		pharmacyReturnDetali.setDrug(null);

		return pharmacyReturnDetali;
	}

	public List<PharmacyWarehouseDetali> getPharmacyWarehouseDetalis() {
		return this.pharmacyWarehouseDetalis;
	}

	public void setPharmacyWarehouseDetalis(List<PharmacyWarehouseDetali> pharmacyWarehouseDetalis) {
		this.pharmacyWarehouseDetalis = pharmacyWarehouseDetalis;
	}

	public PharmacyWarehouseDetali addPharmacyWarehouseDetali(PharmacyWarehouseDetali pharmacyWarehouseDetali) {
		getPharmacyWarehouseDetalis().add(pharmacyWarehouseDetali);
		pharmacyWarehouseDetali.setDrug(this);

		return pharmacyWarehouseDetali;
	}

	public PharmacyWarehouseDetali removePharmacyWarehouseDetali(PharmacyWarehouseDetali pharmacyWarehouseDetali) {
		getPharmacyWarehouseDetalis().remove(pharmacyWarehouseDetali);
		pharmacyWarehouseDetali.setDrug(null);

		return pharmacyWarehouseDetali;
	}

	public List<PrescriptionRecode> getPrescriptionRecodes() {
		return this.prescriptionRecodes;
	}

	public void setPrescriptionRecodes(List<PrescriptionRecode> prescriptionRecodes) {
		this.prescriptionRecodes = prescriptionRecodes;
	}

	public PrescriptionRecode addPrescriptionRecode(PrescriptionRecode prescriptionRecode) {
		getPrescriptionRecodes().add(prescriptionRecode);
		prescriptionRecode.setDrug(this);

		return prescriptionRecode;
	}

	public PrescriptionRecode removePrescriptionRecode(PrescriptionRecode prescriptionRecode) {
		getPrescriptionRecodes().remove(prescriptionRecode);
		prescriptionRecode.setDrug(null);

		return prescriptionRecode;
	}

	public List<ZhuyuanFayaoXq> getZhuyuanFayaoXqs() {
		return this.zhuyuanFayaoXqs;
	}

	public void setZhuyuanFayaoXqs(List<ZhuyuanFayaoXq> zhuyuanFayaoXqs) {
		this.zhuyuanFayaoXqs = zhuyuanFayaoXqs;
	}

	public ZhuyuanFayaoXq addZhuyuanFayaoXq(ZhuyuanFayaoXq zhuyuanFayaoXq) {
		getZhuyuanFayaoXqs().add(zhuyuanFayaoXq);
		zhuyuanFayaoXq.setDrug(this);

		return zhuyuanFayaoXq;
	}

	public ZhuyuanFayaoXq removeZhuyuanFayaoXq(ZhuyuanFayaoXq zhuyuanFayaoXq) {
		getZhuyuanFayaoXqs().remove(zhuyuanFayaoXq);
		zhuyuanFayaoXq.setDrug(null);

		return zhuyuanFayaoXq;
	}

}