package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ZHIWU database table.
 * 
 */
@Entity
@NamedQuery(name="Zhiwu.findAll", query="SELECT z FROM Zhiwu z")
public class Zhiwu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ZHIWU_ID")
	private long zhiwuId;

	@Column(name="ZHIWU_NAME")
	private String zhiwuName;

	//bi-directional many-to-one association to Emp
	@OneToMany(mappedBy="zhiwu")
	private List<Emp> emps;

	//bi-directional many-to-one association to Dept
	@ManyToOne
	@JoinColumn(name="DEPT_ID")
	private Dept dept;

	public Zhiwu() {
	}

	public long getZhiwuId() {
		return this.zhiwuId;
	}

	public void setZhiwuId(long zhiwuId) {
		this.zhiwuId = zhiwuId;
	}

	public String getZhiwuName() {
		return this.zhiwuName;
	}

	public void setZhiwuName(String zhiwuName) {
		this.zhiwuName = zhiwuName;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Emp addEmp(Emp emp) {
		getEmps().add(emp);
		emp.setZhiwu(this);

		return emp;
	}

	public Emp removeEmp(Emp emp) {
		getEmps().remove(emp);
		emp.setZhiwu(null);

		return emp;
	}

	public Dept getDept() {
		return this.dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

}