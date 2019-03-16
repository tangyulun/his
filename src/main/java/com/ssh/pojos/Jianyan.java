package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the JIANYAN database table.
 * 
 */
@Entity
@NamedQuery(name="Jianyan.findAll", query="SELECT j FROM Jianyan j")
public class Jianyan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JIANYAN_ID")
	private String jianyanId;

	@Column(name="JIANYAN_BETWEEN")
	private String jianyanBetween;

	@Temporal(TemporalType.DATE)
	@Column(name="JIANYAN_CREATE_DATE")
	private Date jianyanCreateDate;

	@Column(name="JIANYAN_NAME")
	private String jianyanName;

	@Column(name="JIANYAN_REMARK")
	private String jianyanRemark;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to JianyanType
	@ManyToOne
	@JoinColumn(name="JIANYAN_TYPE_ID")
	private JianyanType jianyanType;

	//bi-directional many-to-one association to Unit
	@ManyToOne
	@JoinColumn(name="UNITS_ID")
	private Unit unit;

	//bi-directional many-to-one association to JianyanMessXq
	@OneToMany(mappedBy="jianyan")
	private List<JianyanMessXq> jianyanMessXqs;

	public Jianyan() {
	}

	public String getJianyanId() {
		return this.jianyanId;
	}

	public void setJianyanId(String jianyanId) {
		this.jianyanId = jianyanId;
	}

	public String getJianyanBetween() {
		return this.jianyanBetween;
	}

	public void setJianyanBetween(String jianyanBetween) {
		this.jianyanBetween = jianyanBetween;
	}

	public Date getJianyanCreateDate() {
		return this.jianyanCreateDate;
	}

	public void setJianyanCreateDate(Date jianyanCreateDate) {
		this.jianyanCreateDate = jianyanCreateDate;
	}

	public String getJianyanName() {
		return this.jianyanName;
	}

	public void setJianyanName(String jianyanName) {
		this.jianyanName = jianyanName;
	}

	public String getJianyanRemark() {
		return this.jianyanRemark;
	}

	public void setJianyanRemark(String jianyanRemark) {
		this.jianyanRemark = jianyanRemark;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public JianyanType getJianyanType() {
		return this.jianyanType;
	}

	public void setJianyanType(JianyanType jianyanType) {
		this.jianyanType = jianyanType;
	}

	public Unit getUnit() {
		return this.unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public List<JianyanMessXq> getJianyanMessXqs() {
		return this.jianyanMessXqs;
	}

	public void setJianyanMessXqs(List<JianyanMessXq> jianyanMessXqs) {
		this.jianyanMessXqs = jianyanMessXqs;
	}

	public JianyanMessXq addJianyanMessXq(JianyanMessXq jianyanMessXq) {
		getJianyanMessXqs().add(jianyanMessXq);
		jianyanMessXq.setJianyan(this);

		return jianyanMessXq;
	}

	public JianyanMessXq removeJianyanMessXq(JianyanMessXq jianyanMessXq) {
		getJianyanMessXqs().remove(jianyanMessXq);
		jianyanMessXq.setJianyan(null);

		return jianyanMessXq;
	}

}