package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the QX_USE database table.
 * 
 */
@Entity
@Table(name="QX_USE")
@NamedQuery(name="QxUse.findAll", query="SELECT q FROM QxUse q")
public class QxUse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_USE_ID")
	private String qxUseId;

	@Temporal(TemporalType.DATE)
	@Column(name="QX_USE_DATE")
	private Date qxUseDate;

	@Column(name="QX_USE_DUIX")
	private String qxUseDuix;

	@Column(name="QX_USE_KESHI")
	private String qxUseKeshi;

	@Column(name="QX_USE_STATE")
	private String qxUseState;

	@Column(name="QX_USE_WAREHOUSE")
	private String qxUseWarehouse;

	//bi-directional many-to-one association to QxUseqx
	@OneToMany(mappedBy="qxUse")
	private List<QxUseqx> qxUseqxs;

	public QxUse() {
	}

	public String getQxUseId() {
		return this.qxUseId;
	}

	public void setQxUseId(String qxUseId) {
		this.qxUseId = qxUseId;
	}

	public Date getQxUseDate() {
		return this.qxUseDate;
	}

	public void setQxUseDate(Date qxUseDate) {
		this.qxUseDate = qxUseDate;
	}

	public String getQxUseDuix() {
		return this.qxUseDuix;
	}

	public void setQxUseDuix(String qxUseDuix) {
		this.qxUseDuix = qxUseDuix;
	}

	public String getQxUseKeshi() {
		return this.qxUseKeshi;
	}

	public void setQxUseKeshi(String qxUseKeshi) {
		this.qxUseKeshi = qxUseKeshi;
	}

	public String getQxUseState() {
		return this.qxUseState;
	}

	public void setQxUseState(String qxUseState) {
		this.qxUseState = qxUseState;
	}

	public String getQxUseWarehouse() {
		return this.qxUseWarehouse;
	}

	public void setQxUseWarehouse(String qxUseWarehouse) {
		this.qxUseWarehouse = qxUseWarehouse;
	}

	public List<QxUseqx> getQxUseqxs() {
		return this.qxUseqxs;
	}

	public void setQxUseqxs(List<QxUseqx> qxUseqxs) {
		this.qxUseqxs = qxUseqxs;
	}

	public QxUseqx addQxUseqx(QxUseqx qxUseqx) {
		getQxUseqxs().add(qxUseqx);
		qxUseqx.setQxUse(this);

		return qxUseqx;
	}

	public QxUseqx removeQxUseqx(QxUseqx qxUseqx) {
		getQxUseqxs().remove(qxUseqx);
		qxUseqx.setQxUse(null);

		return qxUseqx;
	}

}