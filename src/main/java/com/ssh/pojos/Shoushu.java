package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SHOUSHU database table.
 * 
 */
@Entity
@NamedQuery(name="Shoushu.findAll", query="SELECT s FROM Shoushu s")
public class Shoushu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SHOUSHU_ID")
	private String shoushuId;

	@Column(name="SHOUSHU_EXPLAIN")
	private String shoushuExplain;

	@Column(name="SHOUSHU_NAME")
	private String shoushuName;

	@Column(name="SHOUSHU_REMARK")
	private String shoushuRemark;

	@Column(name="SHOUSHU_TYPE")
	private String shoushuType;

	//bi-directional many-to-one association to Dclass
	@ManyToOne
	@JoinColumn(name="DCLASS_ID")
	private Dclass dclass;

	//bi-directional many-to-one association to Emp
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	private Emp emp;

	//bi-directional many-to-one association to ShoushuType
	@ManyToOne
	@JoinColumn(name="SHOUSHU_TYPE_ID")
	private ShoushuType shoushuTypeBean;

	//bi-directional many-to-one association to ShoushuMess
	@OneToMany(mappedBy="shoushu")
	private List<ShoushuMess> shoushuMesses;

	public Shoushu() {
	}

	public String getShoushuId() {
		return this.shoushuId;
	}

	public void setShoushuId(String shoushuId) {
		this.shoushuId = shoushuId;
	}

	public String getShoushuExplain() {
		return this.shoushuExplain;
	}

	public void setShoushuExplain(String shoushuExplain) {
		this.shoushuExplain = shoushuExplain;
	}

	public String getShoushuName() {
		return this.shoushuName;
	}

	public void setShoushuName(String shoushuName) {
		this.shoushuName = shoushuName;
	}

	public String getShoushuRemark() {
		return this.shoushuRemark;
	}

	public void setShoushuRemark(String shoushuRemark) {
		this.shoushuRemark = shoushuRemark;
	}

	public String getShoushuType() {
		return this.shoushuType;
	}

	public void setShoushuType(String shoushuType) {
		this.shoushuType = shoushuType;
	}

	public Dclass getDclass() {
		return this.dclass;
	}

	public void setDclass(Dclass dclass) {
		this.dclass = dclass;
	}

	public Emp getEmp() {
		return this.emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public ShoushuType getShoushuTypeBean() {
		return this.shoushuTypeBean;
	}

	public void setShoushuTypeBean(ShoushuType shoushuTypeBean) {
		this.shoushuTypeBean = shoushuTypeBean;
	}

	public List<ShoushuMess> getShoushuMesses() {
		return this.shoushuMesses;
	}

	public void setShoushuMesses(List<ShoushuMess> shoushuMesses) {
		this.shoushuMesses = shoushuMesses;
	}

	public ShoushuMess addShoushuMess(ShoushuMess shoushuMess) {
		getShoushuMesses().add(shoushuMess);
		shoushuMess.setShoushu(this);

		return shoushuMess;
	}

	public ShoushuMess removeShoushuMess(ShoushuMess shoushuMess) {
		getShoushuMesses().remove(shoushuMess);
		shoushuMess.setShoushu(null);

		return shoushuMess;
	}

}