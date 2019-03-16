package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the LOGIN_LOGGER database table.
 * 
 */
@Entity
@Table(name="LOGIN_LOGGER")
@NamedQuery(name="LoginLogger.findAll", query="SELECT l FROM LoginLogger l")
public class LoginLogger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LOGIN_LOGGER")
	private long loginLogger;

	@Temporal(TemporalType.DATE)
	@Column(name="LOGIN_DATE")
	private Date loginDate;

	@Column(name="LOGIN_TIMES")
	private String loginTimes;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	public LoginLogger() {
	}

	public long getLoginLogger() {
		return this.loginLogger;
	}

	public void setLoginLogger(long loginLogger) {
		this.loginLogger = loginLogger;
	}

	public Date getLoginDate() {
		return this.loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(String loginTimes) {
		this.loginTimes = loginTimes;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

}