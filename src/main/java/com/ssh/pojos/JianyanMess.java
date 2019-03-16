package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the JIANYAN_MESS database table.
 * 
 */
@Entity
@Table(name="JIANYAN_MESS")
@NamedQuery(name="JianyanMess.findAll", query="SELECT j FROM JianyanMess j")
public class JianyanMess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JIANYAN_MESS_ID")
	private String jianyanMessId;

	@Temporal(TemporalType.DATE)
	@Column(name="JIANYAN_MESS_DATE")
	private Date jianyanMessDate;

	@Column(name="JIANYAN_MESS_DCLASS")
	private String jianyanMessDclass;

	@Column(name="JIANYAN_MESS_STATE")
	private String jianyanMessState;

	@Column(name="JIANYAN_MESS_YANGBEN_TYPE")
	private String jianyanMessYangbenType;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to OutpaitentRegist
	@ManyToOne
	@JoinColumn(name="OUTPAITENT_REGIST_ID")
	private OutpaitentRegist outpaitentRegist;

	//bi-directional many-to-one association to JianyanMessXq
	@OneToMany(mappedBy="jianyanMess")
	private List<JianyanMessXq> jianyanMessXqs;

	public JianyanMess() {
	}

	public String getJianyanMessId() {
		return this.jianyanMessId;
	}

	public void setJianyanMessId(String jianyanMessId) {
		this.jianyanMessId = jianyanMessId;
	}

	public Date getJianyanMessDate() {
		return this.jianyanMessDate;
	}

	public void setJianyanMessDate(Date jianyanMessDate) {
		this.jianyanMessDate = jianyanMessDate;
	}

	public String getJianyanMessDclass() {
		return this.jianyanMessDclass;
	}

	public void setJianyanMessDclass(String jianyanMessDclass) {
		this.jianyanMessDclass = jianyanMessDclass;
	}

	public String getJianyanMessState() {
		return this.jianyanMessState;
	}

	public void setJianyanMessState(String jianyanMessState) {
		this.jianyanMessState = jianyanMessState;
	}

	public String getJianyanMessYangbenType() {
		return this.jianyanMessYangbenType;
	}

	public void setJianyanMessYangbenType(String jianyanMessYangbenType) {
		this.jianyanMessYangbenType = jianyanMessYangbenType;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public OutpaitentRegist getOutpaitentRegist() {
		return this.outpaitentRegist;
	}

	public void setOutpaitentRegist(OutpaitentRegist outpaitentRegist) {
		this.outpaitentRegist = outpaitentRegist;
	}

	public List<JianyanMessXq> getJianyanMessXqs() {
		return this.jianyanMessXqs;
	}

	public void setJianyanMessXqs(List<JianyanMessXq> jianyanMessXqs) {
		this.jianyanMessXqs = jianyanMessXqs;
	}

	public JianyanMessXq addJianyanMessXq(JianyanMessXq jianyanMessXq) {
		getJianyanMessXqs().add(jianyanMessXq);
		jianyanMessXq.setJianyanMess(this);

		return jianyanMessXq;
	}

	public JianyanMessXq removeJianyanMessXq(JianyanMessXq jianyanMessXq) {
		getJianyanMessXqs().remove(jianyanMessXq);
		jianyanMessXq.setJianyanMess(null);

		return jianyanMessXq;
	}

}