package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the QX_RETURN database table.
 * 
 */
@Entity
@Table(name="QX_RETURN")
@NamedQuery(name="QxReturn.findAll", query="SELECT q FROM QxReturn q")
public class QxReturn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_RETURN_ID")
	private String qxReturnId;

	@Temporal(TemporalType.DATE)
	@Column(name="QX_RETURN_DATE")
	private Date qxReturnDate;

	@Column(name="QX_RETURN_DUIXIANG")
	private String qxReturnDuixiang;

	@Column(name="QX_RETURN_KESHI")
	private String qxReturnKeshi;

	@Column(name="QX_RETURN_STATE")
	private String qxReturnState;

	@Column(name="QX_RETURN_WAREHOUSE")
	private String qxReturnWarehouse;

	//bi-directional many-to-one association to QxReturnqx
	@OneToMany(mappedBy="qxReturn")
	private List<QxReturnqx> qxReturnqxs;

	public QxReturn() {
	}

	public String getQxReturnId() {
		return this.qxReturnId;
	}

	public void setQxReturnId(String qxReturnId) {
		this.qxReturnId = qxReturnId;
	}

	public Date getQxReturnDate() {
		return this.qxReturnDate;
	}

	public void setQxReturnDate(Date qxReturnDate) {
		this.qxReturnDate = qxReturnDate;
	}

	public String getQxReturnDuixiang() {
		return this.qxReturnDuixiang;
	}

	public void setQxReturnDuixiang(String qxReturnDuixiang) {
		this.qxReturnDuixiang = qxReturnDuixiang;
	}

	public String getQxReturnKeshi() {
		return this.qxReturnKeshi;
	}

	public void setQxReturnKeshi(String qxReturnKeshi) {
		this.qxReturnKeshi = qxReturnKeshi;
	}

	public String getQxReturnState() {
		return this.qxReturnState;
	}

	public void setQxReturnState(String qxReturnState) {
		this.qxReturnState = qxReturnState;
	}

	public String getQxReturnWarehouse() {
		return this.qxReturnWarehouse;
	}

	public void setQxReturnWarehouse(String qxReturnWarehouse) {
		this.qxReturnWarehouse = qxReturnWarehouse;
	}

	public List<QxReturnqx> getQxReturnqxs() {
		return this.qxReturnqxs;
	}

	public void setQxReturnqxs(List<QxReturnqx> qxReturnqxs) {
		this.qxReturnqxs = qxReturnqxs;
	}

	public QxReturnqx addQxReturnqx(QxReturnqx qxReturnqx) {
		getQxReturnqxs().add(qxReturnqx);
		qxReturnqx.setQxReturn(this);

		return qxReturnqx;
	}

	public QxReturnqx removeQxReturnqx(QxReturnqx qxReturnqx) {
		getQxReturnqxs().remove(qxReturnqx);
		qxReturnqx.setQxReturn(null);

		return qxReturnqx;
	}

}