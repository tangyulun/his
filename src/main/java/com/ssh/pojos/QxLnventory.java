package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the QX_LNVENTORY database table.
 * 
 */
@Entity
@Table(name="QX_LNVENTORY")
@NamedQuery(name="QxLnventory.findAll", query="SELECT q FROM QxLnventory q")
public class QxLnventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QX_LNVENTORY_ID")
	private String qxLnventoryId;

	@Temporal(TemporalType.DATE)
	@Column(name="QX_LNVENTORY_DATE")
	private Date qxLnventoryDate;

	@Column(name="QX_LNVENTORY_STATE")
	private BigDecimal qxLnventoryState;

	@Column(name="QX_LNVENTORY_WAREHOUSE")
	private String qxLnventoryWarehouse;

	//bi-directional many-to-one association to QxLnventoryqx
	@OneToMany(mappedBy="qxLnventory")
	private List<QxLnventoryqx> qxLnventoryqxs;

	public QxLnventory() {
	}

	public String getQxLnventoryId() {
		return this.qxLnventoryId;
	}

	public void setQxLnventoryId(String qxLnventoryId) {
		this.qxLnventoryId = qxLnventoryId;
	}

	public Date getQxLnventoryDate() {
		return this.qxLnventoryDate;
	}

	public void setQxLnventoryDate(Date qxLnventoryDate) {
		this.qxLnventoryDate = qxLnventoryDate;
	}

	public BigDecimal getQxLnventoryState() {
		return this.qxLnventoryState;
	}

	public void setQxLnventoryState(BigDecimal qxLnventoryState) {
		this.qxLnventoryState = qxLnventoryState;
	}

	public String getQxLnventoryWarehouse() {
		return this.qxLnventoryWarehouse;
	}

	public void setQxLnventoryWarehouse(String qxLnventoryWarehouse) {
		this.qxLnventoryWarehouse = qxLnventoryWarehouse;
	}

	public List<QxLnventoryqx> getQxLnventoryqxs() {
		return this.qxLnventoryqxs;
	}

	public void setQxLnventoryqxs(List<QxLnventoryqx> qxLnventoryqxs) {
		this.qxLnventoryqxs = qxLnventoryqxs;
	}

	public QxLnventoryqx addQxLnventoryqx(QxLnventoryqx qxLnventoryqx) {
		getQxLnventoryqxs().add(qxLnventoryqx);
		qxLnventoryqx.setQxLnventory(this);

		return qxLnventoryqx;
	}

	public QxLnventoryqx removeQxLnventoryqx(QxLnventoryqx qxLnventoryqx) {
		getQxLnventoryqxs().remove(qxLnventoryqx);
		qxLnventoryqx.setQxLnventory(null);

		return qxLnventoryqx;
	}

}