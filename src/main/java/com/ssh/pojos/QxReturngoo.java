package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the QX_RETURNGOOS database table.
 * 
 */
@Entity
@Table(name="QX_RETURNGOOS")
@NamedQuery(name="QxReturngoo.findAll", query="SELECT q FROM QxReturngoo q")
public class QxReturngoo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_RETURNGOOS_ID")
	private String qxReturngoosId;

	@Temporal(TemporalType.DATE)
	@Column(name="QX_RETURNGOOS_DATE")
	private Date qxReturngoosDate;

	@Column(name="QX_RETURNGOOS_MONEY")
	private BigDecimal qxReturngoosMoney;

	@Column(name="QX_RETURNGOOS_PZDH")
	private String qxReturngoosPzdh;

	@Column(name="QX_RETURNGOOS_SATAE")
	private String qxReturngoosSatae;

	//bi-directional many-to-one association to InstrumentY
	@ManyToOne
	@JoinColumn(name="INSTRUMENT_YS_ID")
	private InstrumentY instrumentY;

	//bi-directional many-to-one association to Supplier
	@ManyToOne
	@JoinColumn(name="SUPPLIER_ID")
	private Supplier supplier;

	//bi-directional many-to-one association to QxReturngoosqx
	@OneToMany(mappedBy="qxReturngoo")
	private List<QxReturngoosqx> qxReturngoosqxs;

	public QxReturngoo() {
	}

	public String getQxReturngoosId() {
		return this.qxReturngoosId;
	}

	public void setQxReturngoosId(String qxReturngoosId) {
		this.qxReturngoosId = qxReturngoosId;
	}

	public Date getQxReturngoosDate() {
		return this.qxReturngoosDate;
	}

	public void setQxReturngoosDate(Date qxReturngoosDate) {
		this.qxReturngoosDate = qxReturngoosDate;
	}

	public BigDecimal getQxReturngoosMoney() {
		return this.qxReturngoosMoney;
	}

	public void setQxReturngoosMoney(BigDecimal qxReturngoosMoney) {
		this.qxReturngoosMoney = qxReturngoosMoney;
	}

	public String getQxReturngoosPzdh() {
		return this.qxReturngoosPzdh;
	}

	public void setQxReturngoosPzdh(String qxReturngoosPzdh) {
		this.qxReturngoosPzdh = qxReturngoosPzdh;
	}

	public String getQxReturngoosSatae() {
		return this.qxReturngoosSatae;
	}

	public void setQxReturngoosSatae(String qxReturngoosSatae) {
		this.qxReturngoosSatae = qxReturngoosSatae;
	}

	public InstrumentY getInstrumentY() {
		return this.instrumentY;
	}

	public void setInstrumentY(InstrumentY instrumentY) {
		this.instrumentY = instrumentY;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<QxReturngoosqx> getQxReturngoosqxs() {
		return this.qxReturngoosqxs;
	}

	public void setQxReturngoosqxs(List<QxReturngoosqx> qxReturngoosqxs) {
		this.qxReturngoosqxs = qxReturngoosqxs;
	}

	public QxReturngoosqx addQxReturngoosqx(QxReturngoosqx qxReturngoosqx) {
		getQxReturngoosqxs().add(qxReturngoosqx);
		qxReturngoosqx.setQxReturngoo(this);

		return qxReturngoosqx;
	}

	public QxReturngoosqx removeQxReturngoosqx(QxReturngoosqx qxReturngoosqx) {
		getQxReturngoosqxs().remove(qxReturngoosqx);
		qxReturngoosqx.setQxReturngoo(null);

		return qxReturngoosqx;
	}

}