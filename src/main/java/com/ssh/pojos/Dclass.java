package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DCLASS database table.
 * 
 */
@Entity
@NamedQuery(name="Dclass.findAll", query="SELECT d FROM Dclass d")
public class Dclass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DCLASS_ID")
	private long dclassId;

	@Column(name="DCLASS_ADDRESS")
	private String dclassAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="DCLASS_CREATE_DATE")
	private Date dclassCreateDate;

	@Column(name="DCLASS_EXPLAIN")
	private String dclassExplain;

	@Column(name="DCLASS_FUZE_NAME")
	private String dclassFuzeName;

	@Column(name="DCLASS_GRADE")
	private String dclassGrade;

	@Column(name="DCLASS_NAME")
	private String dclassName;

	@Column(name="DCLASS_REMARK")
	private String dclassRemark;

	@Column(name="DCLASS_STATE")
	private String dclassState;

	//bi-directional many-to-one association to Dept
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Dept dept;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="dclass")
	private List<Emp> emps;

	//bi-directional many-to-one association to OutpaitentRegist
	@OneToMany(mappedBy="dclass")
	private List<OutpaitentRegist> outpaitentRegists;

	//bi-directional many-to-one association to Shoushu
	@OneToMany(mappedBy="dclass")
	private List<Shoushu> shoushus;

	public Dclass() {
	}

	public long getDclassId() {
		return this.dclassId;
	}

	public void setDclassId(long dclassId) {
		this.dclassId = dclassId;
	}

	public String getDclassAddress() {
		return this.dclassAddress;
	}

	public void setDclassAddress(String dclassAddress) {
		this.dclassAddress = dclassAddress;
	}

	public Date getDclassCreateDate() {
		return this.dclassCreateDate;
	}

	public void setDclassCreateDate(Date dclassCreateDate) {
		this.dclassCreateDate = dclassCreateDate;
	}

	public String getDclassExplain() {
		return this.dclassExplain;
	}

	public void setDclassExplain(String dclassExplain) {
		this.dclassExplain = dclassExplain;
	}

	public String getDclassFuzeName() {
		return this.dclassFuzeName;
	}

	public void setDclassFuzeName(String dclassFuzeName) {
		this.dclassFuzeName = dclassFuzeName;
	}

	public String getDclassGrade() {
		return this.dclassGrade;
	}

	public void setDclassGrade(String dclassGrade) {
		this.dclassGrade = dclassGrade;
	}

	public String getDclassName() {
		return this.dclassName;
	}

	public void setDclassName(String dclassName) {
		this.dclassName = dclassName;
	}

	public String getDclassRemark() {
		return this.dclassRemark;
	}

	public void setDclassRemark(String dclassRemark) {
		this.dclassRemark = dclassRemark;
	}

	public String getDclassState() {
		return this.dclassState;
	}

	public void setDclassState(String dclassState) {
		this.dclassState = dclassState;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setDclass(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setDclass(null);

		return emp;
	}

	public List<OutpaitentRegist> getOutpaitentRegists() {
		return this.outpaitentRegists;
	}

	public void setOutpaitentRegists(List<OutpaitentRegist> outpaitentRegists) {
		this.outpaitentRegists = outpaitentRegists;
	}

	public OutpaitentRegist addOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		getOutpaitentRegists().add(outpaitentRegist);
		outpaitentRegist.setDclass(this);

		return outpaitentRegist;
	}

	public OutpaitentRegist removeOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		getOutpaitentRegists().remove(outpaitentRegist);
		outpaitentRegist.setDclass(null);

		return outpaitentRegist;
	}

	public List<Shoushu> getShoushus() {
		return this.shoushus;
	}

	public void setShoushus(List<Shoushu> shoushus) {
		this.shoushus = shoushus;
	}

	public Shoushu addShoushus(Shoushu shoushus) {
		getShoushus().add(shoushus);
		shoushus.setDclass(this);

		return shoushus;
	}

	public Shoushu removeShoushus(Shoushu shoushus) {
		getShoushus().remove(shoushus);
		shoushus.setDclass(null);

		return shoushus;
	}

}