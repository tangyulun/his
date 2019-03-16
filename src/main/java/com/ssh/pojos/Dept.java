package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the DEPT database table.
 * 
 */
@Entity
@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="DEPT_ID")
	private long deptId;

	@Column(name="DEPT_ADDRESS")
	private String deptAddress;

	@Temporal(TemporalType.DATE)
	@Column(name="DEPT_CREATE_DATE")
	private Date deptCreateDate;

	@Column(name="DEPT_EXPLAIN")
	private String deptExplain;

	@Column(name="DEPT_FUZE_NAME")
	private String deptFuzeName;

	@Column(name="DEPT_GRADE")
	private String deptGrade;

	@Column(name="DEPT_NAME")
	private String deptName;

	@Temporal(TemporalType.DATE)
	@Column(name="DEPT_PIZHUN_DATE")
	private Date deptPizhunDate;

	@Column(name="DEPT_PIZHUN_NAME")
	private String deptPizhunName;

	@Column(name="DEPT_REMARK")
	private String deptRemark;

	@Temporal(TemporalType.DATE)
	@Column(name="DEPT_SHENHE_DATE")
	private Date deptShenheDate;

	@Column(name="DEPT_SHENHE_NAME")
	private String deptShenheName;

	@Column(name="DEPT_STATE")
	private String deptState;

	//bi-directional many-to-one association to Dclass
	@OneToMany(mappedBy="dept")
	private List<Dclass> dclasses;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="dept")
	private List<Emp> emps;

	//bi-directional many-to-one association to Zhiwu
	@OneToMany(mappedBy="dept")
	private List<Zhiwu> zhiwus;

	public Dept() {
	}

	public long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptAddress() {
		return this.deptAddress;
	}

	public void setDeptAddress(String deptAddress) {
		this.deptAddress = deptAddress;
	}

	public Date getDeptCreateDate() {
		return this.deptCreateDate;
	}

	public void setDeptCreateDate(Date deptCreateDate) {
		this.deptCreateDate = deptCreateDate;
	}

	public String getDeptExplain() {
		return this.deptExplain;
	}

	public void setDeptExplain(String deptExplain) {
		this.deptExplain = deptExplain;
	}

	public String getDeptFuzeName() {
		return this.deptFuzeName;
	}

	public void setDeptFuzeName(String deptFuzeName) {
		this.deptFuzeName = deptFuzeName;
	}

	public String getDeptGrade() {
		return this.deptGrade;
	}

	public void setDeptGrade(String deptGrade) {
		this.deptGrade = deptGrade;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Date getDeptPizhunDate() {
		return this.deptPizhunDate;
	}

	public void setDeptPizhunDate(Date deptPizhunDate) {
		this.deptPizhunDate = deptPizhunDate;
	}

	public String getDeptPizhunName() {
		return this.deptPizhunName;
	}

	public void setDeptPizhunName(String deptPizhunName) {
		this.deptPizhunName = deptPizhunName;
	}

	public String getDeptRemark() {
		return this.deptRemark;
	}

	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}

	public Date getDeptShenheDate() {
		return this.deptShenheDate;
	}

	public void setDeptShenheDate(Date deptShenheDate) {
		this.deptShenheDate = deptShenheDate;
	}

	public String getDeptShenheName() {
		return this.deptShenheName;
	}

	public void setDeptShenheName(String deptShenheName) {
		this.deptShenheName = deptShenheName;
	}

	public String getDeptState() {
		return this.deptState;
	}

	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}

	public List<Dclass> getDclasses() {
		return this.dclasses;
	}

	public void setDclasses(List<Dclass> dclasses) {
		this.dclasses = dclasses;
	}

	public Dclass addDclass(Dclass dclass) {
		getDclasses().add(dclass);
		dclass.setDept(this);

		return dclass;
	}

	public Dclass removeDclass(Dclass dclass) {
		getDclasses().remove(dclass);
		dclass.setDept(null);

		return dclass;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setDept(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setDept(null);

		return emp;
	}

	public List<Zhiwu> getZhiwus() {
		return this.zhiwus;
	}

	public void setZhiwus(List<Zhiwu> zhiwus) {
		this.zhiwus = zhiwus;
	}

	public Zhiwu addZhiwus(Zhiwu zhiwus) {
		getZhiwus().add(zhiwus);
		zhiwus.setDept(this);

		return zhiwus;
	}

	public Zhiwu removeZhiwus(Zhiwu zhiwus) {
		getZhiwus().remove(zhiwus);
		zhiwus.setDept(null);

		return zhiwus;
	}

}