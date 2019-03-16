package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BED database table.
 * 
 */
@Entity
@NamedQuery(name="Bed.findAll", query="SELECT b FROM Bed b")
public class Bed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BED_ID")
	private String bedId;

	@Temporal(TemporalType.DATE)
	@Column(name="BED_CREATE_DATE")
	private Date bedCreateDate;

	@Column(name="BED_NAME")
	private String bedName;

	@Column(name="BED_REMARK")
	private String bedRemark;

	@Column(name="HOUSE_BINGQU")
	private String houseBingqu;

	@Column(name="HOUSE_STATE")
	private String houseState;

	//bi-directional many-to-one association to BedType
	@ManyToOne
	@JoinColumn(name="BED_TYPE_ID")
	private BedType bedType;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to HouseType
	@ManyToOne
	@JoinColumn(name="HOUSE_TYPE_ID")
	private HouseType houseType;

	//bi-directional many-to-one association to BedTiaozheng
	@OneToMany(mappedBy="bed")
	private List<BedTiaozheng> bedTiaozhengs;

	//bi-directional many-to-one association to HospitalRegistration
	@OneToMany(mappedBy="bed")
	private List<HospitalRegistration> hospitalRegistrations;

	public Bed() {
	}

	public String getBedId() {
		return this.bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public Date getBedCreateDate() {
		return this.bedCreateDate;
	}

	public void setBedCreateDate(Date bedCreateDate) {
		this.bedCreateDate = bedCreateDate;
	}

	public String getBedName() {
		return this.bedName;
	}

	public void setBedName(String bedName) {
		this.bedName = bedName;
	}

	public String getBedRemark() {
		return this.bedRemark;
	}

	public void setBedRemark(String bedRemark) {
		this.bedRemark = bedRemark;
	}

	public String getHouseBingqu() {
		return this.houseBingqu;
	}

	public void setHouseBingqu(String houseBingqu) {
		this.houseBingqu = houseBingqu;
	}

	public String getHouseState() {
		return this.houseState;
	}

	public void setHouseState(String houseState) {
		this.houseState = houseState;
	}

	public BedType getBedType() {
		return this.bedType;
	}

	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public HouseType getHouseType() {
		return this.houseType;
	}

	public void setHouseType(HouseType houseType) {
		this.houseType = houseType;
	}

	public List<BedTiaozheng> getBedTiaozhengs() {
		return this.bedTiaozhengs;
	}

	public void setBedTiaozhengs(List<BedTiaozheng> bedTiaozhengs) {
		this.bedTiaozhengs = bedTiaozhengs;
	}

	public BedTiaozheng addBedTiaozheng(BedTiaozheng bedTiaozheng) {
		getBedTiaozhengs().add(bedTiaozheng);
		bedTiaozheng.setBed(this);

		return bedTiaozheng;
	}

	public BedTiaozheng removeBedTiaozheng(BedTiaozheng bedTiaozheng) {
		getBedTiaozhengs().remove(bedTiaozheng);
		bedTiaozheng.setBed(null);

		return bedTiaozheng;
	}

	public List<HospitalRegistration> getHospitalRegistrations() {
		return this.hospitalRegistrations;
	}

	public void setHospitalRegistrations(List<HospitalRegistration> hospitalRegistrations) {
		this.hospitalRegistrations = hospitalRegistrations;
	}

	public HospitalRegistration addHospitalRegistration(HospitalRegistration hospitalRegistration) {
		getHospitalRegistrations().add(hospitalRegistration);
		hospitalRegistration.setBed(this);

		return hospitalRegistration;
	}

	public HospitalRegistration removeHospitalRegistration(HospitalRegistration hospitalRegistration) {
		getHospitalRegistrations().remove(hospitalRegistration);
		hospitalRegistration.setBed(null);

		return hospitalRegistration;
	}

}