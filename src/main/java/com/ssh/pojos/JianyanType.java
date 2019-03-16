package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the JIANYAN_TYPE database table.
 * 
 */
@Entity
@Table(name="JIANYAN_TYPE")
@NamedQuery(name="JianyanType.findAll", query="SELECT j FROM JianyanType j")
public class JianyanType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="JIANYAN_TYPE_ID")
	private long jianyanTypeId;

	@Column(name="JIANYAN_TYPE_NAME")
	private String jianyanTypeName;

	//bi-directional many-to-one association to Jianyan
	@OneToMany(mappedBy="jianyanType")
	private List<Jianyan> jianyans;

	public JianyanType() {
	}

	public long getJianyanTypeId() {
		return this.jianyanTypeId;
	}

	public void setJianyanTypeId(long jianyanTypeId) {
		this.jianyanTypeId = jianyanTypeId;
	}

	public String getJianyanTypeName() {
		return this.jianyanTypeName;
	}

	public void setJianyanTypeName(String jianyanTypeName) {
		this.jianyanTypeName = jianyanTypeName;
	}

	public List<Jianyan> getJianyans() {
		return this.jianyans;
	}

	public void setJianyans(List<Jianyan> jianyans) {
		this.jianyans = jianyans;
	}

	public Jianyan addJianyan(Jianyan jianyan) {
		getJianyans().add(jianyan);
		jianyan.setJianyanType(this);

		return jianyan;
	}

	public Jianyan removeJianyan(Jianyan jianyan) {
		getJianyans().remove(jianyan);
		jianyan.setJianyanType(null);

		return jianyan;
	}

}