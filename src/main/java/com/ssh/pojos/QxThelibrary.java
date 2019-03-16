package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the QX_THELIBRARY database table.
 * 
 */
@Entity
@Table(name="QX_THELIBRARY")
@NamedQuery(name="QxThelibrary.findAll", query="SELECT q FROM QxThelibrary q")
public class QxThelibrary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_THELIBRARY_ID")
	private String qxThelibraryId;

	@Temporal(TemporalType.DATE)
	@Column(name="QX_THELIBRARY_DATE")
	private Date qxThelibraryDate;

	@Column(name="QX_THELIBRARY_DUIXIANG")
	private String qxThelibraryDuixiang;

	@Column(name="QX_THELIBRARY_PZ_ID")
	private String qxThelibraryPzId;

	@Column(name="QX_THELIBRARY_STATE")
	private String qxThelibraryState;

	@Column(name="QX_THELIBRARY_TYPE")
	private String qxThelibraryType;

	@Column(name="QX_THELIBRARY_WAREHOUSE")
	private String qxThelibraryWarehouse;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to QxThelibraryqx
	@OneToMany(mappedBy="qxThelibrary")
	private List<QxThelibraryqx> qxThelibraryqxs;

	public QxThelibrary() {
	}

	public String getQxThelibraryId() {
		return this.qxThelibraryId;
	}

	public void setQxThelibraryId(String qxThelibraryId) {
		this.qxThelibraryId = qxThelibraryId;
	}

	public Date getQxThelibraryDate() {
		return this.qxThelibraryDate;
	}

	public void setQxThelibraryDate(Date qxThelibraryDate) {
		this.qxThelibraryDate = qxThelibraryDate;
	}

	public String getQxThelibraryDuixiang() {
		return this.qxThelibraryDuixiang;
	}

	public void setQxThelibraryDuixiang(String qxThelibraryDuixiang) {
		this.qxThelibraryDuixiang = qxThelibraryDuixiang;
	}

	public String getQxThelibraryPzId() {
		return this.qxThelibraryPzId;
	}

	public void setQxThelibraryPzId(String qxThelibraryPzId) {
		this.qxThelibraryPzId = qxThelibraryPzId;
	}

	public String getQxThelibraryState() {
		return this.qxThelibraryState;
	}

	public void setQxThelibraryState(String qxThelibraryState) {
		this.qxThelibraryState = qxThelibraryState;
	}

	public String getQxThelibraryType() {
		return this.qxThelibraryType;
	}

	public void setQxThelibraryType(String qxThelibraryType) {
		this.qxThelibraryType = qxThelibraryType;
	}

	public String getQxThelibraryWarehouse() {
		return this.qxThelibraryWarehouse;
	}

	public void setQxThelibraryWarehouse(String qxThelibraryWarehouse) {
		this.qxThelibraryWarehouse = qxThelibraryWarehouse;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public List<QxThelibraryqx> getQxThelibraryqxs() {
		return this.qxThelibraryqxs;
	}

	public void setQxThelibraryqxs(List<QxThelibraryqx> qxThelibraryqxs) {
		this.qxThelibraryqxs = qxThelibraryqxs;
	}

	public QxThelibraryqx addQxThelibraryqx(QxThelibraryqx qxThelibraryqx) {
		getQxThelibraryqxs().add(qxThelibraryqx);
		qxThelibraryqx.setQxThelibrary(this);

		return qxThelibraryqx;
	}

	public QxThelibraryqx removeQxThelibraryqx(QxThelibraryqx qxThelibraryqx) {
		getQxThelibraryqxs().remove(qxThelibraryqx);
		qxThelibraryqx.setQxThelibrary(null);

		return qxThelibraryqx;
	}

}