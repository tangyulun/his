package com.ssh.pojos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ROLES" database table.
 * 
 */
@Entity
@Table(name="\"ROLES\"")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLES_ID")
	private long rolesId;

	@Temporal(TemporalType.DATE)
	@Column(name="ROLES_DATE")
	private Date rolesDate;

	@Column(name="ROLES_EFFECT")
	private String rolesEffect;

	@Column(name="ROLES_NAME")
	private String rolesName;

	//bi-directional many-to-many association to Emp
	//bi-directional many-to-many association to Emp
	@ManyToMany(mappedBy="roles")
	private List<Emp> emps;

	//bi-directional many-to-many association to Function
	@ManyToMany
	@JoinTable(
		name="ROLES_FUNCTIONS"
		, joinColumns={
			@JoinColumn(name="ROLES_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FUNCTIONS_ID")
			}
		)
	private List<Function> functions;

	public Role() {
	}

	public long getRolesId() {
		return this.rolesId;
	}

	public void setRolesId(long rolesId) {
		this.rolesId = rolesId;
	}

	public Date getRolesDate() {
		return this.rolesDate;
	}

	public void setRolesDate(Date rolesDate) {
		this.rolesDate = rolesDate;
	}

	public String getRolesEffect() {
		return this.rolesEffect;
	}

	public void setRolesEffect(String rolesEffect) {
		this.rolesEffect = rolesEffect;
	}

	public String getRolesName() {
		return this.rolesName;
	}

	public void setRolesName(String rolesName) {
		this.rolesName = rolesName;
	}

	public List<Emp> getEmps() {
		return this.emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public List<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

}