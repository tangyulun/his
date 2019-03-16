package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the JIANYAN_MESS_XQ database table.
 * 
 */
@Entity
@Table(name="JIANYAN_MESS_XQ")
@NamedQuery(name="JianyanMessXq.findAll", query="SELECT j FROM JianyanMessXq j")
public class JianyanMessXq implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JIANYAN_MESS_XQ_ID")
	private long jianyanMessXqId;

	@Column(name="JIANYAN_MESS_XQ")
	private String jianyanMessXq;

	@Column(name="JIANYAN_MESS_XQ_BETWEEN")
	private String jianyanMessXqBetween;

	@Column(name="JIANYAN_MESS_XQ_RESULT")
	private String jianyanMessXqResult;

	//bi-directional many-to-one association to Jianyan
	@ManyToOne
	@JoinColumn(name="JIANYAN_ID")
	private Jianyan jianyan;

	//bi-directional many-to-one association to JianyanMess
	@ManyToOne
	@JoinColumn(name="JIANYAN_MESS_ID")
	private JianyanMess jianyanMess;

	public JianyanMessXq() {
	}

	public long getJianyanMessXqId() {
		return this.jianyanMessXqId;
	}

	public void setJianyanMessXqId(long jianyanMessXqId) {
		this.jianyanMessXqId = jianyanMessXqId;
	}

	public String getJianyanMessXq() {
		return this.jianyanMessXq;
	}

	public void setJianyanMessXq(String jianyanMessXq) {
		this.jianyanMessXq = jianyanMessXq;
	}

	public String getJianyanMessXqBetween() {
		return this.jianyanMessXqBetween;
	}

	public void setJianyanMessXqBetween(String jianyanMessXqBetween) {
		this.jianyanMessXqBetween = jianyanMessXqBetween;
	}

	public String getJianyanMessXqResult() {
		return this.jianyanMessXqResult;
	}

	public void setJianyanMessXqResult(String jianyanMessXqResult) {
		this.jianyanMessXqResult = jianyanMessXqResult;
	}

	public Jianyan getJianyan() {
		return this.jianyan;
	}

	public void setJianyan(Jianyan jianyan) {
		this.jianyan = jianyan;
	}

	public JianyanMess getJianyanMess() {
		return this.jianyanMess;
	}

	public void setJianyanMess(JianyanMess jianyanMess) {
		this.jianyanMess = jianyanMess;
	}

}