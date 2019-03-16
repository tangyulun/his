package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the QIAN_DAO database table.
 * 
 */
@Entity
@Table(name="QIAN_DAO")
@NamedQuery(name="QianDao.findAll", query="SELECT q FROM QianDao q")
public class QianDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QIAN_DAO_ID")
	private long qianDaoId;

	@Temporal(TemporalType.DATE)
	@Column(name="QIAN_DAO_DATE")
	private Date qianDaoDate;

	@Column(name="QIAN_DAO_TIMES")
	private String qianDaoTimes;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	public QianDao() {
	}

	public long getQianDaoId() {
		return this.qianDaoId;
	}

	public void setQianDaoId(long qianDaoId) {
		this.qianDaoId = qianDaoId;
	}

	public Date getQianDaoDate() {
		return this.qianDaoDate;
	}

	public void setQianDaoDate(Date qianDaoDate) {
		this.qianDaoDate = qianDaoDate;
	}

	public String getQianDaoTimes() {
		return this.qianDaoTimes;
	}

	public void setQianDaoTimes(String qianDaoTimes) {
		this.qianDaoTimes = qianDaoTimes;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}